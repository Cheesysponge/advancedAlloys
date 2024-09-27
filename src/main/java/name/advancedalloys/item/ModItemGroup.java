package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ALLOYS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "alloy"),
            () -> new ItemStack(ModItems.COPPER_IRON_INGOT));
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "alloy"),
            () -> new ItemStack(ModBlocks.COPPER_GOLD_BLOCK));
    public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "alloy"),
            () -> new ItemStack(ModItems.COPPER_IRON_CHESTPLATE));
    public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "alloy"),
            () -> new ItemStack(ModBlocks.COPPER_GOLD_BLOCK));
}
