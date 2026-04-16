package net.notridani.apito.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public class ModSounds {
    public static final SoundEvent W_ASSOBIO = registerSoundEvent("w_assobio");
    public static final SoundEvent W_fantasma = registerSoundEvent("w_fantasma");
    public static final SoundEvent W_FIU_FIU = registerSoundEvent("w_fiu_fiu");
    public static final SoundEvent W_MACABRO = registerSoundEvent("w_macabro");
    public static final SoundEvent W_TCHU_TCHU = registerSoundEvent("w_tchu_tchu");

    //DISCOS DE MUSICA
    public static final SoundEvent D_ENDLESS_EMBRACE = registerSoundEvent("d_endless_embrace");
    public  static final RegistryKey<JukeboxSong> D_ENDLESS_EMBRACE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Apito.MOD_ID, "d_endless_embrace"));


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Apito.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        Apito.LOGGER.info("Registering Mod Sounds for " + Apito.MOD_ID);
    }
}
