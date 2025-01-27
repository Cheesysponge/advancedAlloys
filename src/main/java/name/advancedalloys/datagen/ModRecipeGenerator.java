package name.advancedalloys.datagen;

import dev.architectury.platform.Mod;
import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.Consumer;

import static net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ALLOY_BLASTER)
                .pattern("###")
                .pattern("#I#")
                .pattern("###")
                .input('I', Items.IRON_INGOT)
                .input('#', Items.OBSERVER)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.OBSERVER),
                        FabricRecipeProvider.conditionsFromItem(Items.OBSERVER))
                .offerTo(exporter, new Identifier("alternative_"+FabricRecipeProvider.getRecipeName(ModBlocks.ALLOY_BLASTER)));//FabricRecipeProvider.getRecipeName(ModBlocks.ALLOY_BLASTER)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.KATANA)
                .pattern(" O#")
                .pattern("N#O")
                .pattern("IN ")
                .input('I', ModItems.IRON_NETHERITE_INGOT)
                .input('#', ModBlocks.SILICON_BLOCK)
                .input('N', ModItems.OXIDIZED_COPPER_INGOT)
                .input('O', Items.IRON_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SILICON_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SILICON_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.OXIDIZED_COPPER_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.OXIDIZED_COPPER_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.IRON_NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.IRON_NETHERITE_INGOT))
                .offerTo(exporter, new Identifier("alternative_"+FabricRecipeProvider.getRecipeName(ModItems.KATANA)));
        for(int i = 0; i<ModItems.tools.length; i++) {
            recipeGenerator(exporter, ModItems.tools[i]);
        }
        for(int i = 0; i<ModItems.armor.length; i++) {
            recipeGenerator(exporter, ModItems.armor[i]);
        }
        for(int i = 0; i<ModBlocks.alloy_blocks.length; i++) {
            recipeGenerator(exporter, Item.fromBlock(ModBlocks.alloy_blocks[i]));
        }
        recipeGenerator(exporter, Items.OXIDIZED_COPPER);}

    public void smithingRecipeGenerator(Consumer<RecipeJsonProvider> exporter, Item first) {
        Item ingot = Items.BARRIER;
        Item base = Items.BARRIER;
        String itemName = getRecipeName(first);
        if(itemName.contains("copper_netherite")) {
            ingot = ModItems.COPPER_NETHERITE_INGOT;
        }
        else if(itemName.contains("iron_netherite")) {
            ingot = ModItems.IRON_NETHERITE_INGOT;
        }
        else if(itemName.contains("silicon_netherite")) {
            ingot = ModItems.SILICON_NETHERITE_INGOT;
        }

        if(itemName.contains("helmet")) {
            base = Items.DIAMOND_HELMET;
        }
        else if(itemName.contains("chestplate")) {
            base = Items.DIAMOND_CHESTPLATE;
        }
        else if(itemName.contains("leggings")) {
            base = Items.DIAMOND_LEGGINGS;
        }
        else if(itemName.contains("boots")) {
            base = Items.DIAMOND_BOOTS;
        }
        else if(itemName.contains("pickaxe")) {
            base = Items.DIAMOND_PICKAXE;
        }
        else if(itemName.contains("axe")) {
            base = Items.DIAMOND_AXE;
        }
        else if(itemName.contains("sword")) {
            base = Items.DIAMOND_SWORD;
        }
        else if(itemName.contains("shovel")) {
            base = Items.DIAMOND_SHOVEL;
        }
        else if(itemName.contains("hoe")) {
            base = Items.DIAMOND_HOE;
        }


        if(base != Items.BARRIER && ingot !=Items.BARRIER) {
            SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.ofItems(base), Ingredient.ofItems(ingot), RecipeCategory.COMBAT, first)
                    .criterion(FabricRecipeProvider.hasItem(base),
                            FabricRecipeProvider.conditionsFromItem(base))
                    .criterion(FabricRecipeProvider.hasItem(ingot),
                            FabricRecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, new Identifier("generated_smithing_" + itemName));
        }

    }

    public void recipeGenerator(Consumer<RecipeJsonProvider> exporter, Item Output){
        smithingRecipeGenerator(exporter, Output);
        Item First = Items.BARRIER;
        String OutName = getRecipeName(Output);
        AdvancedAlloys.LOGGER.info("Recipe Generated for: " + OutName);

        if(OutName.contains("copper_iron")) {
            First = ModItems.COPPER_IRON_INGOT;
        }
        else if(OutName.contains("copper_gold")) {
            First = ModItems.COPPER_GOLD_INGOT;
        }
        else if(OutName.contains("copper_netherite")) {
            First = ModItems.COPPER_NETHERITE_INGOT;
        }
        else if(OutName.contains("oxidized_copper")) {
            First = ModItems.OXIDIZED_COPPER_INGOT;
        }
        else if(OutName.contains("copper")) {
            First = Items.COPPER_INGOT;
        }
        else if(OutName.contains("gold_iron")) {
            First = ModItems.GOLD_IRON_INGOT;
        }
        else if(OutName.contains("iron_netherite")) {
            First = ModItems.IRON_NETHERITE_INGOT;
        }
        else if(getRecipeName(Output).contains("silicon_netherite")) {
            First = ModItems.SILICON_NETHERITE_INGOT;
        }
        else if(getRecipeName(Output).contains("silicon")) {
            First = ModItems.SILICON_INGOT;
        }


        if(getRecipeName(Output).contains("sword")){
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("#")
                    .pattern("#")
                    .pattern("I")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("_axe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("##")
                    .pattern("I#")
                    .pattern("I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("pickaxe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern(" I ")
                    .pattern(" I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("hoe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("##")
                    .pattern("I ")
                    .pattern("I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("multitool")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("#I#")
                    .pattern("I##")
                    .input('I', Items.STICK)
                    .input('#', First)
                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("shovel")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("#")
                    .pattern("I")
                    .pattern("I")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("chestplate")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("leggings")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("boots")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("helmet")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("# #")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }

        if(getRecipeName(Output).contains("block")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, First,9)
                    .input(Output)
                    .criterion(FabricRecipeProvider.hasItem(Output),
                            FabricRecipeProvider.conditionsFromItem(Output))
                    .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(First)));
        }

    }

}