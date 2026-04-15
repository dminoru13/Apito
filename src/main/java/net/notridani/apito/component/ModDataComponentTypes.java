package net.notridani.apito.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.notridani.apito.Apito;

import java.util.function.UnaryOperator;


public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> CORDINATES = register("cordinates", builder -> builder.codec(BlockPos.CODEC));
    public static final ComponentType<String> PLAYER_NAME = register("player_name", builder -> builder.codec(Codec.STRING));


    private  static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Apito.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Apito.LOGGER.info("Register data componente types for" + Apito.MOD_ID);
    }
}
