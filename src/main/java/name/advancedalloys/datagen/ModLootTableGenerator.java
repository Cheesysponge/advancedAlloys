package name.advancedalloys.datagen;

import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for(int i = 0; i < ModBlocks.alloy_blocks.length; i++) {
            addDrop(ModBlocks.alloy_blocks[i]);
        }
        addDrop(ModBlocks.ALLOY_BLASTER);

    }
}
