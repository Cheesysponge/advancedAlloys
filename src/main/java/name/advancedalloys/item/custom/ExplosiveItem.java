package name.advancedalloys.item.custom;

import name.advancedalloys.AdvancedAlloys;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ExplosiveItem extends Item implements Vanishable {
    public ExplosiveItem(Settings settings) {
        super(settings);
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }
    public int getMaxUseTime(ItemStack stack) {
        return 24000;
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
        creeper.setPos(user.getX(), user.getY()+0.5, user.getZ());

        creeper.ignite();
        //AdvancedAlloys.LOGGER.info(String.valueOf(creeper.getFuseSpeed()) + " Fuse Speed");
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,35,4));
        world.spawnEntity(creeper);
        world.createExplosion(creeper,creeper.getX(), creeper.getY(), creeper.getZ(),3, false, World.ExplosionSourceType.MOB);
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
        ((PlayerEntity) user).getItemCooldownManager().set(this, 600);

    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

}
