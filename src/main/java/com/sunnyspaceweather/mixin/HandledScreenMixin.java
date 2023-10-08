package com.sunnyspaceweather.mixin;

import com.sunnyspaceweather.TextureLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin extends Screen {

    @Shadow
    public abstract void close();

    protected HandledScreenMixin(Text title) {
        super(title);
    }

    int timer;


    @Inject(method = "init", at = @At(value = "HEAD"))
    public void initEverythingThatsHere(CallbackInfo ci) {
        TextureLoader.init();
        timer = TextureLoader.durationOfRender;
    }

    public void tick() {
        TextureLoader.tick();
        if (timer > 0) {
            timer--;
        }
    }

    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
    private void disableTappingOut(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if (super.keyPressed(keyCode, scanCode, modifiers)) {
            cir.setReturnValue(true);
            TextureLoader.resetTimer(keyCode, scanCode);
            MinecraftClient.getInstance().getSoundManager().stopAll();
        }
        else if ((this.client.options.inventoryKey.matchesKey(keyCode, scanCode))) {
            if (timer > 0) {
                cir.setReturnValue(false);
            }
            else {
                this.close();
                MinecraftClient.getInstance().getSoundManager().stopAll();
                cir.setReturnValue(true);
                TextureLoader.resetTimer(keyCode, scanCode);
            }
        }
    }

    @Inject(method ="render", at = @At(value = "RETURN"))
    public void renderTextureOverEverything(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {

        TextureLoader.render(this, context);

    }
}
