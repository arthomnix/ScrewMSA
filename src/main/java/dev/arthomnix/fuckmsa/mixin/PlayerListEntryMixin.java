package dev.arthomnix.fuckmsa.mixin;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Mixin(PlayerListEntry.class)
public class PlayerListEntryMixin {
    private static final String FUCK_MICROSOFT =
            "iVBORw0KGgoAAAANSUhEUgAAAIAAAABACAYAAADS1n9/AAABhGlDQ1BJQ0MgcHJvZmlsZQAAKJF9" +
            "kT1Iw0AcxV9TS8VWHOwg4pChCoIFURFHrUIRKoRaoVUHk0u/oElDkuLiKLgWHPxYrDq4OOvq4CoI" +
            "gh8gjk5Oii5S4v+aQosYD4778e7e4+4dINTLTLO6xgFNt81UIi5msqti8BUCAghhFCGZWcacJCXh" +
            "Ob7u4ePrXYxneZ/7c/SqOYsBPpF4lhmmTbxBPL1pG5z3iSOsKKvE58RjJl2Q+JHristvnAtNFnhm" +
            "xEyn5okjxGKhg5UOZkVTI54ijqqaTvlCxmWV8xZnrVxlrXvyF4Zz+soy12kOIYFFLEGCCAVVlFCG" +
            "jRitOikWUrQf9/APNv0SuRRylcDIsYAKNMhNP/gf/O7Wyk9OuEnhOBB4cZyPYSC4CzRqjvN97DiN" +
            "E8D/DFzpbX+lDsx8kl5ra9EjoG8buLhua8oecLkDDDwZsik3JT9NIZ8H3s/om7JA/y3Qs+b21trH" +
            "6QOQpq6SN8DBITBSoOx1j3d3d/b275lWfz8eB3KFo0x97wAAAAZiS0dEAAAAAAAA+UO7fwAAAAlw" +
            "SFlzAAAuIwAALiMBeKU/dgAAAAd0SU1FB+YCBRMeOk36CikAAAAZdEVYdENvbW1lbnQAQ3JlYXRl" +
            "ZCB3aXRoIEdJTVBXgQ4XAAABm0lEQVR42u2b2w6DIBBEdw3//8v0oZpYwy2KDbt7zktbSdoiwzCL" +
            "qrKTc86yMKqqb3xvrd9v/d5qbAKh0dVn/tsz89r/KDMfBwAREUnhLfAy4586ojUHwQGCs1VULIeQ" +
            "S6+1Nvg6iKVctTU6InfawEkIHJ3VqupKELoTxQnS01mec3YngtFJ4aHP6U7Howx4hOUv9Tp57XCp" +
            "jUzgMANA3Q09VT2pF/zOa/zRfn5f+8wSYNQBerY+ujyAjWrg0RIQOQyGzQAt6/e+I+hR7OEvB7es" +
            "2+L/pgqAZ/sApTQ/cixKFeBeALUBvA5yqSKIuiVsOSd0LwffPREByrufktmq8LdWx1ZMxf+qq2dd" +
            "FVx9PyCNzmpu+giSAWrr/91jYDADwPjS19oaRwCAAAABhMDqHdKJoZsz8CURWMgEOMDEUGhxYwgB" +
            "kAGgY/Hq+YlhBBCcZE3dme1GHGD1EtDSreMIYEIFUKoCcABAAFQDCABWrwI4BXMCYCkM4gCBQyBb" +
            "wcGygNVH5REAAAAAAAAAAAAAAAAAAAAAAAAAAIADPk1tFEiqI5DaAAAAAElFTkSuQmCC";

    @Shadow @Final private Map<MinecraftProfileTexture.Type, Identifier> textures;

    @Inject(method = "loadTextures", at = @At("HEAD"))
    private void loadTextures(CallbackInfo ci) throws IOException {
        if (this.textures.containsKey(MinecraftProfileTexture.Type.CAPE)) {
            if (Objects.equals(this.textures.get(MinecraftProfileTexture.Type.CAPE).getPath(), "skins/17f76a23ff4d227a94ea3d5802dccae9f2ae9aa9")) {
                this.textures.replace(MinecraftProfileTexture.Type.CAPE,
                        MinecraftClient.getInstance().getTextureManager().registerDynamicTexture("fuck_microsoft",
                                new NativeImageBackedTexture(NativeImage.read(FUCK_MICROSOFT))
                        )
                );
            }
        }
    }
}
