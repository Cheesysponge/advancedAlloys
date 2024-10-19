package name.advancedalloys.datagen;

import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
    }


    public void recipeGenerator(Item First, String type, Consumer<RecipeJsonProvider> exporter, Item Output){
        if(type.equals("sword")) {
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
                    .offerTo(exporter, new Identifier("alternative_" + FabricRecipeProvider.getRecipeName(Output)));
        }
    }
    public void recipeGenerator(Item First, Item Second, String type, Consumer<RecipeJsonProvider> exporter){
    }

}