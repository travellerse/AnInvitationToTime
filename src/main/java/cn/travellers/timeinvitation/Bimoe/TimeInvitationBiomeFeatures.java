package cn.travellers.timeinvitation.Bimoe;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;

public class TimeInvitationBiomeFeatures {
    public static void withFernTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TimeInvitationFeatures.TREES_FERN);
    }
    public static void withFernEdgeTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TimeInvitationFeatures.TREES_FERN_EDGE);
    }
}
