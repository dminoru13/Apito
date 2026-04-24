package net.notridani.apito.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.notridani.apito.Apito;
import net.notridani.apito.screen.custom.CarvingBenchScreen;
import net.notridani.apito.screen.custom.CarvingBenchScreenHandler;

public class ModScreenHandler {

    public static final ScreenHandlerType<CarvingBenchScreenHandler> CARVING_BENCH_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Apito.MOD_ID, "carving_bench_screem_handler"),
                    new ExtendedScreenHandlerType<>(CarvingBenchScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Apito.LOGGER.info(("Registering Screen handlers for " + Apito.MOD_ID));
    }

}
