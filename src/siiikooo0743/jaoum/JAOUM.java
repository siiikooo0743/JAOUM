package siiikooo0743.jaoum;

import siiikooo0743.jaoum.block.BuildingBlock;
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


@Mod(modid = "JAOUM", name = "Just an other Utilitymod", version= "1.0.0")
@NetworkMod(clientSideRequired = true)
public class JAOUM 
{
	//Config values
	int BuildingBlockID;
	int BBSwitchID;
	
	//Items
	public static Item bBSwitch; 
	
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
        BuildingBlockID = config.get(Configuration.CATEGORY_BLOCK, "Building Block ID", 500).getInt();
        BBSwitchID = config.get(Configuration.CATEGORY_ITEM, "Building Block Switch ID", 5000).getInt();
		config.save();
        
		
		
		//Items
		bBSwitch = new BBSwitch(BBSwitchID).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("bBSwitch");
		
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
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
