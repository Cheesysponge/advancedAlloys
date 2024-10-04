package name.advancedalloys.block;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.custom.AlloyBlasterBlock;
import name.advancedalloys.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8f)), ModItemGroup.BLOCKS);
    public static final Block GOLD_IRON_BLOCK = registerBlock("gold_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block COPPER_GOLD_BLOCK = registerBlock("copper_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8f).requiresTool()), ModItemGroup.BLOCKS);

    public static final Block IRON_NETHERITE_BLOCK = registerBlock("iron_netherite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(15f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block COPPER_NETHERITE_BLOCK = registerBlock("copper_netherite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(15f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block ALLOY_BLASTER = registerBlock("alloy_blaster",
            new AlloyBlasterBlock(FabricBlockSettings.of(Material.METAL).strength(8f).requiresTool()), ModItemGroup.BLOCKS);


    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(AdvancedAlloys.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block , group);
        return Registry.register(Registry.BLOCK, new Identifier(AdvancedAlloys.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.BLOCK, new Identifier(AdvancedAlloys.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        AdvancedAlloys.LOGGER.info("Registering ModBlocks for " + AdvancedAlloys.MOD_ID);
    }

}
