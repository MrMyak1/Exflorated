package com.myak.exflorated.registries;

import com.mojang.blaze3d.vertex.PoseStack;
import com.myak.exflorated.Exflorated;
import com.myak.exflorated.fluid.CitronJuiceFluid;
import com.myak.exflorated.fluid.CitronJuiceType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Exflorated.MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Exflorated.MODID);

    public static final DeferredHolder<FluidType, FluidType> CITRON_JUICE_TYPE = FLUID_TYPES.register("citron_juice_type", CitronJuiceType::new);
    public static final DeferredHolder<Fluid, CitronJuiceFluid> CITRON_JUICE_SOURCE = FLUIDS.register("citron_juice_source",CitronJuiceFluid.Source::new);
    public static final DeferredHolder<Fluid, CitronJuiceFluid> CITRON_JUICE_FLOWING = FLUIDS.register("citron_juice_flowing",CitronJuiceFluid.Flowing::new);


    @OnlyIn(Dist.CLIENT)
    public static void registerFluidRendering(RegisterClientExtensionsEvent extensionsEvent) {

        extensionsEvent.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Exflorated.MODID, "block/citron_juice_still");
            }

            @Override
            public int getTintColor() {
                return 0xFFffd700;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Exflorated.MODID, "block/citron_juice_flowing");
            }

            @Override
            public @NotNull ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return ResourceLocation.fromNamespaceAndPath(Exflorated.MODID, "misc/citron_juice_overlay");
            }

            @Override
            public void renderOverlay(Minecraft mc, PoseStack poseStack) {
                ResourceLocation texture = this.getRenderOverlayTexture(mc);
                ScreenEffectRenderer.renderFluid(mc, poseStack, texture);
            }

        }, CITRON_JUICE_TYPE);
    }
    public static void registerFluidLayerRendering(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(CITRON_JUICE_SOURCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CITRON_JUICE_FLOWING.get(), RenderType.translucent());
    }
}
