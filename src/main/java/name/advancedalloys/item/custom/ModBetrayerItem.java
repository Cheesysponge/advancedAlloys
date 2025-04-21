package name.advancedalloys.item.custom;

import name.advancedalloys.particle.ModParticles;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ModBetrayerItem extends SwordItem {
    private LivingEntity lastHit;
    private int stunTicks;

    public ModBetrayerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.stunTicks=-1;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(this.lastHit != null) {
            if (this.lastHit.isAlive()) {
                this.lastHit.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 9999999));
                if(entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 9999999));
                }

            }
            if (entity.getPos().distanceTo(this.lastHit.getPos()) > 20) {
                clearGlow(entity);
                this.lastHit=null;
            }
            if(this.lastHit != null) {
                if (this.stunTicks > 0) {
                    if (this.stunTicks % 20 == 0) {
                        this.lastHit.damage(entity.getDamageSources().indirectMagic(entity, entity), 1.5f);
                        MinecraftClient.getInstance().particleManager.addEmitter(this.lastHit, ParticleTypes.ENCHANTED_HIT);

                    }
                    entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, this.lastHit.getEyePos());
                    this.stunTicks--;
                }
                if (this.stunTicks == 0) {
                    MinecraftClient.getInstance().particleManager.addEmitter(this.lastHit, ParticleTypes.ENCHANTED_HIT);
                    MinecraftClient.getInstance().particleManager.addEmitter(this.lastHit, ParticleTypes.BUBBLE_POP);
                    MinecraftClient.getInstance().particleManager.addEmitter(this.lastHit, ParticleTypes.BUBBLE);
                    MinecraftClient.getInstance().particleManager.addEmitter(this.lastHit, ParticleTypes.DRIPPING_WATER);
                    this.lastHit.damage(entity.getDamageSources().indirectMagic(entity, entity), 1.5f);
                    stunTicks--;


                }
            }

        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double d = (double) (-MathHelper.sin(attacker.getYaw() * (float) (Math.PI / 180.0)));
        double e = (double) MathHelper.cos(attacker.getYaw() * (float) (Math.PI / 180.0));
        boolean isCrit = attacker.fallDistance > 0.0F
                && !attacker.isOnGround()
                && !attacker.isClimbing()
                && !attacker.isTouchingWater()
                && !attacker.hasStatusEffect(StatusEffects.BLINDNESS)
                && !attacker.hasVehicle()
                && target != null;

        if (attacker.getWorld() instanceof ServerWorld && !isCrit) {
            ((ServerWorld) attacker.getWorld()).spawnParticles(ModParticles.GUARDIAN_SWEEP_PARTICLE, attacker.getX() + d, attacker.getBodyY(0.5), attacker.getZ() + e, 0, d, 0.0, e, 0.0);
        } else {
            if(!attacker.getWorld().isClient()) {
                MinecraftClient.getInstance().particleManager.addEmitter(target, ModParticles.GUARDIAN_CRIT_PARTICLE);
            }

        }

        clearGlow(attacker);
        this.lastHit = target;
        target.damageArmor(attacker.getDamageSources().indirectMagic(attacker, attacker), 5);
        if(!target.isAlive()){
            onKillEffect(attacker);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.damage(user.getDamageSources().indirectMagic(user, user), 2);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60,254));
        this.stunTicks+=60;
        MinecraftClient.getInstance().particleManager.addEmitter(entity, ParticleTypes.BUBBLE_POP);
        MinecraftClient.getInstance().particleManager.addEmitter(entity, ParticleTypes.ENCHANTED_HIT);

        (user).getItemCooldownManager().set(this, 10);
        clearGlow(user);
        this.lastHit = entity;
        if(!entity.isAlive()){
            onKillEffect(user);
        }
        return ActionResult.FAIL;
        //return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(this.lastHit != null && this.lastHit.isAlive()) {
            user.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, this.lastHit.getEyePos());
            this.lastHit.damage(user.getDamageSources().indirectMagic(user, user), 1.5f);
            MinecraftClient.getInstance().particleManager.addEmitter(this.lastHit, ParticleTypes.ENCHANTED_HIT);

            (user).getItemCooldownManager().set(this, 60);
            stunTicks+=60;
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60,254));
            if(this.lastHit!=null && !this.lastHit.isAlive()){
                onKillEffect(user);
            }
        }
        return super.use(world, user, hand);
    }

    private void clearGlow(Entity user){
        if(this.lastHit!=null) {
            this.lastHit.removeStatusEffect(StatusEffects.GLOWING);
            ((LivingEntity) user).removeStatusEffect(StatusEffects.GLOWING);
        }
    }
    private void onKillEffect(LivingEntity attacker){
        Box box = attacker.getBoundingBox().expand(15);
        List<Entity> list = attacker.getWorld().getOtherEntities(attacker, box);
        for(Entity i : list){
            if(i instanceof LivingEntity && i.isAlive() && attacker.getPos().distanceTo(i.getPos())<15) {
                ((LivingEntity) i).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100,254));
                MinecraftClient.getInstance().particleManager.addEmitter(i, ParticleTypes.NAUTILUS);
                i.damage(attacker.getDamageSources().indirectMagic(attacker, attacker), 1);
                if(!i.isAlive()){
                    onKillEffect(attacker);
                }
            }

        }
    }
}
