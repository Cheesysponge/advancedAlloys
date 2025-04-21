package name.advancedalloys.client;

import name.advancedalloys.particle.ModParticles;
import name.advancedalloys.particle.custom.GuardianCritParticle;
import name.advancedalloys.particle.custom.GuardianSweepParticle;
import name.advancedalloys.screen.AlloyBlasterScreen;
import name.advancedalloys.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class AdvancedAlloysClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.ALLOY_BLASTER_SCREEN_HANDLER, AlloyBlasterScreen::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GUARDIAN_SWEEP_PARTICLE, GuardianSweepParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GUARDIAN_CRIT_PARTICLE, GuardianCritParticle.Factory::new);
        
    }
}
