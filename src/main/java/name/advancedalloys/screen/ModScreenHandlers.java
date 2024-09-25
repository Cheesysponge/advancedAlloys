package name.advancedalloys.screen;

import name.advancedalloys.AdvancedAlloys;
import name.advancedalloys.AdvancedAlloys;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
    public static ScreenHandlerType<AlloyBlasterScreenHandler> ALLOY_BLASTER_SCREEN_HANDLER;



    public static void registerAllScreenHandlers() {
        ALLOY_BLASTER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(AdvancedAlloys.MOD_ID, "alloy_blaster"),
                        AlloyBlasterScreenHandler::new);
    }
}