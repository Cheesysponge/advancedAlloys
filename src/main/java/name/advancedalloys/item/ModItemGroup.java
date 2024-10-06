package name.advancedalloys.item;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    //public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "blocks"),
      //      () -> new ItemStack(ModBlocks.COPPER_GOLD_BLOCK));
    //public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "armor"),
        //    () -> new ItemStack(ModItems.COPPER_CHESTPLATE));
    //public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(AdvancedAlloys.MOD_ID, "tools"),
          //  () -> new ItemStack(ModItems.GOLD_IRON_AXE));

    public static ItemGroup ALLOYS = FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "alloy"))
            .displayName(Text.literal("Alloys"))
            .icon(() -> new ItemStack(ModItems.COPPER_IRON_INGOT)).build();;
    public static ItemGroup BLOCKS = FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "blocks"))
            .displayName(Text.literal("Blocks"))
            .icon(() -> new ItemStack(ModBlocks.COPPER_GOLD_BLOCK)).build();;
    public static ItemGroup ARMOR= FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "armor"))
            .displayName(Text.literal("Armor"))
            .icon(() -> new ItemStack(ModItems.COPPER_NETHERITE_CHESTPLATE)).build();;
    public static ItemGroup TOOLS= FabricItemGroup.builder(new Identifier(AdvancedAlloys.MOD_ID, "tools"))
            .displayName(Text.literal("Tools"))
            .icon(() -> new ItemStack(ModItems.OXIDIZED_COPPER_PICKAXE)).build();;




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
