package name.advancedalloys;

import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.block.entity.ModBlockEntities;
import name.advancedalloys.item.ModItemGroup;
import name.advancedalloys.item.ModItems;
import name.advancedalloys.particle.ModParticles;
import name.advancedalloys.recipe.ModRecipes;
import name.advancedalloys.screen.ModScreenHandlers;
import name.advancedalloys.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedAlloys implements ModInitializer {
    public static final String MOD_ID = "advancedalloys";
    public static final Logger LOGGER = LoggerFactory.getLogger("advancedalloys");

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModScreenHandlers.registerAllScreenHandlers();
        ModRecipes.registerRecipes();
        ModBlockEntities.registerAllBlockEntities();
        ModLootTableModifiers.modifyLootTables();
        ModParticles.registerParticles();
    }


}
