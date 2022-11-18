package cn.travellers.timeinvitation.Bimoe;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    //public static final RegistryKey<Biome> VANITY_LAKE = makeKey("vanity_lake");

    private static RegistryKey<Biome> makeKey(String name) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Utils.MOD_ID,name));
    }
}
