package name.advancedalloys.item.custom;

import dev.architectury.event.events.common.LightningEvent;
import name.advancedalloys.item.ModArmorMaterials;
import name.advancedalloys.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Objects;

public class OxidizedCopperArmorItem extends ArmorItem {
    public OxidizedCopperArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity.isSneaking() && entity.isSprinting() && hasCorrectArmorOn((ArmorMaterial) ModArmorMaterials.OXIDIZED_COPPER, (PlayerEntity) entity)){

                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPos(entity.getX(), entity.getY(), entity.getZ());

                world.spawnEntity(lightning);

                //world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 1f, Explosion.DestructionType.BREAK);
            }
            entity.timeUntilRegen = 0;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }


    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }


    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor){
            if(!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material || breastplate.getMaterial() == material ||
                leggings.getMaterial() == material || boots.getMaterial() == material;
    }
}
