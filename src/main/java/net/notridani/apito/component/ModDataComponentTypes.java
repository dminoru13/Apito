package net.notridani.apito.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.notridani.apito.Apito;

import java.util.function.UnaryOperator;


public class ModDataComponentTypes {
    private  static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Apito.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Apito.LOGGER.info("Register data componente types for" + Apito.MOD_ID);
    }

    // Crie um record para organizar os dados
    public record WhistleData(int base, int entalhe, int gema, int tier) {
        public static final Codec<WhistleData> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.INT.fieldOf("base").forGetter(WhistleData::base),
                        Codec.INT.optionalFieldOf("entalhe", -1).forGetter(WhistleData::entalhe),
                        Codec.INT.optionalFieldOf("gema", -1).forGetter(WhistleData::gema),
                        Codec.INT.fieldOf("tier").forGetter(WhistleData::tier)
                ).apply(instance, WhistleData::new)
        );
    }

    // No seu ModDataComponentTypes, registre:
    public static final ComponentType<WhistleData> WHISTLE_DATA = register("whistle_data", builder -> builder.codec(WhistleData.CODEC));





}
