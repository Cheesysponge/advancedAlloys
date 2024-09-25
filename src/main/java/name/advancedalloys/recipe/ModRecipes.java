package name.advancedalloys.recipe;

import name.advancedalloys.AdvancedAlloys;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(AdvancedAlloys.MOD_ID, AlloyBlasterRecipe.Serializer.ID), AlloyBlasterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(AdvancedAlloys.MOD_ID, AlloyBlasterRecipe.Type.ID), AlloyBlasterRecipe.Type.INSTANCE);
    }
}