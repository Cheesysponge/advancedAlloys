package name.advancedalloys.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import name.advancedalloys.recipe.AlloyBlasterRecipe;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.collect.ImmutableList;


import java.util.List;
import java.util.Optional;

class AlloyBlasterDisplay implements Display {
    private final AlloyBlasterRecipe recipe;
    private final List<EntryIngredient> inputs;
    private final List<EntryIngredient> outputs;

    public AlloyBlasterDisplay(AlloyBlasterRecipe recipe) {
        this.recipe = recipe;
        this.inputs = ImmutableList.of(
                EntryIngredients.ofIngredient(Ingredient.ofItems(Items.COAL)),
                EntryIngredients.ofIngredient(recipe.getTopInput()),
                EntryIngredients.ofIngredient(recipe.getBottomInput()));
        this.outputs = ImmutableList.of(EntryIngredients.of(recipe.getResultItem()));
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return inputs;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AlloyBlasterRecipeCategory.ALLOY_BLASTING;
    }


}