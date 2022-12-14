package cn.travellers.timeinvitation;

import cn.travellers.timeinvitation.Bimoe.TimeInvitationBiomes;
import cn.travellers.timeinvitation.Registry.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Utils.MOD_ID)
public class TimeInvitation {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TimeInvitation() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //FluidRegistry.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FeatureRegistry.FEATURE.register(FMLJavaModLoadingContext.get().getModEventBus());
        PlacementRegistry.PLACEMENT.register(FMLJavaModLoadingContext.get().getModEventBus());
        BiomeRegistry.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("timeinvitation", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBiomeRegistry(FMLCommonSetupEvent event) {
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(TimeInvitationBiomes.ANCIENT_FERN_FOREST,500));
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(TimeInvitationBiomes.ANCIENT_FERN_FOREST_EDGE,500));
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(TimeInvitationBiomes.MODIFIED_ANCIENT_FERN_FOREST,500));
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(TimeInvitationBiomes.MODIFIED_ANCIENT_FERN_FOREST_EDGE,500));
        }
    }
}
