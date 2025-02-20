package name.advancedalloys.item.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ProjectileImmuneArmorItem extends ArmorItem {
    public ProjectileImmuneArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity) {
            for(int i = 0; i<4;i++) {
                if (stack == ((PlayerEntity) entity).getInventory().getArmorStack(i)) {
                    if (!stack.hasEnchantments()) {
                        stack.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 4);
                        stack.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 4);
                        stack.addEnchantment(Enchantments.BLAST_PROTECTION, 4);
                    }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
