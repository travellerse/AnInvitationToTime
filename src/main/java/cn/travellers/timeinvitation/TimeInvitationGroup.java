package cn.travellers.timeinvitation;

import cn.travellers.timeinvitation.Registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TimeInvitationGroup extends ItemGroup {
    public TimeInvitationGroup() {
        super("timeinvitation_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.oldVines.get());
    }

}
