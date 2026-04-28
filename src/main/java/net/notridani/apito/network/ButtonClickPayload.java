package net.notridani.apito.network;

import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public record ButtonClickPayload(ButtonAction action) implements CustomPayload {

    public static final Id<ButtonClickPayload> ID =
            new Id<>(Identifier.of(Apito.MOD_ID, "button_click"));

    public static final PacketCodec<PacketByteBuf, ButtonClickPayload> CODEC =
            PacketCodec.tuple(
                    PacketCodecs.INTEGER,
                    payload -> payload.action().ordinal(),
                    i -> new ButtonClickPayload(ButtonAction.values()[i])
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}