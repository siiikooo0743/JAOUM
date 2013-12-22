package siiikooo0743.jaoum;

import javax.swing.JApplet;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
    	String[] names = {"Building Block Hull", "Texture Matrix", "Remote Comunication Pearl"};
    	for (int ix = 0; ix < 3; ix++) 
        {
        	ItemStack Stack = new ItemStack(JAOUM.bBCrafting, 1, ix);
        	
        	LanguageRegistry.addName(Stack, names[Stack.getItemDamage()]);
        }
    	
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
    
    public void registerRecipes()
    {
    	GameRegistry.addShapedRecipe(new ItemStack(JAOUM.bBCrafting, 2, 0), "GOG", "OLO", "GOG", 'G', new ItemStack(Block.glass), 'O', new ItemStack(Block.obsidian), 'L', new ItemStack(Block.lever));
    	GameRegistry.addShapedRecipe(new ItemStack(JAOUM.bBCrafting, 1, 1), "RGB", "WPW", "RGB", 'R', new ItemStack(Item.dyePowder, 1, 1), 'G', new ItemStack(Item.dyePowder, 1, 2), 'B', new ItemStack(Item.dyePowder, 1, 4), 'W', new ItemStack(Block.cloth), 'P', new ItemStack(JAOUM.bBCrafting, 1, 2));
    	GameRegistry.addShapedRecipe(new ItemStack(JAOUM.bBCrafting, 1, 2), " R ", "RER", " R ", 'R', new ItemStack(Item.redstone), 'E', new ItemStack(Item.enderPearl));
    	GameRegistry.addShapedRecipe(new ItemStack(JAOUM.buildingBlock,32), "HHH", "HMH", "HHH", 'H', new ItemStack(JAOUM.bBCrafting, 1, 0), 'M', new ItemStack(JAOUM.bBCrafting, 1, 1));
    	GameRegistry.addShapedRecipe(new ItemStack(JAOUM.bBSwitch,  1,  0), "P", "S", "B", 'P', new ItemStack(JAOUM.bBCrafting , 1, 2), 'S', new ItemStack(Item.stick), 'B', new ItemStack(Block.stoneButton));
    }
}
