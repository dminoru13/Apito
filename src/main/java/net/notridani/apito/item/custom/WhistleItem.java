package net.notridani.apito.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.notridani.apito.component.ModDataComponentTypes;

public class WhistleItem extends Item {

    private final int defaultTier;
    private final int defaultBase;
    private final int defaultEntalhe;
    private final int defaultGema;

    public WhistleItem(Settings settings, int tier, int base, int entalhe, int gema) {
        super(settings);
        this.defaultTier = tier;
        this.defaultBase = base;
        this.defaultEntalhe = entalhe;
        this.defaultGema = gema;
    }

    private void ensureData(ItemStack stack) {
        if (!stack.contains(ModDataComponentTypes.WHISTLE_DATA)) {

            stack.set(
                    ModDataComponentTypes.WHISTLE_DATA,
                    new ModDataComponentTypes.WhistleData(
                            defaultBase,
                            defaultEntalhe,
                            defaultGema,
                            defaultTier
                    )
            );
        }
    }

    public void setBase(ItemStack stack, int base) {
        var data = getData(stack);

        stack.set(ModDataComponentTypes.WHISTLE_DATA,
                new ModDataComponentTypes.WhistleData(
                        base,
                        data.entalhe(),
                        data.gema(),
                        data.tier()
                )
        );
    }

    public void setEntalhe(ItemStack stack, int entalhe) {
        var data = getData(stack);

        stack.set(ModDataComponentTypes.WHISTLE_DATA,
                new ModDataComponentTypes.WhistleData(
                        data.base(),
                        entalhe, // -1 = sem entalhe
                        data.gema(),
                        data.tier()
                )
        );
    }

    public void setGema(ItemStack stack, int gema) {
        var data = getData(stack);

        stack.set(ModDataComponentTypes.WHISTLE_DATA,
                new ModDataComponentTypes.WhistleData(
                        data.base(),
                        data.entalhe(),
                        gema, // -1 = sem gema
                        data.tier()
                )
        );
    }

    public void setTier(ItemStack stack, int tier) {
        var data = getData(stack);

        stack.set(ModDataComponentTypes.WHISTLE_DATA,
                new ModDataComponentTypes.WhistleData(
                        data.base(),
                        data.entalhe(),
                        data.gema(),
                        tier
                )
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            ensureData(stack);
        }
    }

    public ModDataComponentTypes.WhistleData getData(ItemStack stack) {
        return stack.getOrDefault(
                ModDataComponentTypes.WHISTLE_DATA,
                new ModDataComponentTypes.WhistleData(
                        defaultBase,
                        defaultEntalhe,
                        defaultGema,
                        defaultTier
                )
        );
    }
}