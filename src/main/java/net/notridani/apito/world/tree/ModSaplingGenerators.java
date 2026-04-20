package net.notridani.apito.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.notridani.apito.Apito;
import net.notridani.apito.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator PETRIFIED_TREE = new SaplingGenerator(Apito.MOD_ID + ":petrified_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PETRIFIED_TREE_KEY), Optional.empty());
}
