package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
                        entries.add(ModItems.COPPER_IRON_INGOT);
                        entries.add(ModItems.COPPER_GOLD_INGOT);
                        entries.add(ModItems.GOLD_IRON_INGOT);
                        entries.add(ModItems.COPPER_NETHERITE_INGOT);
                        entries.add(ModItems.IRON_NETHERITE_INGOT);
                        entries.add(ModItems.OXIDIZED_COPPER_INGOT);
                        entries.add(ModItems.SILICON_INGOT);

                    }).build());
    public static final ItemGroup TOOLS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.tools"))
                    .icon(() -> new ItemStack(ModItems.OXIDIZED_COPPER_PICKAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPER_HOE);
                        entries.add(ModItems.COPPER_SHOVEL);

                        entries.add(ModItems.COPPER_IRON_PICKAXE);
                        entries.add(ModItems.COPPER_IRON_AXE);
                        entries.add(ModItems.COPPER_IRON_SWORD);
                        entries.add(ModItems.COPPER_IRON_HOE);
                        entries.add(ModItems.COPPER_IRON_SHOVEL);

                        entries.add(ModItems.COPPER_GOLD_PICKAXE);
                        entries.add(ModItems.COPPER_GOLD_AXE);
                        entries.add(ModItems.COPPER_GOLD_SWORD);
                        entries.add(ModItems.COPPER_GOLD_HOE);
                        entries.add(ModItems.COPPER_GOLD_SHOVEL);

                        entries.add(ModItems.GOLD_IRON_PICKAXE);
                        entries.add(ModItems.GOLD_IRON_AXE);
                        entries.add(ModItems.GOLD_IRON_SWORD);
                        entries.add(ModItems.GOLD_IRON_HOE);
                        entries.add(ModItems.GOLD_IRON_SHOVEL);

                        entries.add(ModItems.COPPER_NETHERITE_PICKAXE);
                        entries.add(ModItems.COPPER_NETHERITE_AXE);
                        entries.add(ModItems.COPPER_NETHERITE_SWORD);
                        entries.add(ModItems.COPPER_NETHERITE_HOE);
                        entries.add(ModItems.COPPER_NETHERITE_SHOVEL);

                        entries.add(ModItems.IRON_NETHERITE_PICKAXE);
                        entries.add(ModItems.IRON_NETHERITE_AXE);
                        entries.add(ModItems.IRON_NETHERITE_SWORD);
                        entries.add(ModItems.IRON_NETHERITE_HOE);
                        entries.add(ModItems.IRON_NETHERITE_SHOVEL);

                        entries.add(ModItems.OXIDIZED_COPPER_PICKAXE);
                        entries.add(ModItems.OXIDIZED_COPPER_AXE);
                        entries.add(ModItems.OXIDIZED_COPPER_SWORD);
                        entries.add(ModItems.OXIDIZED_COPPER_HOE);
                        entries.add(ModItems.OXIDIZED_COPPER_SHOVEL);

                        entries.add(ModItems.SILICON_PICKAXE);
                        entries.add(ModItems.SILICON_AXE);
                        entries.add(ModItems.SILICON_SWORD);
                        entries.add(ModItems.SILICON_HOE);
                        entries.add(ModItems.SILICON_SHOVEL);
                    }).build());
    public static final ItemGroup ARMOR = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "armor"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.armor"))
                    .icon(() -> new ItemStack(ModItems.COPPER_NETHERITE_CHESTPLATE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COPPER_HELMET);
                        entries.add(ModItems.COPPER_CHESTPLATE);
                        entries.add(ModItems.COPPER_LEGGINGS);
                        entries.add(ModItems.COPPER_BOOTS);

                        entries.add(ModItems.COPPER_IRON_HELMET);
                        entries.add(ModItems.COPPER_IRON_CHESTPLATE);
                        entries.add(ModItems.COPPER_IRON_LEGGINGS);
                        entries.add(ModItems.COPPER_IRON_BOOTS);


                        entries.add(ModItems.COPPER_GOLD_HELMET);
                        entries.add(ModItems.COPPER_GOLD_CHESTPLATE);
                        entries.add(ModItems.COPPER_GOLD_LEGGINGS);
                        entries.add(ModItems.COPPER_GOLD_BOOTS);

                        entries.add(ModItems.GOLD_IRON_HELMET);
                        entries.add(ModItems.GOLD_IRON_CHESTPLATE);
                        entries.add(ModItems.GOLD_IRON_LEGGINGS);
                        entries.add(ModItems.GOLD_IRON_BOOTS);


                        entries.add(ModItems.COPPER_NETHERITE_HELMET);
                        entries.add(ModItems.COPPER_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.COPPER_NETHERITE_LEGGINGS);
                        entries.add(ModItems.COPPER_NETHERITE_BOOTS);

                        entries.add(ModItems.IRON_NETHERITE_HELMET);
                        entries.add(ModItems.IRON_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.IRON_NETHERITE_LEGGINGS);
                        entries.add(ModItems.IRON_NETHERITE_BOOTS);

                        entries.add(ModItems.OXIDIZED_COPPER_HELMET);
                        entries.add(ModItems.OXIDIZED_COPPER_CHESTPLATE);
                        entries.add(ModItems.OXIDIZED_COPPER_LEGGINGS);
                        entries.add(ModItems.OXIDIZED_COPPER_BOOTS);

                        entries.add(ModItems.SILICON_HELMET);
                        entries.add(ModItems.SILICON_CHESTPLATE);
                        entries.add(ModItems.SILICON_LEGGINGS);
                        entries.add(ModItems.SILICON_BOOTS);

                    }).build());
    public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedAlloys.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.advancedalloys.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.COPPER_IRON_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COPPER_IRON_BLOCK);
                        entries.add(ModBlocks.COPPER_GOLD_BLOCK);
                        entries.add(ModBlocks.GOLD_IRON_BLOCK);
                        entries.add(ModBlocks.COPPER_NETHERITE_BLOCK);
                        entries.add(ModBlocks.IRON_NETHERITE_BLOCK);
                        entries.add(ModBlocks.SILICON_BLOCK);

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
