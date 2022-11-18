package cn.travellers.timeinvitation.Mixin;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

public class CoreMod {
    public CoreMod(){
        MixinBootstrap.init();
        Mixins.addConfiguration("timeinvitation.mixins.json");
    }
}
