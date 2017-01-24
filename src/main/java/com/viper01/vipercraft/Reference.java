package com.viper01.vipercraft;

public class Reference {

	public static final String MOD_ID = "v01_vipercraft";
	public static final String NAME = "Viper01's ViperCraft Mod";
	//Version == MCVersion - MajorUpdate . MajorAPI . MinorUpdate . BugFix
	public static final String VERSION = "1.10.2-1.0.2.0";
	public static final String ACCEPTED_VERSIONS = "[1.10.2]";
	
	public static final String CLIENT_PROXY_CLASS = "com.viper01.vipercraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.viper01.vipercraft.proxy.ServerProxy";

	
	// Constructor for ITEMS, variable 1 is from ModItems, variable 2 is item package name
    public static enum VCItems {
    	
    	// Start your item constructors here, use commas after each line with a semi-colon after the last entry.
    	CHEESE("cheese", "ItemCheese"),
    	CRACKER("cracker", "ItemCracker"),
    	CHEESEANDCRACKER("cheeseandcracker", "ItemCheeseAndCracker"),
    	VELOREANDUST("veloreandust", "ItemVeloreanDust"),
    	VELOREANINGOT("veloreaningot", "ItemVeloreanIngot"),
    	ROCKHAMMER("rockhammer", "ItemRockHammer"),
    	FIRSTAIDKIT("firstaidkit", "ItemFirstAidKit"),
    	
    	ITEMTOOLNETHERAXE("nether_axe", "ItemToolNetherAxe"),
    	ITEMTOOLNETHERPICKAXE("nether_pickaxe", "ItemToolNetherPickaxe"),
    	ITEMTOOLNETHERHOE("nether_hoe", "ItemToolNetherHoe"),
    	ITEMTOOLNETHERSHOVEL("nether_shovel", "ItemToolNetherShovel"),
    	ITEMTOOLNETHERSWORD("nether_sword", "ItemToolNetherSword");
    	
    	
    	private String unlocalizedName;
    	private String registryName;
    	
    	VCItems(String unlocalizedName, String registryName) {
    		this.unlocalizedName = unlocalizedName;
    		this.registryName = registryName;
    	}
    
    	// Getters for getting names
    	
    	public String getUnlocalizedName() {
			return unlocalizedName;
		}
    	
        public String getRegistryName() {
		    return registryName;
	    }
    }

	// Constructor for BLOCKS, variable 1 is from ModBlocks, variable 2 is block package name
    public static enum VCBlocks {
    	
    	// Start your block constructors here, use commas after each line with a semi-colon after the last entry.
    	CHEESE("cheese", "BlockCheese"),
    	JAR("jar", "BlockJar"),
    	COOKIEJAR("cookiejar", "BlockCookieJar"),
    	DAIRYCHURN("dairychurn", "BlockDairyChurn"),
    	VELOREANORE("veloreanore", "BlockVeloreanOre");
    	
    	private String unlocalizedName;
    	private String registryName;
    	
    	VCBlocks(String unlocalizedName, String registryName) {
    		this.unlocalizedName = unlocalizedName;
    		this.registryName = registryName;
    	}
    
    	// Getters for getting names
    	
    	public String getUnlocalizedName() {
			return unlocalizedName;
		}
    	
        public String getRegistryName() {
		    return registryName;
	    }
    }
}
