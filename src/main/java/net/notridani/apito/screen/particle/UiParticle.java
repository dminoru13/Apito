package net.notridani.apito.screen.particle;

public class UiParticle {

    public float posX,posY;
    public float velocityX, velocityY;
    public int lifetime;
    public float gravity;
    public int cor;


    public UiParticle(float posX, float posY, float velocityX, float velocityY, int lifetime, float gravity) {
        this.posX = posX;
        this.posY = posY;
        this.velocityX = (float)(Math.random() -0.5) *velocityX;
        this.velocityY = (float)(Math.random() -0.5) * velocityY;
        this.gravity = gravity;
        this.lifetime = lifetime;

        int[] cor = new int[] {
                0xFF111119,
                0xFF646468,
                0xFF212141
        };

        this.cor = cor[java.util.concurrent.ThreadLocalRandom.current().nextInt(0, cor.length-1)];

    }

    public void tick() {
        posX += velocityX;
        posY += velocityY;
        velocityY += gravity;
        lifetime--;
    }

    public boolean isAlive() {
        return lifetime > 0;
    }
}
