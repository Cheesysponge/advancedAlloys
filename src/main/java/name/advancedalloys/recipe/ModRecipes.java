package name.advancedalloys.recipe;

import name.advancedalloys.AdvancedAlloys;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static final RecipeType<AlloyBlasterRecipe> ALLOY_BLASTER_RECIPE_RECIPE_TYPE = RecipeType.register("alloy_blaster_recipe_type");
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(AdvancedAlloys.MOD_ID, AlloyBlasterRecipe.Serializer.ID), AlloyBlasterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(AdvancedAlloys.MOD_ID, AlloyBlasterRecipe.Type.ID), AlloyBlasterRecipe.Type.INSTANCE);
    }
}