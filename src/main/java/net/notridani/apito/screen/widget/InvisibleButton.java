package net.notridani.apito.screen.widget;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public class InvisibleButton extends PressableWidget {

    private static final Identifier TEXTURE =
            Identifier.of(Apito.MOD_ID, "textures/gui/invisible_button.png");

    private final Runnable onPress;


    public InvisibleButton(int x, int y, int width, int height, Runnable onPress) {
        super(x, y, width, height, Text.literal(""));
        this.onPress = onPress;
    }

    @Override
    public void onPress() {
        if (this.onPress != null) {
            this.onPress.run();
        }
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        int v = this.isHovered() ? this.height : 0;

        context.drawTexture(
                TEXTURE,
                this.getX(),
                this.getY(),
                0, v,
                this.width,
                this.height,
                this.width,
                this.height * 2
        );
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {

    }

    @Override
    public void playDownSound(net.minecraft.client.sound.SoundManager soundManager) {
        // não faz nada → cancela o som padrão
    }
}
