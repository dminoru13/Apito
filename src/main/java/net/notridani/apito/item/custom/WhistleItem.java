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

    public void updateModel(ItemStack stack) {
        var data = getData(stack);

        int base = Math.max(0, data.base());
        int entalhe = data.entalhe(); // pode ser -1
        int gema = data.gema();       // pode ser -1
        int tier = Math.max(0, data.tier());

        int B = 4;
        int E = 6;
        int G = 6;

        int entalheIndex = entalhe + 1; // -1 → 0
        int gemaIndex = gema + 1;

        int cmd =
                tier * (B * E * G) +
                        base * (E * G) +
                        entalheIndex * G +
                        gemaIndex + 1;

        CustomModelDataComponent current =
                stack.get(DataComponentTypes.CUSTOM_MODEL_DATA);

        if (current == null || current.value() != cmd) {
            stack.set(
                    DataComponentTypes.CUSTOM_MODEL_DATA,
                    new CustomModelDataComponent(cmd)
            );
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            ensureData(stack);
            updateModel(stack);
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