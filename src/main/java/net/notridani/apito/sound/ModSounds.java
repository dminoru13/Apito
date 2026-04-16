package net.notridani.apito.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public class ModSounds {
    public static final SoundEvent WSOUND1 = registerSoundEvent("wsound1");
    public static final SoundEvent WSOUND2 = registerSoundEvent("wsound2");
    public static final SoundEvent WSOUND3 = registerSoundEvent("wsound3");
    public static final SoundEvent WSOUND4 = registerSoundEvent("wsound4");
    public static final SoundEvent WSOUND5 = registerSoundEvent("wsound5");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Apito.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        Apito.LOGGER.info("Registering Mod Sounds for " + Apito.MOD_ID);
    }
}
