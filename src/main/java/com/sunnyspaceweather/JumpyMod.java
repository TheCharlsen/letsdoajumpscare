package com.sunnyspaceweather;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.logging.Logger;

public class JumpyMod implements ModInitializer {

	public static String MODID = "letsdoajumpscare";

	@Override
	public void onInitialize() {
		JSoundEvents.init();
	}
}