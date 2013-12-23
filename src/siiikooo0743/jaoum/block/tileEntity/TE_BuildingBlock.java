package siiikooo0743.jaoum.block.tileEntity;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TE_BuildingBlock extends TileEntity
{
	
	public int TextureBlockID;
	public int TextureBlockMetadata;
	NBTTagCompound tag;
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   this.setDataToTag();
	   par1.setTag("jaoum.buildingblock", tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   
	   tag = (NBTTagCompound) par1.getTag("jaoum.buildingblock");
	   this.getDataFromTag();
	}
	
	public void setDataToTag()
	{
		tag = new NBTTagCompound();
		tag.setInteger("ID", TextureBlockID);
		tag.setInteger("Meatdata", TextureBlockMetadata);
	}
	
	public void getDataFromTag()
	{
		if(tag != null)
		{
			TextureBlockID = tag.getInteger("ID");
			TextureBlockMetadata = tag.getInteger("Metadata");
		}
	}
	
	@Override
	public void invalidate() 
	{
		super.invalidate();
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound var1 = new NBTTagCompound();
		this.writeToNBT(var1);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 2, var1);
	}
	        
	@Override
	public void onDataPacket(INetworkManager netManager, Packet132TileEntityData packet)
	{
		readFromNBT(packet.data);
	}
	
}
