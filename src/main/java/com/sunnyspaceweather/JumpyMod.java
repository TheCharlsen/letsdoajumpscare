package com.sunnyspaceweather;

import com.sunnyspaceweather.config.JConfig;
import net.fabricmc.api.ModInitializer;

public class JumpyMod implements ModInitializer {

	public static String MODID = "letsdoajumpscare";
	public static final JConfig CONFIG = JConfig.createAndLoad();
	@Override
	public void onInitialize() {
		JSoundEvents.init();
	}
}