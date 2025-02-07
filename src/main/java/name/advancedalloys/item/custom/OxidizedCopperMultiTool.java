package name.advancedalloys.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OxidizedCopperMultiTool extends MultiTool {
    public OxidizedCopperMultiTool(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
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
