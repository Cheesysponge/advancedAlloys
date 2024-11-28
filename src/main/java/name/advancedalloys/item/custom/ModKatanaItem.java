package name.advancedalloys.item.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.util.math.Box;
import net.minecraft.world.StructureSpawns;
import net.minecraft.world.World;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.*;
import net.minecraft.server.command.SummonCommand;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.List;

public class ModKatanaItem extends SwordItem implements Vanishable {
    public ModKatanaItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

//    @Override
//    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
//        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,100,1));
//        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,100,1));
//        super.usageTick(world, user, stack, remainingUseTicks);
//    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,100,0));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,100,0));

        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,100,0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,100,0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,100,0));


        return super.postHit(stack, target, attacker);
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 36000;
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
            return TypedActionResult.fail(itemStack);
        } else if (EnchantmentHelper.getRiptide(itemStack) > 0 && !user.isTouchingWaterOrRain()) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity user, int slot, boolean selected) {
        if(user instanceof LivingEntity && selected && slot==8) {
            Box box = user.getBoundingBox();
            List<Entity> list = user.getWorld().getOtherEntities(user, box);
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); ++i) {
                    Entity entity = list.get(i);
                    if (entity != user && entity.isLiving()) {
                        ((LivingEntity) user).limbAnimator.setSpeed(40);
                        entity.damage(entity.getDamageSources().thrown((LivingEntity) user,user), 6);
                        entity.addVelocity(user.getVelocity().multiply(3,3,3));
                        user.setVelocity(user.getVelocity().multiply(-0.1));
                        user.getWorld().syncWorldEvent(WorldEvents.BLOCK_SCRAPED, user.getBlockPos(), 0);
                        ((PlayerEntity) user).addCritParticles(user);
                        break;
                    }
                }
            }
        }
        super.inventoryTick(stack, world, user, slot, selected);
    }

//    @Override
//    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
//        Box box = user.getBoundingBox(user.getPose());
//        List<Entity> list = user.getWorld().getOtherEntities(user, box);
//        if (!list.isEmpty()) {
//            for (int i = 0; i < list.size(); ++i) {
//                Entity entity = list.get(i);
//                if (entity != user && entity.isLiving()) {
//                    user.tryAttack(entity);
//                    entity.damage(entity.getDamageSources().sting(user), 1);
//                    user.setVelocity(user.getVelocity().multiply(-0.2));
//                    entity.setVelocity(user.getVelocity().add(0,2,0));
//                    user.getWorld().syncWorldEvent(WorldEvents.BLOCK_SCRAPED, user.getBlockPos(), 0);
//                    ((PlayerEntity) user).addCritParticles(user);
//                    break;
//                }
//            }
//        }
//        super.usageTick(world, user, stack, remainingUseTicks);
//    }


    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (i >= 10) {
                int j = 0;
                float f = playerEntity.getYaw();
                float g = playerEntity.getPitch();
                float h = -MathHelper.sin(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
                float k = -MathHelper.sin(g * 0.017453292F);
                float l = MathHelper.cos(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
                float m = MathHelper.sqrt(h * h + k * k + l * l);
                float n = 4.5F * ((1.0F + (float)j) / 4.0F);
                h *= n / m;
                k *= n / m;
                l *= n / m;
                playerEntity.addVelocity((double)h, (double)k, (double)l);
                user.getWorld().syncWorldEvent(WorldEvents.BLOCK_SCRAPED, user.getBlockPos(), 0);
                ((PlayerEntity) user).addCritParticles(user);



                if (playerEntity.isOnGround()) {
                    float o = 1.1999999F;
                    playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999284744263, 0.0));
                }


            }
            ((PlayerEntity) user).getItemCooldownManager().set(this, 10);

        }
    }

}
