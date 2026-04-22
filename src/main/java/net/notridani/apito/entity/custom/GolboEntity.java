package net.notridani.apito.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.notridani.apito.Apito;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class GolboEntity extends MobEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState crescerAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int regrowTimer = 0;
    private int growAnimationTime = 0;

    public enum GolboState {
        IDLE,
        SEM_PERNA,
        CRESCENDO
    }

    @Override
    protected void initGoals() {

    }

    private static final TrackedData<Integer> STATE =
            DataTracker.registerData(GolboEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public GolboState getState() {
        return GolboState.values()[this.dataTracker.get(STATE)];
    }

    public void setState(GolboState state) {
        this.dataTracker.set(STATE, state.ordinal());

        this.idleAnimationState.stop();
        this.idleAnimationState.start(this.age);

        if (state == GolboState.IDLE) {
            this.idleAnimationState.start(this.age);
        }

        if (state == GolboState.SEM_PERNA) {
            this.idleAnimationState.start(this.age);
        }

        if (state == GolboState.CRESCENDO) {
            this.crescerAnimationState.start(this.age);
        }

    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(STATE, GolboState.IDLE.ordinal());
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0);
    }


    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        if (!this.getWorld().isClient()) {
            if (this.getState() == GolboState.SEM_PERNA ){
                if(regrowTimer < 6000){
                    regrowTimer++;
                } else {
                    this.growAnimationTime = 0;
                    this.setState(GolboState.IDLE);
                }
            }
        }
    }

    public int getGrowAnimationTime() {
        return this.growAnimationTime;
    }


    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() == Items.SHEARS && getState() == GolboState.IDLE) {

            if(!this.getWorld().isClient) {
                this.setState(GolboState.SEM_PERNA);
                this.regrowTimer = 200; // 10 segundos (20 ticks * 10)

                stack.damage(1, player, LivingEntity.getSlotForHand(hand));

                int amout = this.random.nextBetween(1,5);
                this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
                this.damage(this.getDamageSources().generic(), 2.0F);

                for(int i = 0; i < amout; i++) {
                    this.dropItem(ModItems.RAW_GOLBO_LEG);
                }

            }

            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("State", this.getState().ordinal());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);

        int stateId = nbt.getInt("State");

        this.setState(GolboState.values()[stateId]);
    }


    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PANDA_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    public GolboEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
}
