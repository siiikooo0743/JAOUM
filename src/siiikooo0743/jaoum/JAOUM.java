package siiikooo0743.jaoum;

import siiikooo0743.jaoum.block.BuildingBlock;
import siiikooo0743.jaoum.item.BBCrafting;
import siiikooo0743.jaoum.item.BBSwitch;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

//JAOUM - Just an other Utlitymod 
//Copyright (C) 2013 siiikooo0743
//This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
//This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
//You should have received a copy of the GNU General Public License along with this program; if not, see <http://www.gnu.org/licenses/>.

@Mod(modid = "JAOUM", name = "Just an other Utilitymod", version= "1.1.0")
@NetworkMod(clientSideRequired = true)
public class JAOUM 
{
	//Config values
	
	//Items
	public static Item bBSwitch; 
	public static Item bBCrafting;
	
	//Blocks
	public static Block buildingBlock;
	
	
	//Other stuff
	@Instance(value = "JAOUM")
	public static JAOUM instance;
	
	@SidedProxy(clientSide="siiikooo0743.jaoum.client.ClientProxy", serverSide = "siiikooo0743.jaoum.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Config
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
        int BuildingBlockID = config.get(Configuration.CATEGORY_BLOCK, "Building Block ID", 500).getInt();
        int BBSwitchID = config.get(Configuration.CATEGORY_ITEM, "Building Block Switch ID", 5000).getInt();
        int BBCraftID = config.get(Configuration.CATEGORY_ITEM, "Building Block Crafting", 5001).getInt();
        
		config.save();
        
		//Items
		bBSwitch = new BBSwitch(BBSwitchID).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("bBSwitch");
		bBCrafting = new BBCrafting(BBCraftID).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("bBCrafting");
		
		//Blocks
		buildingBlock = new BuildingBlock(BuildingBlockID).func_111022_d("jaoum:BuildingBlock").setUnlocalizedName("buldingBlock").setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		proxy.registerNames();
		proxy.registerBlocksAndItems();
		proxy.registerTileEntitys();
		proxy.registerRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
