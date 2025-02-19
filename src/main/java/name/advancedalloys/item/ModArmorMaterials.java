package name.advancedalloys.item;

import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;


public enum  ModArmorMaterials implements StringIdentifiable,ArmorMaterial {
    COPPER("copper", 20, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 2);
        map.put(Type.LEGGINGS, 4);
        map.put(Type.CHESTPLATE, 5);
        map.put(Type.HELMET, 2);
    }), 18, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0f, 0.0f, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    COPPER_IRON("copper_iron", 20, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 2);
        map.put(Type.LEGGINGS, 5);
        map.put(Type.CHESTPLATE, 6);
        map.put(Type.HELMET, 2);
    }), 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5f, 0.0f, () -> Ingredient.ofItems(ModItems.COPPER_IRON_INGOT)),
    COPPER_GOLD("copper_gold", 20, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 2);
        map.put(Type.LEGGINGS, 4);
        map.put(Type.CHESTPLATE, 6);
        map.put(Type.HELMET, 2);
    }), 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1f, 0.0f, () -> Ingredient.ofItems(ModItems.COPPER_GOLD_INGOT)),
    GOLD_IRON("gold_iron", 15, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 2);
        map.put(Type.LEGGINGS, 5);
        map.put(Type.CHESTPLATE, 6);
        map.put(Type.HELMET, 2);
    }), 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1f, 0.0f, () -> Ingredient.ofItems(ModItems.GOLD_IRON_INGOT)),
    COPPER_NETHERITE("copper_netherite", 48, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 3);
        map.put(Type.LEGGINGS, 6);
        map.put(Type.CHESTPLATE, 8);
        map.put(Type.HELMET, 3);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.9f, 0.05f, () -> Ingredient.ofItems(ModItems.COPPER_NETHERITE_INGOT)),
    IRON_NETHERITE("iron_netherite", 30, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 3);
        map.put(Type.LEGGINGS, 6);
        map.put(Type.CHESTPLATE, 8);
        map.put(Type.HELMET, 3);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.15f, () -> Ingredient.ofItems(ModItems.IRON_NETHERITE_INGOT)),
    OXIDIZED_COPPER("oxidized_copper", 20, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 3);
        map.put(Type.LEGGINGS, 6);
        map.put(Type.CHESTPLATE, 7);
        map.put(Type.HELMET, 3);
    }), 100, SoundEvents.ITEM_AXE_SCRAPE, 3f, 1f, () -> Ingredient.ofItems(ModItems.OXIDIZED_COPPER_INGOT)),
    SILICON("silicon", 33, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 3);
        map.put(Type.LEGGINGS, 6);
        map.put(Type.CHESTPLATE, 8);
        map.put(Type.HELMET, 3);
    }), 100, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2f, 0.0f, () -> Ingredient.ofItems(ModItems.SILICON_INGOT)),
    SILICON_NETHERITE("silicon_netherite", 38, Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 3);
        map.put(Type.LEGGINGS, 6);
        map.put(Type.CHESTPLATE, 8);
        map.put(Type.HELMET, 3);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.3f, 0.0f, () -> Ingredient.ofItems(ModItems.SILICON_NETHERITE_INGOT));


//    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.LEATHER});
//    }),
//    CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
//    }),
//    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
//    }),
//    GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
//    }),
//    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
//    }),
//    TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.SCUTE});
//    }),
//    NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
//    });

    private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY = Util.make(new EnumMap(Type.class), (map) -> {
        map.put(Type.BOOTS, 13);
        map.put(Type.LEGGINGS, 15);
        map.put(Type.CHESTPLATE, 16);
        map.put(Type.HELMET, 11);
    });

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<Type, Integer> protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }


//    @Override
//    public int getDurability(EquipmentSlot slot) {
//        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
//    }
//
//    @Override
//    public int getProtectionAmount(EquipmentSlot slot) {
//        return this.protectionAmounts[slot.getEntitySlotId()];
//    }

    public int getDurability(ArmorItem.Type type) {
        return (Integer)BASE_DURABILITY.get(type) * this.durabilityMultiplier;
    }

    public int getProtection(ArmorItem.Type type) {
        return (Integer)this.protectionAmounts.get(type);
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String asString() {
        return this.name;
    }
}
