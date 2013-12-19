package siiikooo0743.jaoum.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siiikooo0743.jaoum.JAOUM;
import siiikooo0743.jaoum.block.tileEntity.TE_BuildingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BuildingBlock extends Block implements ITileEntityProvider
{
	public BuildingBlock(int par1) 
	{
		super(par1, Material.rock);
		this.setHardness(0.1F);
		this.setResistance(6000000.0F);
		this.setTickRandomly(true);
		MinecraftForge.setBlockHarvestLevel(JAOUM.buildingBlock, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(JAOUM.buildingBlock, 1, "pickaxe", 10);
	}
	
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) 
	{
		if(par5 != 0)
		{
			par1World.setBlock(par2, par3, par4, JAOUM.buildingBlock.blockID, par5, 2);
		}
	}
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (hasTileEntity(par6))
        {
            par1World.removeBlockTileEntity(par2, par3, par4);
        }
    }
	
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if(metadata == 0)
        {
        	ret.add(new ItemStack(JAOUM.buildingBlock));
        }
        return ret;
    }

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
		if(te instanceof TE_BuildingBlock)
		{
			TE_BuildingBlock teB = (TE_BuildingBlock)te;
			ItemStack iS = par5EntityPlayer.getCurrentEquippedItem();
			if(iS != null)
			{
				if(iS.getItem() instanceof ItemBlock)
				{
					ItemBlock iB = (ItemBlock) iS.getItem();
					int id = iB.getBlockID();
					if(Block.blocksList[id].renderAsNormalBlock())
					{
						teB.TextureBlockID = id;
						teB.TextureBlockMetadata = iS.getItemDamage();
						par5EntityPlayer.addChatMessage("Block:"+ teB.TextureBlockID);
						par1World.markBlockForRenderUpdate(par2, par3, par4);
						return true;
					}
				}
			}
		}
		
        return false;
    }
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) 
	{

	}

	@Override
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side)  
	{
		TileEntity te = par1IBlockAccess.getBlockTileEntity(x, y, z);
		if(te instanceof TE_BuildingBlock)
		{
			TE_BuildingBlock teB = (TE_BuildingBlock)te;
			if(teB.TextureBlockID != 0)
			{
				
				return (Block.blocksList[teB.TextureBlockID].getIcon(side, teB.TextureBlockMetadata));
				
			}
		}
		return this.blockIcon;
    }
	
	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z)
    {
		if(world.getBlockMetadata(x, y, z) == 0)
		{
	        return world.setBlockToAir(x, y, z);
		}
		else
		{
			return false;
		}
    }
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
	{
		
	}
	
	@Override
	public boolean hasTileEntity(int metadata)
	{
		if(metadata < 2)
		{
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
	    return new TE_BuildingBlock();
	}

}
