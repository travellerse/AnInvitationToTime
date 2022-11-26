package cn.travellers.timeinvitation.Bimoe;

import cn.travellers.timeinvitation.Registry.BlockRegistry;
import cn.travellers.timeinvitation.Registry.FeatureRegistry;
import cn.travellers.timeinvitation.Registry.PlacementRegistry;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.JungleFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class TimeInvitationFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_FERN = register("fancy_fern", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.fernStem.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.fernLeaves.getDefaultState()), new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<?, ?> FERN_BUSH = register("fern_bush", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.fernStem.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.fernLeaves.getDefaultState()), new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_FERN_TREE = register("mega_jungle_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.fernStem.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.fernLeaves.getDefaultState()), new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2), new MegaJungleTrunkPlacer(10, 2, 19), new TwoLayerFeature(1, 1, 2))).setDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FERN_TREE = register("fern_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.fernStem.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.fernLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(new CocoaTreeDecorator(0.2F), TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).setIgnoreVines().build()));
    public static final ConfiguredFeature<?, ?> TREES_FERN_EDGE = register("trees_fern_edge", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_FERN.withChance(0.1F), FERN_BUSH.withChance(0.5F)), FERN_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> TREES_FERN = register("trees_fern", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_FERN.withChance(0.1F), FERN_BUSH.withChance(0.5F), MEGA_FERN_TREE.withChance(0.33333334F)), FERN_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        //System.out.println("Create ConfiguredFeature.");
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
