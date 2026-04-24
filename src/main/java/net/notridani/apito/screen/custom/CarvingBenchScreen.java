package net.notridani.apito.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public class CarvingBenchScreen extends HandledScreen<CarvingBenchScreenHandler> {

    private static final Identifier GUI_TEXTURE =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/carving_bench_gui.png");



    public CarvingBenchScreen(CarvingBenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.titleX = 10;
        this.titleY = -27;

        this.playerInventoryTitleX = 10;
        this.playerInventoryTitleY = 103;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        this.backgroundWidth = 220;
        this.backgroundHeight = 226;
        RenderSystem.setShader((GameRenderer::getPositionTexProgram));
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0,GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height -backgroundHeight)/ 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX,mouseY);
        desenharpedra(context);
    }

    //adicionar textura

    private static final Identifier TEXTURA_PEDRA =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/ancient_heart.png");

    private void desenharpedra(DrawContext context) {
        if(handler.tem_pedra()) {
            RenderSystem.setShaderTexture(0, TEXTURA_PEDRA);
            context.drawTexture(TEXTURA_PEDRA, 223, 78, 0, 0, 32, 32,32,32);
        }
    }






}
