package cn.travellers.timeinvitation.Bimoe;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class TimeInvitationBiomes {
    public static final RegistryKey<Biome> ANCIENT_FERN_FOREST = makeKey("ancient_fern_forest");
    public static final RegistryKey<Biome> ANCIENT_FERN_FOREST_EDGE = makeKey("ancient_fern_forest_edge");
    public static final RegistryKey<Biome> MODIFIED_ANCIENT_FERN_FOREST_EDGE = makeKey("modified_ancient_fern_forest_edge");
    public static final RegistryKey<Biome> MODIFIED_ANCIENT_FERN_FOREST = makeKey("modified_ancient_fern_forest");


    private static RegistryKey<Biome> makeKey(String name) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Utils.MOD_ID,name));
    }
}
