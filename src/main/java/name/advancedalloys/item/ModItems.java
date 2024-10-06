package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // Ingots
    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot", new Item(new FabricItemSettings()), ModItemGroup.ALLOYS);
    public static final Item GOLD_IRON_INGOT = registerItem("gold_iron_ingot", new Item(new FabricItemSettings()), ModItemGroup.ALLOYS);
    public static final Item COPPER_GOLD_INGOT = registerItem("copper_gold_ingot", new Item(new FabricItemSettings()), ModItemGroup.ALLOYS);
    public static final Item COPPER_NETHERITE_INGOT = registerItem("copper_netherite_ingot", new Item(new FabricItemSettings()), ModItemGroup.ALLOYS);
    public static final Item IRON_NETHERITE_INGOT = registerItem("iron_netherite_ingot", new Item(new FabricItemSettings()), ModItemGroup.ALLOYS);
    public static final Item OXIDIZED_COPPER_INGOT = registerItem("oxidized_copper_ingot", new Item(new FabricItemSettings()), ModItemGroup.ALLOYS);



    // Tools

    public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(ModToolMaterials.COPPER,3,-2.4f,new FabricItemSettings().rarity(Rarity.COMMON)), ModItemGroup.TOOLS);
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ModToolMaterials.COPPER,1,-2.8f,new FabricItemSettings().rarity(Rarity.COMMON)), ModItemGroup.TOOLS);
    public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ModToolMaterials.COPPER,6,-3.1f,new FabricItemSettings().rarity(Rarity.COMMON)), ModItemGroup.TOOLS);
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ModToolMaterials.COPPER,3,-2.4f,new FabricItemSettings().rarity(Rarity.COMMON)), ModItemGroup.TOOLS);
    public static final Item COPPER_HOE = registerItem("copper_hoe", new ModHoeItem(ModToolMaterials.COPPER,-2,-1.0f,new FabricItemSettings().rarity(Rarity.COMMON)), ModItemGroup.TOOLS);

    public static final Item COPPER_IRON_SWORD = registerItem("copper_iron_sword", new SwordItem(ModToolMaterials.COPPER_IRON,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_IRON_PICKAXE = registerItem("copper_iron_pickaxe", new PickaxeItem(ModToolMaterials.COPPER_IRON,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_IRON_AXE = registerItem("copper_iron_axe", new AxeItem(ModToolMaterials.COPPER_IRON,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_IRON_SHOVEL = registerItem("copper_iron_shovel", new ShovelItem(ModToolMaterials.COPPER_IRON,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_IRON_HOE = registerItem("copper_iron_hoe", new ModHoeItem(ModToolMaterials.COPPER_IRON,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);

    public static final Item COPPER_GOLD_SWORD = registerItem("copper_gold_sword", new SwordItem(ModToolMaterials.COPPER_GOLD,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_GOLD_PICKAXE = registerItem("copper_gold_pickaxe", new PickaxeItem(ModToolMaterials.COPPER_GOLD,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_GOLD_AXE = registerItem("copper_gold_axe", new AxeItem(ModToolMaterials.COPPER_GOLD,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_GOLD_SHOVEL = registerItem("copper_gold_shovel", new ShovelItem(ModToolMaterials.COPPER_GOLD,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_GOLD_HOE = registerItem("copper_gold_hoe", new ModHoeItem(ModToolMaterials.COPPER_GOLD,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);

    public static final Item GOLD_IRON_SWORD = registerItem("gold_iron_sword", new SwordItem(ModToolMaterials.GOLD_IRON,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item GOLD_IRON_PICKAXE = registerItem("gold_iron_pickaxe", new PickaxeItem(ModToolMaterials.GOLD_IRON,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item GOLD_IRON_AXE = registerItem("gold_iron_axe", new AxeItem(ModToolMaterials.GOLD_IRON,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item GOLD_IRON_SHOVEL = registerItem("gold_iron_shovel", new ShovelItem(ModToolMaterials.GOLD_IRON,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item GOLD_IRON_HOE = registerItem("gold_iron_hoe", new ModHoeItem(ModToolMaterials.GOLD_IRON,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);

    public static final Item COPPER_NETHERITE_SWORD = registerItem("copper_netherite_sword", new SwordItem(ModToolMaterials.COPPER_NETHERITE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_NETHERITE_PICKAXE = registerItem("copper_netherite_pickaxe", new PickaxeItem(ModToolMaterials.COPPER_NETHERITE,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_NETHERITE_AXE = registerItem("copper_netherite_axe", new AxeItem(ModToolMaterials.COPPER_NETHERITE,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_NETHERITE_SHOVEL = registerItem("copper_netherite_shovel", new ShovelItem(ModToolMaterials.COPPER_NETHERITE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item COPPER_NETHERITE_HOE = registerItem("copper_netherite_hoe", new ModHoeItem(ModToolMaterials.COPPER_NETHERITE,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);

    public static final Item IRON_NETHERITE_SWORD = registerItem("iron_netherite_sword", new SwordItem(ModToolMaterials.IRON_NETHERITE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item IRON_NETHERITE_PICKAXE = registerItem("iron_netherite_pickaxe", new PickaxeItem(ModToolMaterials.IRON_NETHERITE,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item IRON_NETHERITE_AXE = registerItem("iron_netherite_axe", new AxeItem(ModToolMaterials.IRON_NETHERITE,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item IRON_NETHERITE_SHOVEL = registerItem("iron_netherite_shovel", new ShovelItem(ModToolMaterials.IRON_NETHERITE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item IRON_NETHERITE_HOE = registerItem("iron_netherite_hoe", new ModHoeItem(ModToolMaterials.IRON_NETHERITE,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);

    public static final Item OXIDIZED_COPPER_SWORD = registerItem("oxidized_copper_sword", new OxidizedCopperSwordItem(ModToolMaterials.OXIDIZED_COPPER,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item OXIDIZED_COPPER_PICKAXE = registerItem("oxidized_copper_pickaxe", new OxidizedCopperPickaxeItem(ModToolMaterials.OXIDIZED_COPPER,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item OXIDIZED_COPPER_AXE = registerItem("oxidized_copper_axe", new OxidizedCopperAxeItem(ModToolMaterials.OXIDIZED_COPPER,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item OXIDIZED_COPPER_SHOVEL = registerItem("oxidized_copper_shovel", new OxidizedCopperShovelItem(ModToolMaterials.OXIDIZED_COPPER,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);
    public static final Item OXIDIZED_COPPER_HOE = registerItem("oxidized_copper_hoe", new OxidizedCopperHoeItem(ModToolMaterials.OXIDIZED_COPPER,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.TOOLS);


    // Armors
    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD,new FabricItemSettings().maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST,new FabricItemSettings().maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS,new FabricItemSettings().maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET,new FabricItemSettings().maxCount(1)), ModItemGroup.ARMOR);

    public static final Item COPPER_IRON_HELMET = registerItem("copper_iron_helmet", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_IRON_CHESTPLATE = registerItem("copper_iron_chestplate", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_IRON_LEGGINGS = registerItem("copper_iron_leggings", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_IRON_BOOTS = registerItem("copper_iron_boots", new ArmorItem(ModArmorMaterials.COPPER_IRON, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);

    public static final Item COPPER_GOLD_HELMET = registerItem("copper_gold_helmet", new ArmorItem(ModArmorMaterials.COPPER_GOLD, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_GOLD_CHESTPLATE = registerItem("copper_gold_chestplate", new ArmorItem(ModArmorMaterials.COPPER_GOLD, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_GOLD_LEGGINGS = registerItem("copper_gold_leggings", new ArmorItem(ModArmorMaterials.COPPER_GOLD, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_GOLD_BOOTS = registerItem("copper_gold_boots", new ArmorItem(ModArmorMaterials.COPPER_GOLD, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);

    public static final Item GOLD_IRON_HELMET = registerItem("gold_iron_helmet", new ArmorItem(ModArmorMaterials.GOLD_IRON, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item GOLD_IRON_CHESTPLATE = registerItem("gold_iron_chestplate", new ArmorItem(ModArmorMaterials.GOLD_IRON, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item GOLD_IRON_LEGGINGS = registerItem("gold_iron_leggings", new ArmorItem(ModArmorMaterials.GOLD_IRON, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item GOLD_IRON_BOOTS = registerItem("gold_iron_boots", new ArmorItem(ModArmorMaterials.GOLD_IRON, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);

    public static final Item IRON_NETHERITE_HELMET = registerItem("iron_netherite_helmet", new ArmorItem(ModArmorMaterials.IRON_NETHERITE, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item IRON_NETHERITE_CHESTPLATE = registerItem("iron_netherite_chestplate", new ArmorItem(ModArmorMaterials.IRON_NETHERITE, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item IRON_NETHERITE_LEGGINGS = registerItem("iron_netherite_leggings", new ArmorItem(ModArmorMaterials.IRON_NETHERITE, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item IRON_NETHERITE_BOOTS = registerItem("iron_netherite_boots", new ArmorItem(ModArmorMaterials.IRON_NETHERITE, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);

    public static final Item COPPER_NETHERITE_HELMET = registerItem("copper_netherite_helmet", new ArmorItem(ModArmorMaterials.COPPER_NETHERITE, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_NETHERITE_CHESTPLATE = registerItem("copper_netherite_chestplate", new ArmorItem(ModArmorMaterials.COPPER_NETHERITE, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_NETHERITE_LEGGINGS = registerItem("copper_netherite_leggings", new ArmorItem(ModArmorMaterials.COPPER_NETHERITE, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item COPPER_NETHERITE_BOOTS = registerItem("copper_netherite_boots", new ArmorItem(ModArmorMaterials.COPPER_NETHERITE, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);

    public static final Item OXIDIZED_COPPER_HELMET = registerItem("oxidized_copper_helmet", new OxidizedCopperArmorItem(ModArmorMaterials.OXIDIZED_COPPER, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item OXIDIZED_COPPER_CHESTPLATE = registerItem("oxidized_copper_chestplate", new OxidizedCopperArmorItem(ModArmorMaterials.OXIDIZED_COPPER, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item OXIDIZED_COPPER_LEGGINGS = registerItem("oxidized_copper_leggings", new OxidizedCopperArmorItem(ModArmorMaterials.OXIDIZED_COPPER, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);
    public static final Item OXIDIZED_COPPER_BOOTS = registerItem("oxidized_copper_boots", new OxidizedCopperArmorItem(ModArmorMaterials.OXIDIZED_COPPER, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)), ModItemGroup.ARMOR);

    private static Item registerItem(String name, Item item, ItemGroup group) {
        addToItemGroup(group,item);
        return Registry.register(Registries.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name), item);
    }
    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        AdvancedAlloys.LOGGER.info("Registering Mod Items for " + AdvancedAlloys.MOD_ID);
    }
}

