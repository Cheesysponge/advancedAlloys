package name.advancedalloys.item.custom;

import name.advancedalloys.AdvancedAlloys;
import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
public class MultiTool extends MiningToolItem {
    public static final TagKey<Block> MULTI_TAG = TagKey.of(RegistryKeys.BLOCK, new Identifier(AdvancedAlloys.MOD_ID, "multi_tag"));


    public MultiTool(ToolMaterial material, float attackSpeed, float attackDamage, Settings settings) {
        super(attackDamage, attackSpeed, material, MULTI_TAG, settings);
    }
}

