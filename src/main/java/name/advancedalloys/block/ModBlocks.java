package name.advancedalloys.block;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.custom.AlloyBlasterBlock;
import name.advancedalloys.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(6f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block GOLD_IRON_BLOCK = registerBlock("gold_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(6f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block COPPER_GOLD_BLOCK = registerBlock("copper_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(6f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block IRON_NETHERITE_BLOCK = registerBlock("iron_netherite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(12f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block COPPER_NETHERITE_BLOCK = registerBlock("copper_netherite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(12f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block SILICON_BLOCK = registerBlock("silicon_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(7f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block SILICON_NETHERITE_BLOCK = registerBlock("silicon_netherite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(7f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block MIXED_BLOCK = registerBlock("mixed_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(7f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block[] alloy_blocks = {COPPER_IRON_BLOCK,GOLD_IRON_BLOCK,COPPER_GOLD_BLOCK,IRON_NETHERITE_BLOCK,COPPER_NETHERITE_BLOCK,SILICON_BLOCK, SILICON_NETHERITE_BLOCK};

    public static final Block ALLOY_BLASTER = registerBlock("alloy_blaster",
            new AlloyBlasterBlock(FabricBlockSettings.copyOf(Blocks.BLAST_FURNACE).strength(4f).requiresTool()), ModItemGroup.BLOCKS);




    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block , group);
        return Registry.register(Registries.BLOCK, new Identifier(AdvancedAlloys.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registries.BLOCK, new Identifier(AdvancedAlloys.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(AdvancedAlloys.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
//        ItemGroupEvents.modifyEntriesEvent(Registry).register(entries -> entries.add(item));
        return item;
    }
    public static void registerModBlocks() {
        AdvancedAlloys.LOGGER.info("Registering ModBlocks for " + AdvancedAlloys.MOD_ID);
    }


}
