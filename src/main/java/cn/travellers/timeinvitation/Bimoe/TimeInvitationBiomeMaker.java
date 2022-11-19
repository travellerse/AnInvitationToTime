package cn.travellers.timeinvitation.Bimoe;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class TimeInvitationBiomeMaker {

    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makeAncientBiome(float depth, float scale, float downfall, boolean hasOnlyBambooVegetation, boolean isEdgeBiome, boolean isModified, MobSpawnInfo.Builder mobSpawnBuilder) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);

        if (isEdgeBiome) {
            TimeInvitationBiomeFeatures.withFernEdgeTrees(biomegenerationsettings$builder);
        } else {
            TimeInvitationBiomeFeatures.withFernTrees(biomegenerationsettings$builder);
        }

        DefaultBiomeFeatures.withWarmFlowers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withJungleGrass(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMelonPatchesAndVines(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.JUNGLE).depth(depth).scale(scale).temperature(0.95F).downfall(downfall).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.95F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobSpawnBuilder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();

    }

    public static Biome makeGenericAncientFernForestBiome(float depth, float scale, int parrotWeight, int parrotMaxCount, int ocelotMaxCount) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withSpawnsWithExtraChickens(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PARROT, parrotWeight, 1, parrotMaxCount)).withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, ocelotMaxCount)).withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PANDA, 1, 1, 2));
        mobspawninfo$builder.isValidSpawnBiomeForPlayer();
        return makeAncientBiome(depth, scale, 0.9F, false, false, false, mobspawninfo$builder);
    }

    public static Biome makeAncientFernForestBiome() {
        return makeGenericAncientFernForestBiome(0.1F, 0.2F, 40, 2, 3);
    }

    public static Biome makeAncientFernForestEdgeBiome() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withSpawnsWithExtraChickens(mobspawninfo$builder);
        return makeAncientBiome(0.1F, 0.2F, 0.8F, false, true, false, mobspawninfo$builder);
    }

    public static Biome makeModifiedAncientFernForestEdgeBiome() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withSpawnsWithExtraChickens(mobspawninfo$builder);
        return makeAncientBiome(0.2F, 0.4F, 0.8F, false, true, true, mobspawninfo$builder);
    }

    public static Biome makeModifiedAncientFernForestBiome() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withSpawnsWithExtraChickens(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PARROT, 10, 1, 1)).withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 1));
        return makeAncientBiome(0.2F, 0.4F, 0.9F, false, false, true, mobspawninfo$builder);
    }

    public static Biome makeAncientFernForestHillsBiome() {
        return makeGenericAncientFernForestBiome(0.45F, 0.3F, 10, 1, 1);
    }
    
}
