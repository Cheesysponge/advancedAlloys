package name.advancedalloys.compat;


import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;

import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.recipe.AlloyBlasterRecipe;
import name.advancedalloys.recipe.ModRecipes;
import name.advancedalloys.screen.AlloyBlasterScreen;
import net.minecraft.item.ItemStack;


public class ModREIClientPlugin implements REIClientPlugin{



    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AlloyBlasterRecipeCategory());

        registerWorkingStations(registry);

    }
    @Override
    public String getPluginProviderName() {
        return "AdvancedAlloys";
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(AlloyBlasterRecipe.class, AlloyBlasterRecipe.Type.INSTANCE, AlloyBlasterDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(
                new Rectangle(75, 30, 20, 30),
                AlloyBlasterScreen.class,
                AlloyBlasterRecipeCategory.ALLOY_BLASTING);
    }
    private void registerWorkingStations(CategoryRegistry registry) {


        ItemStack inscriber = new ItemStack(ModBlocks.ALLOY_BLASTER);
        registry.addWorkstations(AlloyBlasterRecipeCategory.ALLOY_BLASTING, EntryStacks.of(inscriber));
    }
}
