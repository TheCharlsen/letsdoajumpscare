package com.sunnyspaceweather.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.SectionHeader;

@Modmenu(modId = "letsdoajumpscare")
@Config(name = "jconfiguration", wrapperName = "JConfig")
public class JConfigModel {

    @SectionHeader("General")
    public boolean alwaysActive = false;
    public boolean michelleDenkerMode = false;

    @SectionHeader("Dev")
    public boolean shouldCCValue = false;
    public int texture_chance;

}
