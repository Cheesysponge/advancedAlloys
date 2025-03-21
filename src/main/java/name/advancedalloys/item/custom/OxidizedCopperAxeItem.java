package name.advancedalloys.item.custom;

import name.advancedalloys.item.ModArmorMaterials;
import name.advancedalloys.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class OxidizedCopperAxeItem extends AxeItem {
    public OxidizedCopperAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()&&selected){

            entity.timeUntilRegen = 0;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int x = (int)(Math.random() * 10);
        if(x<2) {
            World world = target.getWorld();
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.setPos(attacker.getX(), attacker.getY(), attacker.getZ());
            LightningEntity lightning1 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning1.setPos(target.getX(), target.getY(), target.getZ());
            world.spawnEntity(lightning);
            world.spawnEntity(lightning1);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

        int x = (int)(Math.random() * 10);
        if(x<2) {
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.setPos(miner.getX(), miner.getY(), miner.getZ());
            world.spawnEntity(lightning);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
