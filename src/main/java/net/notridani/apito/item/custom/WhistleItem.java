package net.notridani.apito.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.custom.Chalk;
import net.notridani.apito.block.custom.PocketPortal;
import net.notridani.apito.component.ModDataComponentTypes;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.sound.ModSounds;

import java.util.*;

public class WhistleItem extends Item {
    private final TagKey<Instrument> instrumentTag;
    private final String tipo;
    private final int range;

    public WhistleItem(Settings settings, TagKey<Instrument> instrumentTag, String tipo, int range) {
        super(settings);
        this.instrumentTag = instrumentTag;
        this.tipo = tipo;
        this.range = range;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        Optional<RegistryEntry<Instrument>> optional = this.getInstrument(stack);
        return (Integer)optional.map(instrument -> ((Instrument)instrument.value()).useDuration()).orElse(0);
    }

    private Optional<RegistryEntry<Instrument>> getInstrument(ItemStack stack) {
        RegistryEntry<Instrument> registryEntry = stack.get(DataComponentTypes.INSTRUMENT);
        if (registryEntry != null) {
            return Optional.of(registryEntry);
        } else {
            Iterator<RegistryEntry<Instrument>> iterator = Registries.INSTRUMENT.iterateEntries(this.instrumentTag).iterator();
            return iterator.hasNext() ? Optional.of((RegistryEntry)iterator.next()) : Optional.empty();
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.apito.whistle." + tipo));
        super.appendTooltip(stack, context, tooltip, type);

        if(stack.get(ModDataComponentTypes.CORDINATES) != null) {
            tooltip.add(Text.literal("Cordenadas da porta: " + stack.get(ModDataComponentTypes.CORDINATES)));
        }
        if(stack.get(ModDataComponentTypes.PLAYER_NAME) != null) {
            tooltip.add(Text.literal("Utimo_usuario: " + stack.get(ModDataComponentTypes.PLAYER_NAME)));
        }
    }

    private static final Map<String, SoundEvent> TIPO_APITO =
            Map.of(
                    "palido", ModSounds.W_ASSOBIO,
                    "cobre", ModSounds.W_TCHU_TCHU,
                    "macabro", ModSounds.W_MACABRO,
                    "assombrado", ModSounds.W_fantasma,
                    "fiu_fiu", ModSounds.W_FIU_FIU
            );

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        Optional<? extends RegistryEntry<Instrument>> optional = this.getInstrument(itemStack);
        if (optional.isPresent()) {
            Instrument instrument = (Instrument)((RegistryEntry)optional.get()).value();
            user.setCurrentHand(hand);
            playSound(world, user, instrument);
            user.getItemCooldownManager().set(this, instrument.useDuration());
            user.incrementStat(Stats.USED.getOrCreateStat(this));


            //NBT
            itemStack.set(ModDataComponentTypes.CORDINATES, user.getBlockPos());
            itemStack.set(ModDataComponentTypes.PLAYER_NAME, user.getName().getString());

            //Transformar Giz em Portais

            ServerPlayerEntity serverPlayer = null;

            if(!world.isClient && user instanceof ServerPlayerEntity sp){
                serverPlayer = sp;
                ChalkToPortal(range, user.getBlockPos(), serverPlayer);
            }

            itemStack.damage(1, user, LivingEntity.getSlotForHand(hand));



            return TypedActionResult.consume(itemStack);
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }



    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    private void playSound(World world, PlayerEntity player, Instrument instrument) {
        SoundEvent soundEvent = instrument.soundEvent().value();
        float f = instrument.range() / 16.0F;
        world.playSound(
                null, player.getPos().getX(), player.getPos().getY(), player.getPos().getZ(), TIPO_APITO.get(tipo), SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
    }


    public static void ChalkToPortal(int range, BlockPos center, ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        int minX = center.getX() - range;
        int maxX = center.getX() + range;

        int minY = Math.max(world.getBottomY(), center.getY() - range);
        int maxY = Math.min(world.getTopY() - 1, center.getY() + range);

        int minZ = center.getZ() - range;
        int maxZ = center.getZ() + range;


        for(int x = minX; x <= maxX; x++) {
            for(int y = minY; y <= maxY; y++) {
                for(int z = minZ; z <= maxZ; z++) {

                    mutable.set(x,y,z);

                    if(world.getBlockState(mutable).isOf(ModBlocks.CHALK)) {

                        BlockState oldState = world.getBlockState(mutable);

                        Direction facing = oldState.get(Chalk.FACING);

                        BlockState newState = ModBlocks.POCKET_PORTAL.getDefaultState().with(PocketPortal.FACING, facing);

                        world.setBlockState(mutable, newState, 3);
                        world.syncWorldEvent(2001, mutable, Block.getRawIdFromState(newState));
                    }



                }
            }
        }
    }
}
