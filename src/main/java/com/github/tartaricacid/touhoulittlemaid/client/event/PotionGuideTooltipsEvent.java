package com.github.tartaricacid.touhoulittlemaid.client.event;


import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.init.MaidItems;
import com.github.tartaricacid.touhoulittlemaid.item.ItemPotionGuide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = TouhouLittleMaid.MOD_ID, value = Side.CLIENT)
public class PotionGuideTooltipsEvent {
    @SubscribeEvent
    public static void onRenderTooltip(RenderTooltipEvent.PostText event) {
        ItemStack stack = event.getStack();
        if (stack.getItem() == MaidItems.POTION_GUIDE) {
            int x = event.getX();
            int y = event.getY();
            Minecraft mc = Minecraft.getMinecraft();
            ItemStackHandler handler = ItemPotionGuide.getGuideInv(stack);
            int index = ItemPotionGuide.getGuideIndex(stack);
            int offset = 0;

            RenderHelper.enableGUIStandardItemLighting();
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stackInGuide = handler.getStackInSlot(i);
                if (!stackInGuide.isEmpty()) {
                    if (index == i) {
                        Gui.drawRect(x + offset, y + 12, x + offset + 16, y + 28, 0x88ffffff);
                    }
                    mc.getRenderItem().renderItemAndEffectIntoGUI(stackInGuide, x + offset, y + 12);
                    offset += 16;
                }
            }
            RenderHelper.disableStandardItemLighting();
        }
    }
}
