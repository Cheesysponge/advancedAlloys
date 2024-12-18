package name.advancedalloys.datagen;

import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MIXED_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for(int i = 0; i< ModItems.armor.length; i++) {
            itemModelGenerator.registerArmor((ArmorItem) ModItems.armor[i]);
        }
        itemModelGenerator.register(ModItems.SILICON_SULFATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SILICON_SULFATE_DETONATOR,Models.GENERATED);

    }
}