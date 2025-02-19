package name.advancedalloys.datagen;

import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static net.minecraft.data.server.recipe.RecipeProvider.getRecipeName;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MIXED_BLOCK);

        for(Block block : ModBlocks.alloy_blocks) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.ALLOY_BLASTER, Identifier.of("advancedalloys","block/"+getRecipeName(ModBlocks.ALLOY_BLASTER.asItem())));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for(int i = 0; i< ModItems.armor.length; i++) {
            itemModelGenerator.registerArmor((ArmorItem) ModItems.armor[i]);
        }
        for(Item block : ModItems.tools) {
            itemModelGenerator.register(block, Models.HANDHELD);
        }
        for(Item block : ModItems.ingots) {
            itemModelGenerator.register(block, Models.GENERATED);
        }

        itemModelGenerator.register(ModItems.SILICON_SULFATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ELDER_GUARDIAN_EYE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ELDER_GUARDIAN_SCALE,Models.GENERATED);


        itemModelGenerator.register(ModItems.SILICON_SULFATE_DETONATOR,Models.GENERATED);

    }
}