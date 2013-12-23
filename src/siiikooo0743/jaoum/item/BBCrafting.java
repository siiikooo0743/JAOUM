package siiikooo0743.jaoum.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BBCrafting extends Item 
{
	public Icon bBHull;
	public Icon bBTextureMatrix;
	public Icon bBPearl;
	
	public BBCrafting(int id) 
	{
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata (int damageValue) 
	{
		return damageValue;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
		switch(par1)
		{
		case 0:
			return(bBHull);
		case 1:
			return(bBTextureMatrix);
		case 2:
			return(bBPearl);
		default:
			return(bBHull);
		}
    }
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) 
	{
		for (int ix = 0; ix < 16; ix++) 
		{
			par3List.add(new ItemStack(this, 1, ix));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		switch(itemstack.getItemDamage())
		{
		case 0:
			return("bBHull");
		case 1:
			return("bBTextureMatrix");
		case 2:
			return("bBPearl");
		default:
			return("bBHull");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
			bBHull = par1IconRegister.registerIcon("jaoum:bBHull");
			bBTextureMatrix = par1IconRegister.registerIcon("jaoum:bBTextureMatrix");
			bBPearl = par1IconRegister.registerIcon("jaoum:bBPearl");
    }

}
