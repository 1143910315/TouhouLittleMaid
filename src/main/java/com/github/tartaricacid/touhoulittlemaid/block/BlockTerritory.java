package com.github.tartaricacid.touhoulittlemaid.block;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.init.MaidItems;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityTerritory;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockTerritory extends Block {
    public BlockTerritory() {
        super(Material.CLAY);
        setTranslationKey(TouhouLittleMaid.MOD_ID + "." + "territory");
        setHardness(1.0f);
        setRegistryName("territory");
        setCreativeTab(MaidItems.MAIN_TABS);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, player, stack);
        if (player instanceof EntityPlayer) {
            EntityPlayer player1 = (EntityPlayer) player;
            //String json = I18n.format("message.touhou_little_maid.missing_patchouli");
            //ITextComponent component = ITextComponent.Serializer.fromJsonLenient(json);
            TextComponentString a = new TextComponentString("测试");
            player1.sendMessage(a);
        }
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer player) {
        super.onBlockClicked(worldIn, pos, player);
        TextComponentString a = new TextComponentString("Clicked");
        player.sendMessage(a);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TextComponentString a = new TextComponentString("Activated " + (worldIn.isRemote ? "is remote" : "isn't remote"));
        //player.sendMessage(a);
        worldIn.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        PlayerCapabilities capabilities = player.capabilities;
        //capabilities.writeCapabilitiesToNBT();
        //worldIn.addEventListener();
        //MinecraftForge.EVENT_BUS;
        return false;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(@Nonnull World world,@Nonnull IBlockState state) {
        TextComponentString a = new TextComponentString("createTileEntity " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
        return new TileEntityTerritory();
    }
}
