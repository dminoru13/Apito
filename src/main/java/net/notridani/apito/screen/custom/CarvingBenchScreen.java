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

        //ferramentas
        this.addDrawableChild(new InvisibleButton(x+9,y+55,41,57, this::onToolClick));

        //entalhe
        this.addDrawableChild(new InvisibleButton(x+150,y+25,27,32, this::SubEntalheClick));
        this.addDrawableChild(new InvisibleButton(x+185,y+25,24,32, this::AddEntalheClick));

        //base
        this.addDrawableChild(new InvisibleButton(x+150,y+57,27,32, this::SubBaseClick));
        this.addDrawableChild(new InvisibleButton(x+185,y+57,24,32, this::AddBaseClick));

        //coracao

        this.addDrawableChild(new InvisibleButton(x+93,y+49,24,32, this::CoracaoClick));
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
        desenharLivro(context);
    }

    //adicionar textura

    private static final Identifier TEXTURA_PEDRA =
            Identifier.of(Apito.MOD_ID, "textures/gui/carving_bench/ancient_heart.png");

    private void desenharPedra(DrawContext context) {
        if(handler.tem_pedra()) {
            RenderSystem.setShaderTexture(0, TEXTURA_PEDRA);
            context.drawTexture(TEXTURA_PEDRA, x + 93, y + 49, 0, 0, 32, 32,32,32);
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

    private void desenharLivro(DrawContext context) {
        int livro_x = 150;
        int livro_y = 25;
        int livro_width = 58;
        int livro_heigth = 31;

        boolean tem_pedra = handler.tem_pedra();
        int entalhe = handler.get_entalhe();
        int base = handler.get_base();

        Identifier[] LIVRO_CIMA = new Identifier[] {
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_cima-capa.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_cima-inicio.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_cima-maio.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_cima-final.png"),
        };

        Identifier[] LIVRO_BAIXO = new Identifier[] {
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_baixo-capa.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_baixo-inicio.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_baixo-maio.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/livrinho_baixo-final.png"),
        };

        Identifier TEXTURA_LIVRO_CIMA = LIVRO_CIMA[0];
        Identifier TEXTURA_LIVRO_BAIXO = LIVRO_BAIXO[0];

        if(!tem_pedra) {
            TEXTURA_LIVRO_CIMA = LIVRO_CIMA[0];
            TEXTURA_LIVRO_BAIXO = LIVRO_BAIXO[0];
        } else {

            //ENTALHE
            if(entalhe == 0) {
                TEXTURA_LIVRO_CIMA = LIVRO_CIMA[1];
            }

            if(entalhe > 0 && entalhe < LIVRO_CIMA.length ) {
                TEXTURA_LIVRO_CIMA = LIVRO_CIMA[2];
            }

            if(entalhe == LIVRO_CIMA.length) {
                TEXTURA_LIVRO_CIMA = LIVRO_CIMA[3];
            }

            //BASE
            if(base == 0) {
                TEXTURA_LIVRO_BAIXO = LIVRO_BAIXO[1];
            }

            if(base > 0 && base < LIVRO_BAIXO.length ) {
                TEXTURA_LIVRO_BAIXO = LIVRO_BAIXO[2];
            }

            if(base == LIVRO_BAIXO.length) {
                TEXTURA_LIVRO_BAIXO = LIVRO_BAIXO[3];
            }


        }



        RenderSystem.setShaderTexture(0, TEXTURA_LIVRO_CIMA);
        context.drawTexture(TEXTURA_LIVRO_CIMA, x + livro_x, y + livro_y, 0, 0, livro_width, livro_heigth, livro_width, livro_heigth);

        RenderSystem.setShaderTexture(0, TEXTURA_LIVRO_BAIXO);
        context.drawTexture(TEXTURA_LIVRO_BAIXO, x + livro_x, y + livro_y + livro_heigth, 0, 0, livro_width, livro_heigth, livro_width, livro_heigth);

        if(tem_pedra) {
            desenharIcones(context);
        }

    }


    private void desenharIcones( DrawContext context) {
        int icone_x = 150;
        int icone_y = 25;
        int icone_width = 64;
        int icone_heigth = 64;




        Identifier[] ENTALHES = new Identifier[] {
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_entalhe-0.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_entalhe-1.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_entalhe-2.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_entalhe-3.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_entalhe-4.png")
        };

        int Entalhe = handler.get_entalhe();

        Identifier TEXTURA_ENTALHE = ENTALHES[Entalhe];
        RenderSystem.setShaderTexture(0, TEXTURA_ENTALHE);
        context.drawTexture(TEXTURA_ENTALHE, x + icone_x, y + icone_y, 0, 0, icone_width, icone_heigth, icone_width, icone_heigth);


        Identifier[] BASES = new Identifier[] {
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_base-0.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_base-1.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_base-2.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_base-3.png"),
                Identifier.of(Apito.MOD_ID , "textures/gui/carving_bench/papel_base-4.png")
        };

        int Base = handler.get_base();

        Identifier TEXTURE_BASE = BASES[Base];
        RenderSystem.setShaderTexture(0, TEXTURE_BASE);
        context.drawTexture(TEXTURE_BASE, x + icone_x, y + icone_y, 0, 0, icone_width, icone_heigth, icone_width, icone_heigth);
    }

    //BOTAO


    private void onToolClick() {
        client.player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), 1.0f, 1.0f);
        ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.TOGGLE_FERRAMENTA));
    }

    private void AddEntalheClick() {
        if(handler.tem_pedra()){
            client.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0f, 1.0f);
            ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.ADD_ENTALHE));
        }
    }

    private void SubEntalheClick() {
        if(handler.tem_pedra()) {
            client.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0f, 1.0f);
            ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.SUB_ENTALHE));
        }
    }

    private void AddBaseClick() {
        if(handler.tem_pedra()) {
            client.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0f, 1.0f);
            ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.ADD_BASE));
        }
    }

    private void SubBaseClick() {
        if(handler.tem_pedra()) {
            client.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0f, 1.0f);
            ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.SUB_BASE));
        }
    }

    private void CoracaoClick() {
        if(handler.tem_pedra()) {
            client.player.playSound(SoundEvents.BLOCK_STONE_BREAK, 1.0f, 1.0f);
            ClientPlayNetworking.send(new ButtonClickPayload(ButtonAction.CORACAO));
        }
    }


}
