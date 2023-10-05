package com.sunnyspaceweather;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.BiomeEffectSoundPlayer;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.ClientPlayerTickable;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Random;

public class TextureLoader {

    static MinecraftClient client = MinecraftClient.getInstance();

    public static int durationOfRender;

    static int timing = 1;

    public static Identifier TEXTURE;

    public static void tick() {
        if (timing > 0) {
            timing++;
        }

        //System.out.println(Math.round(client.player.getMoodPercentage() * 100F));
    }

    static PositionedSoundInstance SOUND_INSTANCE = PositionedSoundInstance.master(SoundEvents.BLOCK_NETHER_ORE_STEP, 1.0F);

    //static int texture_chance = 2;

    static Random random = new Random();
    static int texture_chance;

    public static void init() {
        texture_chance = random.nextInt(4);
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
            //cc1
            durationOfRender = 660;
            SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_1, 1.0F, 2.0F);
        }
        else if(texture_chance == 3) {
            //cc3
            durationOfRender = 17;
            SOUND_INSTANCE = PositionedSoundInstance.master(JSoundEvents.CC_3, 1.0F, 3.0F);
        }
        if (timing <= 0) {
            timing = durationOfRender;
        }
    }

    public static void resetTimer(int keyCode, int scanCode) {
        if ((client.options.inventoryKey.matchesKey(keyCode, scanCode))) {
            timing = 1;
        }
        else {
            timing = 1;
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
            TEXTURE = new Identifier(JumpyMod.MODID, "textures/jumpscares/cc_3/frame_" + timing + ".png");
        }

        double aspectRatio = (double) client.getWindow().getScaledWidth() / client.getWindow().getScaledHeight();

        int w = (int) (aspectRatio * screen.height);
        if (durationOfRender > timing) {
            MinecraftClient.getInstance().getTextureManager().bindTexture(TEXTURE);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
            context.drawTexture(TEXTURE, screen.width / 2 - w / 2, 0, 1000, 0.0F, 0.0F, w, screen.height, w, screen.height);
            RenderSystem.disableBlend();
        }
    }
    public static PositionedSoundInstance getSoundInstance() {
        return SOUND_INSTANCE;
    }
}
