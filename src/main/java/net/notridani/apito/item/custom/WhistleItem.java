package net.notridani.apito.item.custom;

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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.notridani.apito.component.ModDataComponentTypes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WhistleItem extends Item {
    private final TagKey<Instrument> instrumentTag;
    private final String tipo;

    public WhistleItem(Settings settings, TagKey<Instrument> instrumentTag, String tipo) {
        super(settings);
        this.instrumentTag = instrumentTag;
        this.tipo = tipo;
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
                    "palido", SoundEvents.ENTITY_GHAST_SCREAM,
                    "cobre", SoundEvents.ENTITY_GHAST_SHOOT
            );

    public static ItemStack getStackForInstrument(Item item, RegistryEntry<Instrument> instrument) {
        ItemStack itemStack = new ItemStack(item);
        itemStack.set(DataComponentTypes.INSTRUMENT, instrument);
        return itemStack;
    }

    public static void setRandomInstrumentFromTag(ItemStack stack, TagKey<Instrument> instrumentTag, Random random) {
        Optional<RegistryEntry<Instrument>> optional = Registries.INSTRUMENT.getRandomEntry(instrumentTag, random);
        optional.ifPresent(instrument -> stack.set(DataComponentTypes.INSTRUMENT, instrument));
    }

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


            return TypedActionResult.consume(itemStack);
        } else {
            return TypedActionResult.fail(itemStack);
        }
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
}
