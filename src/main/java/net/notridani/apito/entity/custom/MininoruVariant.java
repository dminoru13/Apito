package net.notridani.apito.entity.custom;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Comparator;

public enum MininoruVariant {
    DEFAULT(0),
    AQUELE_CARA(1);

    private static final MininoruVariant[] BY_ID = Arrays.stream(values())
            .sorted(Comparator.comparingInt(MininoruVariant::getId))
            .toArray(MininoruVariant[]::new);
    private final int id;

    MininoruVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static MininoruVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
