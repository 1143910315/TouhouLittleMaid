package com.github.tartaricacid.touhoulittlemaid.block;
import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.init.MaidItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTerritory extends Block {
    public BlockTerritory() {
        super(Material.CLAY);
        setTranslationKey(TouhouLittleMaid.MOD_ID + "." + "territory");
        setHardness(1.0f);
        setRegistryName("territory");
        setCreativeTab(MaidItems.MODEL_COUPON_TABS);
    }
}
