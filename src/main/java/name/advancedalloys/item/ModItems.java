package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.item.custom.ModHoeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));
    public static final Item GOLD_IRON_INGOT = registerItem("gold_iron_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));
    public static final Item COPPER_GOLD_INGOT = registerItem("copper_gold_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));

    public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(ModToolMaterials.COPPER,3,-2.4f,new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.TOOLS).maxCount(1)));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ModToolMaterials.COPPER,1,-2.8f,new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.TOOLS).maxCount(1)));
    public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ModToolMaterials.COPPER,6,-3.1f,new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.TOOLS).maxCount(1)));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ModToolMaterials.COPPER,3,-2.4f,new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.TOOLS).maxCount(1)));
    public static final Item COPPER_HOE = registerItem("copper_hoe", new ModHoeItem(ModToolMaterials.COPPER,-2,-1.0f,new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.TOOLS).maxCount(1)));





    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD,new FabricItemSettings().group(ModItemGroup.ARMOR).maxCount(1)));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST,new FabricItemSettings().group(ModItemGroup.ARMOR).maxCount(1)));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS,new FabricItemSettings().group(ModItemGroup.ARMOR).maxCount(1)));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET,new FabricItemSettings().group(ModItemGroup.ARMOR).maxCount(1)));


    public static final Item COPPER_IRON_HELMET = registerItem("copper_iron_helmet", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.ARMOR).maxCount(1)));
    public static final Item COPPER_IRON_CHESTPLATE = registerItem("copper_iron_chestplate", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.ARMOR).maxCount(1)));
    public static final Item COPPER_IRON_LEGGINGS = registerItem("copper_iron_leggings", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.ARMOR).maxCount(1)));
    public static final Item COPPER_IRON_BOOTS = registerItem("copper_iron_boots", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.ARMOR).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AdvancedAlloys.LOGGER.info("Registering Mod Items for " + AdvancedAlloys.MOD_ID);
    }
}

