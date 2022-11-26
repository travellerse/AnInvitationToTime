package cn.travellers.timeinvitation.Block.Trees;

import cn.travellers.timeinvitation.Bimoe.TimeInvitationFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class FernTree extends BigTree {
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return TimeInvitationFeatures.FERN_TREE;
    }

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random rand) {
        return TimeInvitationFeatures.MEGA_FERN_TREE;
    }
}
