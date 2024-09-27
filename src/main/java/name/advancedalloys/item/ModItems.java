package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));
    public static final Item GOLD_IRON_INGOT = registerItem("gold_iron_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));
    public static final Item COPPER_GOLD_INGOT = registerItem("copper_gold_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));


    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.ALLOYS).maxCount(1)));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.ALLOYS).maxCount(1)));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.ALLOYS).maxCount(1)));

    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.ALLOYS).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AdvancedAlloys.LOGGER.info("Registering Mod Items for " + AdvancedAlloys.MOD_ID);
    }
}

