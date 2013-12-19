package siiikooo0743.jaoum.item;

import siiikooo0743.jaoum.JAOUM;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BBSwitch extends Item 
{
	int BlockX;
	int BlockY;
	int BlockZ;
	Icon on;
	Icon off;
	boolean isOn;
	public BBSwitch(int id) 
	{
		super(id);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
		if(isOn)
		{
			return on;
		}
		else
		{
			return off;
		}
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
			on = par1IconRegister.registerIcon("jaoum:bBSwitch_on");
			off = par1IconRegister.registerIcon("jaoum:bBSwitch_off");
    }
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
	{
		if(par3Entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) par3Entity;
			if(player.inventory.getCurrentItem() == par1ItemStack)
			{
				if(getBlockLookingAt(player, par2World))
				{					
					if(par2World.getBlockId(BlockX, BlockY, BlockZ) == JAOUM.buildingBlock.blockID)
					{
						if(par2World.getBlockMetadata(BlockX, BlockY, BlockZ) == 0)
						{
							isOn = false;
						}
						else
						{

							isOn = true;
						}
					}
					else
					{
						isOn = false;
					}
				}
				else
				{
					isOn = false;
				}
			}
			else
			{
//				isOn = false;
			}
		}
		else
		{
			isOn = false;
		}
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(par3World.getBlockId(par4, par5, par6) == JAOUM.buildingBlock.blockID)
		{
			if(par3World.getBlockMetadata(par4, par5, par6) == 0)
			{
				par3World.setBlockMetadataWithNotify(par4, par5, par6, 1, 3);
			}
			else
			{
				par3World.setBlockMetadataWithNotify(par4, par5, par6, 0, 3);
			}
			return true;
		}
		
		return false;
	}
	
	public boolean getBlockLookingAt(EntityPlayer p, World world)
	{
		float f = 1.0F;
        float f1 = p.prevRotationPitch + (p.rotationPitch - p.prevRotationPitch) * f;
        float f2 = p.prevRotationYaw + (p.rotationYaw - p.prevRotationYaw) * f;
        double d0 = p.prevPosX + (p.posX - p.prevPosX) * (double)f;
        double d1 = p.prevPosY + (p.posY - p.prevPosY) * (double)f + 1.62D - (double)p.yOffset;
        double d2 = p.prevPosZ + (p.posZ - p.prevPosZ) * (double)f;
        Vec3 vec3 = world.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = 5.0D;
        Vec3 vec31 = vec3.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3, vec31, false, true);
        if (movingobjectposition == null) {
        	return false;
        }
        if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            BlockX = movingobjectposition.blockX;
            BlockY = movingobjectposition.blockY;
            BlockZ = movingobjectposition.blockZ;
            //block is at ix, iy, iz
            return true;
        }
        return false;
	}

}
