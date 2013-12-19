package siiikooo0743.jaoum;

import javax.swing.JApplet;

import net.minecraft.item.Item;
import siiikooo0743.jaoum.block.tileEntity.TE_BuildingBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy 
{
	// Client stuff
    public void registerRenderers() 
    {
            // Nothing here as the server doesn't render graphics or entities!
    }
    
    public void registerNames()
    {
    	LanguageRegistry.addName(JAOUM.bBSwitch, "Building Block Switch");
    	
    	LanguageRegistry.addName(JAOUM.buildingBlock, "Building Block");
    }
    
    public void registerBlocksAndItems()
    {
    	GameRegistry.registerItem(JAOUM.bBSwitch, "bBSwitch");
    	
    	GameRegistry.registerBlock(JAOUM.buildingBlock, "buildingBlock");
    }
    
    public void registerTileEntitys()
    {
    	GameRegistry.registerTileEntity(TE_BuildingBlock.class, "buildingBlock");
    }
    
    public void makeBuildingBlockMeta1Unbreakable()
    {
    	for(int ix = 0; ix < Item.itemsList.length; ix++)
    	{
    	}
    }
}
