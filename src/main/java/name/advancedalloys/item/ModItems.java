package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));
    public static final Item GOLD_IRON_INGOT = registerItem("gold_iron_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));
    public static final Item COPPER_GOLD_INGOT = registerItem("copper_gold_ingot", new Item(new FabricItemSettings().group(ModItemGroup.ALLOYS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AdvancedAlloys.LOGGER.info("Registering Mod Items for " + AdvancedAlloys.MOD_ID);
    }
}

