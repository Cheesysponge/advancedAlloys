package name.advancedalloys.block.entity;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static BlockEntityType<AlloyBlasterBlockEntity> ALLOY_BLASTER;

    public static void registerAllBlockEntities(){
        ALLOY_BLASTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(AdvancedAlloys.MOD_ID, "alloy_blaster"),
                FabricBlockEntityTypeBuilder.create(AlloyBlasterBlockEntity::new,
                        ModBlocks.ALLOY_BLASTER).build(null));
    }
}