package net.notridani.apito.screen.custom;

import io.wispforest.owo.ui.base.BaseOwoHandledScreen;
import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import org.jetbrains.annotations.NotNull;

public class CarvingBenchScreen extends BaseOwoHandledScreen<FlowLayout, CarvingBenchScreenHandler> {

    public CarvingBenchScreen(CarvingBenchScreenHandler handler,
                              PlayerInventory inventory,
                              Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    protected void build(FlowLayout root) {
        root
                .surface(Surface.VANILLA_TRANSLUCENT)
                .horizontalAlignment(HorizontalAlignment.CENTER)
                .verticalAlignment(VerticalAlignment.CENTER)
                .padding(Insets.of(0));

        var panel = Containers.verticalFlow(Sizing.fixed(218), Sizing.fixed(225));

        panel.surface((context, component) -> {
            context.drawTexture(
                    Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/carving_bench_gui.png"),
                    component.x(),
                    component.y(),
                    0, 0,
                    component.width(),
                    component.height(),
                    256, 256
            );
        });

        var customButton = Containers.stack(Sizing.fixed(41), Sizing.fixed(57));
        customButton.margins(Insets.of(40, 0, 7, 0));

        customButton.surface((context, component) -> {
            context.drawTexture(
                    net.minecraft.util.Identifier.of("apito", "textures/gui/carving_bench/carving_bench_tools.png"),
                    component.x(), component.y(),
                    0, 0,
                    component.width(), component.height(),
                    41, 57
            );
        });

        customButton.mouseDown().subscribe((mouseX, mouseY, button) -> {
            System.out.println("click");
            return true;
        });

        panel.child(Containers.verticalFlow(Sizing.fill(), Sizing.fill())
                .child(customButton)
                .verticalAlignment(VerticalAlignment.TOP)
                .horizontalAlignment(HorizontalAlignment.LEFT));


        root.child(panel);
    }
}