package name.advancedalloys.datagen;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import name.advancedalloys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import java.util.function.Consumer;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    protected ModAdvancementProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        ModBlocks.ALLOY_BLASTER, // The display icon
                        Text.literal("Your First Alloy Blaster"), // The title
                        Text.literal("Time to make some alloys"), // The description
                        new Identifier(AdvancedAlloys.MOD_ID,"textures/block/copper_gold_block.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_blaster", InventoryChangedCriterion.Conditions.items(ModBlocks.ALLOY_BLASTER))
                .build(consumer, "advancedalloys" + "/root");

        Advancement getCopperIronAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.COPPER_IRON_INGOT,
                        Text.literal("Copper Iron"),
                        Text.literal("Copper Iron is better than iron AND copper!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_iron", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_IRON_INGOT))
                .build(consumer, "advancedalloys" + "/got_copper_iron");
        Advancement getCopperGoldAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.COPPER_GOLD_INGOT,
                        Text.literal("Copper Gold"),
                        Text.literal("Copper Gold is better than gold AND copper!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_gold", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_GOLD_INGOT))
                .build(consumer, "advancedalloys" + "/got_copper_gold");
        Advancement getGoldIronAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.GOLD_IRON_INGOT,
                        Text.literal("Gold Iron"),
                        Text.literal("Gold Iron is better than iron AND gold!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_gold_iron", InventoryChangedCriterion.Conditions.items(ModItems.GOLD_IRON_INGOT))
                .build(consumer, "advancedalloys" + "/got_gold_iron");
        Advancement getSiliconAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.SILICON_INGOT,
                        Text.literal("Silicon"),
                        Text.literal("Silicon has special properties"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_silicon", InventoryChangedCriterion.Conditions.items(ModItems.SILICON_INGOT))
                .build(consumer, "advancedalloys" + "/got_silicon");
        Advancement getCopperNetheriteAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.COPPER_NETHERITE_INGOT,
                        Text.literal("Copper Netherite"),
                        Text.literal("Copper Netherite is more durable than netherite!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_netherite", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_NETHERITE_INGOT))
                .build(consumer, "advancedalloys" + "/got_copper_netherite");
        Advancement getIronNetheriteAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.IRON_NETHERITE_INGOT,
                        Text.literal("Iron Netherite"),
                        Text.literal("Iron Netherite is stronger than netherite!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_iron_netherite", InventoryChangedCriterion.Conditions.items(ModItems.IRON_NETHERITE_INGOT))
                .build(consumer, "advancedalloys" + "/got_iron_netherite");
        Advancement getOxidizedCopperAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.OXIDIZED_COPPER_INGOT,
                        Text.literal("Oxidized Copper"),
                        Text.literal("Oxidized Copper has special properties"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_oxidized_copper", InventoryChangedCriterion.Conditions.items(ModItems.OXIDIZED_COPPER_INGOT))
                .build(consumer, "advancedalloys" + "/got_oxidized_copper");



    }

}
