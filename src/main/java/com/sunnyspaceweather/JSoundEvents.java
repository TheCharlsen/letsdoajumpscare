package com.sunnyspaceweather;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class JSoundEvents {

    public static final SoundEvent MC_1 = SoundEvent.of(new Identifier("letsdoajumpscare", "mc.1"));
    public static final SoundEvent CC_1 = SoundEvent.of(new Identifier("letsdoajumpscare", "cc.1"));
    public static final SoundEvent CC_2 = SoundEvent.of(new Identifier("letsdoajumpscare", "cc.2"));
    public static final SoundEvent CC_3 = SoundEvent.of(new Identifier("letsdoajumpscare", "cc.3"));
    public static final SoundEvent CC_4 = SoundEvent.of(new Identifier("letsdoajumpscare", "cc.4"));
    public static final SoundEvent CC_5 = SoundEvent.of(new Identifier("letsdoajumpscare", "cc.5"));
    public static void init() {

        Registry.register(Registries.SOUND_EVENT, new Identifier("letsdoajumpscare", "mc.1"), MC_1);
        Registry.register(Registries.SOUND_EVENT, new Identifier("letsdoajumpscare", "cc.1"), CC_1);
        Registry.register(Registries.SOUND_EVENT, new Identifier("letsdoajumpscare", "cc.2"), CC_2);
        Registry.register(Registries.SOUND_EVENT, new Identifier("letsdoajumpscare", "cc.3"), CC_3);
        Registry.register(Registries.SOUND_EVENT, new Identifier("letsdoajumpscare", "cc.4"), CC_4);
        Registry.register(Registries.SOUND_EVENT, new Identifier("letsdoajumpscare", "cc.5"), CC_5);

    }
}
