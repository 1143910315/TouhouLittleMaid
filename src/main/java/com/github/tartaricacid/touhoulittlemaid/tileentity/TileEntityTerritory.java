package com.github.tartaricacid.touhoulittlemaid.tileentity;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityTerritory extends TileEntity {

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        TextComponentString a = new TextComponentString("readFromNBT " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        TextComponentString a = new TextComponentString("writeToNBT " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
        return super.writeToNBT(compound);
    }

    @Nonnull
    @Override
    public NBTTagCompound getUpdateTag() {
        TextComponentString a = new TextComponentString("getUpdateTag " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
        return super.getUpdateTag();
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        TextComponentString a = new TextComponentString("getUpdatePacket " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
        return super.getUpdatePacket();
    }

    @Override
    public void handleUpdateTag(@Nonnull NBTTagCompound compound) {
        super.handleUpdateTag(compound);
        TextComponentString a = new TextComponentString("handleUpdateTag " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, SPacketUpdateTileEntity packetUpdateTileEntity) {
        super.onDataPacket(networkManager, packetUpdateTileEntity);
        TextComponentString a = new TextComponentString("onDataPacket " + (world.isRemote ? "is remote" : "isn't remote"));
        world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(a));
        TouhouLittleMaid.LOGGER.info(a.getText());
    }
}
