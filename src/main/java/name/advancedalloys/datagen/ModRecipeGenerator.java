package name.advancedalloys.datagen;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.Consumer;

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

        for(int i = 0; i<ModItems.tools.length; i++) {
            recipeGenerator(exporter, ModItems.tools[i]);
        }
        for(int i = 0; i<ModItems.armor.length; i++) {
            recipeGenerator(exporter, ModItems.armor[i]);
        }
        for(int i = 0; i<ModBlocks.alloy_blocks.length; i++) {
            recipeGenerator(exporter, Item.fromBlock(ModBlocks.alloy_blocks[i]));
        }
        recipeGenerator(exporter, Items.OXIDIZED_COPPER);
    }


    public void recipeGenerator(Consumer<RecipeJsonProvider> exporter, Item Output){

        Item First = Items.BARRIER;
        String OutName = getRecipeName(Output);
        AdvancedAlloys.LOGGER.info("Out: " + OutName);

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
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, First)
                    .input(Output)
                    .criterion(FabricRecipeProvider.hasItem(Output),
                            FabricRecipeProvider.conditionsFromItem(Output))
                    .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(First)));
        }

    }
    public void recipeGenerator(Item First, Item Second, String type, Consumer<RecipeJsonProvider> exporter){
    }

}