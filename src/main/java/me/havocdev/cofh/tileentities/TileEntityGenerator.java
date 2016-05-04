package me.havocdev.cofh.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.TileEnergyHandler;

public class TileEntityGenerator extends TileEnergyHandler implements
		IEnergyProvider {
	/** This generates power only at night time until day time 0 */
	public TileEntityGenerator() {
		this.storage.setCapacity(10000);
		this.storage.setMaxExtract(50);
		this.storage.setMaxReceive(0);
		this.storage.setEnergyStored(0);
	}

	/**
	 * invoked by updateEnergy to check if there is energy in block -> sends it
	 * to all sides of the machine
	 **/
	public void transmitEnergy() {
		if (storage.getEnergyStored() > 0) {
			for (int i = 0; i < 6; i++) {

				int targetX = xCoord + ForgeDirection.getOrientation(i).offsetX;
				int targetY = yCoord + ForgeDirection.getOrientation(i).offsetY;
				int targetZ = zCoord + ForgeDirection.getOrientation(i).offsetZ;

				TileEntity tile = worldObj.getTileEntity(targetX, targetY,
						targetZ);

				if (tile instanceof IEnergyHandler
						&& ((IEnergyHandler) tile)
								.getMaxEnergyStored(ForgeDirection
										.getOrientation(i).getOpposite()) > ((IEnergyHandler) tile)
								.getEnergyStored(ForgeDirection.getOrientation(
										i).getOpposite())) {

					int maxExtract = storage.getMaxExtract();
					int maxAvailable = storage.extractEnergy(maxExtract, true);
					int energyTransferred = ((IEnergyHandler) tile)
							.receiveEnergy(ForgeDirection.getOrientation(i)
									.getOpposite(), maxAvailable, false);
					storage.extractEnergy(energyTransferred, false);
					storage.setEnergyStored(storage.getEnergyStored()
							- maxAvailable);
				}
			}
		}
	}
	
	/** Checks if its night or later to give energy */
	public void genEnergy() {
		if (worldObj.getWorldTime() >= 18000)
			storage.setEnergyStored(storage.getEnergyStored() + 10);
	}

	/** Main Tick loop **/
	@Override
	public void updateEntity() {
		genEnergy();
		transmitEnergy();
	}
}
