package com.sunnyspaceweather;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.sunnyspaceweather.config.JConfig;
import com.sunnyspaceweather.config.JConfigModel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class TextureLoader {

    static MinecraftClient client = MinecraftClient.getInstance();
    public static int durationOfRender;
    static int timing = 1;
    static int mood;
    static boolean isActive = false;
    public static Identifier TEXTURE;

    static int activationChance;

    public static void tick() {
        if (timing > 0) {
            timing++;
        }
    }

    static PositionedSoundInstance SOUND_INSTANCE = PositionedSoundInstance.master(SoundEvents.BLOCK_NETHER_ORE_STEP, 1.0F);

    static Random random = new Random();
    static int texture_chance;

    public static void init() {
        if (JumpyMod.CONFIG.michelleDenkerMode()) {
            texture_chance = 2;
        }
        else if (JumpyMod.CONFIG.shouldCCValue() == true) {
            texture_chance = JumpyMod.CONFIG.texture_chance();
        }
        else {
            texture_chance = random.nextInt(6);
        }

        mood = Math.round(client.player.getMoodPercentage() * 100F);

        if (timing <= 0) {
            timing = durationOfRender;
        }

        if (mood == 0 && JumpyMod.CONFIG.alwaysActive() == false) {
            isActive = false;
        }
        else {
            isActive = true;
        }
        if (mood >= 1 && mood < 10) {
            activationChance = random.nextInt(50);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 10 && mood <= 20) {
            activationChance = random.nextInt(45);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 20 && mood <= 35) {
            activationChance = random.nextInt(40);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 35 && mood <= 57) {
            activationChance = random.nextInt(31);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 57 && mood <= 79) {
            activationChance = random.nextInt(26);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 79 && mood <= 87) {
            activationChance = random.nextInt(20);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 87 && mood <= 92) {
            activationChance = random.nextInt(11);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 92 && mood <= 97) {
            activationChance = random.nextInt(6);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        else if (mood > 97 && mood <= 100) {
            activationChance = random.nextInt(3);
            if (activationChance == 0) {
                isActive = true;
            }
            else {
                isActive = false;
            }
        }
        if (JumpyMod.CONFIG.alwaysActive()) {
            isActive = true;
        }

        if (isActive) {
            MinecraftClient.getInstance().getSoundManager().stopAll();
            if(texture_chance == 0) {
                //mc1
                durationOfRender = 23;
                SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.MC_1, 1.0F, 3.0F);
            }
            else if(texture_chance == 1) {
                //cc2
                durationOfRender = 41;
                SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_2, 1.0F, 3.0F);
            }
            else if(texture_chance == 2) {
                //cc1michelledenker
                durationOfRender = 660;
                SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_1, 1.0F, 2.0F);
            }
            else if(texture_chance == 3) {
                //cc3
                durationOfRender = 17;
                SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_3, 1.0F, 3.0F);
            }
            else if(texture_chance == 4) {
                //cc4
                durationOfRender = 41;
                SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_4, 1.0F, 3.0F);
            }
            else if(texture_chance == 5) {
                //cc4
                durationOfRender = 160;
                SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_5, 1.0F, 3.0F);
            }
            MinecraftClient.getInstance().getSoundManager().play(SOUND_INSTANCE);
        }
    }

    public static void resetTimer(int keyCode, int scanCode) {
        if ((client.options.inventoryKey.matchesKey(keyCode, scanCode))) {
            timing = 1;
            durationOfRender = 0;
        }
        else {
            timing = 1;
            durationOfRender = 0;
        }
    }

    public static void render(Screen screen, DrawContext context) {
        if(texture_chance == 0) {
            //mc1
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/mc_1/frame_" + timing + ".png");
        }
        else if(texture_chance == 1) {
            //cc2
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/cc_2/frame_" + timing + ".png");
        }
        else if(texture_chance == 2) {
            //cc1
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/cc_1.png");
        }
        else if(texture_chance == 3) {
            //cc3
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/cc_3/frame_" + timing + ".png");
        }
        else if(texture_chance == 4) {
            //cc4
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/cc_4/frame_" + timing + ".png");
        }
        else if(texture_chance == 5) {
            //cc4
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/cc_5/frame_" + timing + ".png");
        }

        double aspectRatio = (double) client.getWindow().getScaledWidth() / client.getWindow().getScaledHeight();

        int w = (int) (aspectRatio * screen.height);
        if (isActive) {
            if (durationOfRender > timing) {
                MinecraftClient.getInstance().getTextureManager().bindTexture(TEXTURE);
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
                context.drawTexture(TEXTURE, screen.width / 2 - w / 2, 0, 1000, 0.0F, 0.0F, w, screen.height, w, screen.height);
                RenderSystem.disableBlend();
            }
        }
    }
}
