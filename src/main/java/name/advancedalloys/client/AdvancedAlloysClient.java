package name.advancedalloys.client;

import name.advancedalloys.screen.AlloyBlasterScreen;
import name.advancedalloys.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class AdvancedAlloysClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.ALLOY_BLASTER_SCREEN_HANDLER, AlloyBlasterScreen::new);
    }
}
