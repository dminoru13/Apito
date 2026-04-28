package net.notridani.apito.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.notridani.apito.network.ButtonClickPayload;
import net.notridani.apito.network.ButtonAction;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.screen.widget.InvisibleButton;

public class CarvingBenchScreen extends HandledScreen<CarvingBenchScreenHandler> {

    private static final Identifier GUI_TEXTURE =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/carving_bench_gui.png");



    public CarvingBenchScreen(CarvingBenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);


        this.backgroundWidth = 220;
        this.backgroundHeight = 226;

        this.titleX = x + 7;
        this.titleY = y + 3;

        this.playerInventoryTitleX = x + 27;
        this.playerInventoryTitleY = y + 134;

    }

    @Override
    protected void init() {
        super.init();

        this.clearChildren();

        this.addDrawableChild(new InvisibleButton(x+9,y+55,41,57, this::onToolClick));
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader((GameRenderer::getPositionTexProgram));
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0,GUI_TEXTURE);

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX,mouseY);
        desenharPedra(context);
        desenharFerramentas(context);
    }

    //adicionar textura

    private static final Identifier TEXTURA_PEDRA =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/ancient_heart.png");

    private void desenharPedra(DrawContext context) {
        if(handler.tem_pedra()) {
            RenderSystem.setShaderTexture(0, TEXTURA_PEDRA);
            context.drawTexture(TEXTURA_PEDRA, x + 84, y + 55, 0, 0, 32, 32,32,32);
        }
    }

    private static final Identifier TEXTURA_FERRAMENTAS =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/tools.png");

    private static final Identifier TEXTURA_SEM_FERRAMENTAS =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/no_tools.png");

    private void desenharFerramentas(DrawContext context) {
        int ferramenta_x = 9;
        int ferramenta_y = 55;

        if(handler.usando_ferramentsa()) {
            RenderSystem.setShaderTexture(0, TEXTURA_SEM_FERRAMENTAS);
            context.drawTexture(TEXTURA_SEM_FERRAMENTAS, x + ferramenta_x, y + ferramenta_y, 0, 0, 41, 57,41,57);
        } else {
            RenderSystem.setShaderTexture(0, TEXTURA_FERRAMENTAS);
            context.drawTexture(TEXTURA_FERRAMENTAS, x + ferramenta_x, y + ferramenta_y, 0, 0, 41, 57,41,57);
        }
    }

    //BOTAO


    private void onToolClick() {
        client.player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), 1.0f, 1.0f);
        ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.TOGGLE_FERRAMENTA));
    }




}
