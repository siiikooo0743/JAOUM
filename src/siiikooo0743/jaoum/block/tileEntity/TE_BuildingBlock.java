package siiikooo0743.jaoum.block.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TE_BuildingBlock extends TileEntity
{
	
	public int TextureBlockID;
	public int TextureBlockMetadata;
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   par1.setInteger("TextureBlockID", TextureBlockID);
	   par1.setInteger("TextureBlockMetadata", TextureBlockMetadata);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   this.getWorldObj();
	   TextureBlockID = par1.getInteger("TextureBlockID");
	   TextureBlockMetadata = par1.getInteger("TextureBlockMetadata");
	}
	
	@Override
	public void invalidate() 
	{
		super.invalidate();
	}
}
