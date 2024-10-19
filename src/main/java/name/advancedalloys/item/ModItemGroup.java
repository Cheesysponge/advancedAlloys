package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {



    //public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "blocks"),
      //      () -> new ItemStack(ModBlocks.COPPER_GOLD_BLOCK));
    //public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "armor"),
        //    () -> new ItemStack(ModItems.COPPER_CHESTPLATE));
    //public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "tools"),
          //  () -> new ItemStack(ModItems.GOLD_IRON_AXE));

//    public static final ItemGroup ALLOYS = FabricItemGroup.builder()
//            .displayName(Text.literal("Alloys"))
//            .icon(() -> new ItemStack(ModItems.COPPER_IRON_INGOT)).build();
//    public static final ItemGroup BLOCKS = FabricItemGroup.builder()
//            .displayName(Text.literal("Blocks"))
//            .icon(() -> new ItemStack(ModBlocks.COPPER_GOLD_BLOCK)).build();
//    public static final ItemGroup ARMOR= FabricItemGroup.builder()
//            .displayName(Text.literal("Armor"))
//            .icon(() -> new ItemStack(ModItems.COPPER_NETHERITE_CHESTPLATE)).build();
//    public static final ItemGroup TOOLS= FabricItemGroup.builder()
//            .displayName(Text.literal("Tools"))
//            .icon(() -> new ItemStack(ModItems.OXIDIZED_COPPER_PICKAXE)).build();

    public static final ItemGroup ALLOYS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "alloy"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.alloy"))
                    .icon(() -> new ItemStack(ModItems.COPPER_GOLD_INGOT)).entries((displayContext, entries) -> {
                        for(int i = 0; i<ModItems.ingots.length;i++){
                            entries.add(ModItems.ingots[i]);
                        }
//                        entries.add(ModItems.COPPER_IRON_INGOT);
//                        entries.add(ModItems.COPPER_GOLD_INGOT);
//                        entries.add(ModItems.GOLD_IRON_INGOT);
//                        entries.add(ModItems.COPPER_NETHERITE_INGOT);
//                        entries.add(ModItems.IRON_NETHERITE_INGOT);
//                        entries.add(ModItems.OXIDIZED_COPPER_INGOT);
//                        entries.add(ModItems.SILICON_INGOT);

                    }).build());
    public static final ItemGroup TOOLS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.tools"))
                    .icon(() -> new ItemStack(ModItems.OXIDIZED_COPPER_PICKAXE)).entries((displayContext, entries) -> {
                        for(int i = 0; i<ModItems.tools.length;i++){
                            entries.add(ModItems.tools[i]);
                        }
                    }).build());
    public static final ItemGroup ARMOR = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "armor"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.armor"))
                    .icon(() -> new ItemStack(ModItems.COPPER_NETHERITE_CHESTPLATE)).entries((displayContext, entries) -> {
                        for(int i = 0; i<ModItems.armor.length;i++){
                            entries.add(ModItems.armor[i]);
                        }
                    }).build());
    public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.COPPER_IRON_BLOCK)).entries((displayContext, entries) -> {
                        for(int i = 0; i<ModBlocks.alloy_blocks.length;i++){
                            entries.add(ModBlocks.alloy_blocks[i]);
                        }
//                        entries.add(ModBlocks.COPPER_IRON_BLOCK);
//                        entries.add(ModBlocks.COPPER_GOLD_BLOCK);
//                        entries.add(ModBlocks.GOLD_IRON_BLOCK);
//                        entries.add(ModBlocks.COPPER_NETHERITE_BLOCK);
//                        entries.add(ModBlocks.IRON_NETHERITE_BLOCK);
//                        entries.add(ModBlocks.SILICON_BLOCK);
                        entries.add(ModBlocks.ALLOY_BLASTER);
                    }).build());


    public static void registerItemGroups() {
        AdvancedAlloys.LOGGER.info("Registering Item Groups for " + AdvancedAlloys.MOD_ID);
    }
//    public static void registerItemGroup() {
//        ALLOYS = FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "alloy"))
//                .displayName(Text.literal("Alloys"))
//                .icon(() -> new ItemStack(ModItems.COPPER_IRON_INGOT)).build();
//        BLOCKS = FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "blocks"))
//                .displayName(Text.literal("Blocks"))
//                .icon(() -> new ItemStack(ModItems.COPPER_IRON_INGOT)).build();
//        ARMOR = FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "armor"))
//                .displayName(Text.literal("Armor"))
//                .icon(() -> new ItemStack(ModItems.COPPER_IRON_INGOT)).build();
//        TOOLS = FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "tools"))
//                .displayName(Text.literal("Tools"))
//                .icon(() -> new ItemStack(ModItems.COPPER_IRON_INGOT)).build();
//
//    }
}
