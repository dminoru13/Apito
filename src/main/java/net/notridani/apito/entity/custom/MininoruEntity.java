package net.notridani.apito.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.notridani.apito.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class MininoruEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MininoruEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new TemptGoal(this, 1.25D, stack -> stack.isOf(Blocks.MOSS_BLOCK.asItem()), true));
        this.goalSelector.add(2, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(3, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 0.5D, 1.0D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 15.0F));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, 5.0);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 30;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    private void setupWalkAnimationState() {
        if (this.getVelocity().horizontalLengthSquared() > 1.0E-6) {
            if (!this.walkAnimationState.isRunning()) {
                this.walkAnimationState.start(this.age);
            }
        } else {
            this.walkAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
            this.setupWalkAnimationState();
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (!this.getWorld().isClient) {
            if (this.random.nextInt(100) == 0) { // chance aleatória
                this.teleportRandomly();
            }
        }
    }

    protected boolean teleportRandomly() {
        double x = this.getX() + (this.random.nextDouble() - 0.5D) * 16.0D;
        double z = this.getZ() + (this.random.nextDouble() - 0.5D) * 16.0D;

        // pega altura segura do terreno
        int y = this.getWorld().getTopY(net.minecraft.world.Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (int)x, (int)z);

        return this.teleportTo(x, y, z);
    }

    private boolean teleportTo(double x, double y, double z) {
        if (!this.getWorld().isChunkLoaded((int)x >> 4, (int)z >> 4)) {
            return false;
        }

        // salva posição antiga
        double oldX = this.getX();
        double oldY = this.getY();
        double oldZ = this.getZ();

        // tenta mover
        this.refreshPositionAndAngles(x, y, z, this.getYaw(), this.getPitch());

        // desce até encontrar chão sólido
        while (this.getY() > this.getWorld().getBottomY() &&
                !this.getWorld().getBlockState(this.getBlockPos().down()).isSolidBlock(this.getWorld(), this.getBlockPos().down())) {
            this.setPosition(this.getX(), this.getY() - 1, this.getZ());
        }

        // verifica se o lugar é seguro
        if (!this.getWorld().getBlockState(this.getBlockPos()).isAir() ||
                !this.getWorld().getBlockState(this.getBlockPos()).getFluidState().isEmpty()) {

            // volta pra posição antiga se não for válido
            this.setPosition(oldX, oldY, oldZ);
            return false;
        }

        // teleporte válido
        this.requestTeleport(this.getX(), this.getY(), this.getZ());

        // partículas
        ((ServerWorld)this.getWorld()).spawnParticles(
                ParticleTypes.PORTAL,
                this.getX(),
                this.getBodyY(0.5),
                this.getZ(),
                32,        // quantidade
                0.5, 1.0, 0.5, // espalhamento (X, Y, Z)
                0.2        // velocidade
        );


        this.getWorld().emitGameEvent(this, GameEvent.TELEPORT, this.getBlockPos());

        return true;
    }

    @Override
    public int getMaxHeadRotation() {
        return 30;
    }

    @Override
    public int getMaxLookPitchChange() {
        return 20;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Blocks.MOSS_BLOCK.asItem());
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.MININORU.create(world);
    }
}
