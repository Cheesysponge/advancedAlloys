package name.advancedalloys.item;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;
public enum ModToolMaterials implements ToolMaterial {
    COPPER(MiningLevels.IRON, 285, 5.0f, 1.5f, 20, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_IRON(MiningLevels.IRON, 285, 6.0f, 2.0f, 20, () -> Ingredient.ofItems(ModItems.COPPER_IRON_INGOT)),
    COPPER_GOLD(MiningLevels.IRON, 275, 12.0f, 1.5f, 22, () -> Ingredient.ofItems(ModItems.COPPER_GOLD_INGOT)),
    GOLD_IRON(MiningLevels.IRON, 240, 13.0f, 2.0f, 22, () -> Ingredient.ofItems(ModItems.GOLD_IRON_INGOT));
    //    IRON(2, 250, 6.0F, 2.0F, 14, () -> {
    //        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
    //    }),
//    GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
//    }),
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}