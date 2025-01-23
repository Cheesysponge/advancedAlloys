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
                        new Identifier(AdvancedAlloys.MOD_ID,"textures/block/mixed_block.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_blaster", InventoryChangedCriterion.Conditions.items(ModBlocks.ALLOY_BLASTER))
                .build(consumer, "advancedalloys" + "/root");
        Advancement getCopperAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.COPPER_INGOT,
                        Text.literal("Coppering Time"),
                        Text.literal("Copper is very useful for tools and armor!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .build(consumer, "advancedalloys" + "/got_copper");
        Advancement getCopperArmorAdvancement = Advancement.Builder.create().parent(getCopperAdvancement)
                .display(
                        ModItems.COPPER_CHESTPLATE,
                        Text.literal("Copper Armor"),
                        Text.literal("Get a full set of Copper Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_armor", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_CHESTPLATE,ModItems.COPPER_LEGGINGS,ModItems.COPPER_BOOTS,ModItems.COPPER_HELMET))
                .build(consumer, "advancedalloys" + "/got_copper_armor");
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
        Advancement getCopperIronArmorAdvancement = Advancement.Builder.create().parent(getCopperIronAdvancement)
                .display(
                        ModItems.COPPER_IRON_CHESTPLATE,
                        Text.literal("Ferrous Copper Armor"),
                        Text.literal("Get a full set of Copper Iron Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_iron_armor", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_IRON_CHESTPLATE,ModItems.COPPER_IRON_LEGGINGS,ModItems.COPPER_IRON_BOOTS,ModItems.COPPER_IRON_HELMET))
                .build(consumer, "advancedalloys" + "/got_copper_iron_armor");
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
        Advancement getCopperGoldArmorAdvancement = Advancement.Builder.create().parent(getCopperGoldAdvancement)
                .display(
                        ModItems.COPPER_GOLD_CHESTPLATE,
                        Text.literal("Rose Gold Armor"),
                        Text.literal("Get a full set of Copper Gold Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_gold_armor", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_GOLD_CHESTPLATE,ModItems.COPPER_GOLD_LEGGINGS,ModItems.COPPER_GOLD_BOOTS,ModItems.COPPER_GOLD_HELMET))
                .build(consumer, "advancedalloys" + "/got_copper_gold_armor");
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
        Advancement getGoldIronArmorAdvancement = Advancement.Builder.create().parent(getGoldIronAdvancement)
                .display(
                        ModItems.GOLD_IRON_CHESTPLATE,
                        Text.literal("Gilded Iron Armor"),
                        Text.literal("Get a full set of Gold Iron Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_gold_iron_armor", InventoryChangedCriterion.Conditions.items(ModItems.GOLD_IRON_CHESTPLATE,ModItems.GOLD_IRON_LEGGINGS,ModItems.GOLD_IRON_BOOTS,ModItems.GOLD_IRON_HELMET))
                .build(consumer, "advancedalloys" + "/got_gold_iron_armor");
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
        Advancement getSiliconArmorAdvancement = Advancement.Builder.create().parent(getSiliconAdvancement)
                .display(
                        ModItems.SILICON_CHESTPLATE,
                        Text.literal("Silicon Armor"),
                        Text.literal("Get a full set of Silicon Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_silicon_armor", InventoryChangedCriterion.Conditions.items(ModItems.SILICON_CHESTPLATE,ModItems.SILICON_LEGGINGS,ModItems.SILICON_BOOTS,ModItems.SILICON_HELMET))
                .build(consumer, "advancedalloys" + "/got_silicon_armor");
        Advancement getCopperNetheriteAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.COPPER_NETHERITE_INGOT,
                        Text.literal("Copper Netherite"),
                        Text.literal("Copper Netherite is more durable than netherite!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_netherite", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_NETHERITE_INGOT))
                .build(consumer, "advancedalloys" + "/got_copper_netherite");
        Advancement getCopperNetheriteArmorAdvancement = Advancement.Builder.create().parent(getCopperNetheriteAdvancement)
                .display(
                        ModItems.COPPER_NETHERITE_CHESTPLATE,
                        Text.literal("Copper Netherite Armor"),
                        Text.literal("Get a full set of Copper Netherite Armor which DOES NOT LOOK LIKE POO"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_copper_netherite_armor", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_NETHERITE_CHESTPLATE,ModItems.COPPER_NETHERITE_LEGGINGS,ModItems.COPPER_NETHERITE_BOOTS,ModItems.COPPER_NETHERITE_HELMET))
                .build(consumer, "advancedalloys" + "/got_copper_netherite_armor");
        Advancement getIronNetheriteAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.IRON_NETHERITE_INGOT,
                        Text.literal("Iron Netherite"),
                        Text.literal("Iron Netherite is stronger than netherite!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_iron_netherite", InventoryChangedCriterion.Conditions.items(ModItems.IRON_NETHERITE_INGOT))
                .build(consumer, "advancedalloys" + "/got_iron_netherite");
        Advancement getIronNetheriteArmorAdvancement = Advancement.Builder.create().parent(getIronNetheriteAdvancement)
                .display(
                        ModItems.IRON_NETHERITE_CHESTPLATE,
                        Text.literal("Smooth Stone Armor"),
                        Text.literal("Get a full set of Iron Netherite Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_iron_netherite_armor", InventoryChangedCriterion.Conditions.items(ModItems.IRON_NETHERITE_CHESTPLATE,ModItems.IRON_NETHERITE_LEGGINGS,ModItems.IRON_NETHERITE_BOOTS,ModItems.IRON_NETHERITE_HELMET))
                .build(consumer, "advancedalloys" + "/got_iron_netherite_armor");
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
        Advancement getOxidizedCopperArmorAdvancement = Advancement.Builder.create().parent(getOxidizedCopperAdvancement)
                .display(
                        ModItems.OXIDIZED_COPPER_CHESTPLATE,
                        Text.literal("Gilded Copper Armor"),
                        Text.literal("Get a full set of Oxidized Copper Armor which is perfectly fine and has no issues whatsoever"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("got_oxidized_copper_armor", InventoryChangedCriterion.Conditions.items(ModItems.OXIDIZED_COPPER_CHESTPLATE,ModItems.OXIDIZED_COPPER_LEGGINGS,ModItems.OXIDIZED_COPPER_BOOTS,ModItems.OXIDIZED_COPPER_HELMET))
                .build(consumer, "advancedalloys" + "/got_oxidized_copper_armor");
        Advancement getSiliconNetheriteAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.SILICON_NETHERITE_INGOT,
                        Text.literal("Silicon Netherite"),
                        Text.literal("Silicon Netherite is better than netherite!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_silicon_netherite", InventoryChangedCriterion.Conditions.items(ModItems.SILICON_NETHERITE_INGOT))
                .build(consumer, "advancedalloys" + "/got_silicon_netherite");
        Advancement getSiliconNetheriteArmorAdvancement = Advancement.Builder.create().parent(getSiliconNetheriteAdvancement)
                .display(
                        ModItems.SILICON_NETHERITE_CHESTPLATE,
                        Text.literal("Nicer Netherite Armor"),
                        Text.literal("Get a full set of Silicon Netherite Armor"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_silicon_netherite_armor", InventoryChangedCriterion.Conditions.items(ModItems.SILICON_NETHERITE_CHESTPLATE,ModItems.SILICON_NETHERITE_LEGGINGS,ModItems.SILICON_NETHERITE_BOOTS,ModItems.SILICON_NETHERITE_HELMET))
                .build(consumer, "advancedalloys" + "/got_silicon_netherite_armor");

        Advancement getAllAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModBlocks.MIXED_BLOCK,
                        Text.literal("Mixing Everything"),
                        Text.literal("Get everything."),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .rewards(AdvancementRewards.Builder.experience(100000))
                .criterion("got_everything", InventoryChangedCriterion.Conditions.items(ModItems.ingots))
                .build(consumer, "advancedalloys" + "/got_everything");

    }

}
