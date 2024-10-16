package name.advancedalloys.compat;


import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlloyBlasterRecipeCategory implements DisplayCategory<AlloyBlasterDisplay> {

    public static final Identifier Texture =
            new Identifier(AdvancedAlloys.MOD_ID,"textures/gui/alloy_blaster_cooked.png");
    public static final CategoryIdentifier<AlloyBlasterDisplay> ALLOY_BLASTING =
            CategoryIdentifier.of(AdvancedAlloys.MOD_ID, "alloy_blaster");




    @Override
    public CategoryIdentifier<? extends AlloyBlasterDisplay> getCategoryIdentifier() {
        return ALLOY_BLASTING;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Alloy Blaster");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.ALLOY_BLASTER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(AlloyBlasterDisplay display, Rectangle bounds) {

        final Point startPoint = new Point(bounds.getCenterX() -87, bounds.getCenterY()-35);

        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createTexturedWidget(Texture, new Rectangle(startPoint.x, startPoint.y, 176, 78)));
//        x + 18, y + 33 + 14 - handler.getScaledFuelProgress(), 176,
//                14 - handler.getScaledFuelProgress(), 14, handler.getScaledFuelProgress()
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 18, startPoint.y + 50))
                .entries(display.getRequiredEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 66, startPoint.y + 16))
                .entries(display.getInputEntries().get(1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 66, startPoint.y + 50))
                .entries(display.getInputEntries().get(2)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 114, startPoint.y + 33))
                .markOutput().entries(display.getOutputEntries().get(0)));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 94;
    }

    @Override
    public int getDisplayWidth(AlloyBlasterDisplay display) {
        return 175;
    }

}
