package net.notridani.apito.world.gen;

import net.notridani.apito.entity.ModEntities;

public class ModWorldGenneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();

        ModEntitySpanws.addSpawns();
    }
}
