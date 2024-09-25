package name.advancedalloys;

import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedAlloys implements ModInitializer {
    public static final String MOD_ID = "advancedalloys";
    public static final Logger LOGGER = LoggerFactory.getLogger("advancedalloys");

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

    }
}
