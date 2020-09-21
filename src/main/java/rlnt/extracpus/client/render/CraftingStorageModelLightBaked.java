package rlnt.extracpus.client.render;

import appeng.block.crafting.BlockCraftingUnit;
import appeng.client.render.cablebus.CubeBuilder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;

class CraftingStorageModelLightBaked extends CraftingStorageModelBaked {

    private final TextureAtlasSprite baseTexture;
    private final TextureAtlasSprite lightTexture;

    CraftingStorageModelLightBaked(VertexFormat format, TextureAtlasSprite ringCorner, TextureAtlasSprite ringHor, TextureAtlasSprite ringVer, TextureAtlasSprite baseTexture, TextureAtlasSprite lightTexture) {
        super(format, ringCorner, ringHor, ringVer);
        this.baseTexture = baseTexture;
        this.lightTexture = lightTexture;
    }

    @Override
    protected void addInnerCube(EnumFacing facing, IBlockState state, CubeBuilder builder, float x1, float y1, float z1, float x2, float y2, float z2) {
        builder.setTexture(this.baseTexture);
        builder.addCube(x1, y1, z1, x2, y2, z2);

        boolean powered = state.getValue(BlockCraftingUnit.POWERED);
        builder.setRenderFullBright(powered);
        builder.setTexture(this.lightTexture);
        builder.addCube(x1, y1, z1, x2, y2, z2);
    }
}
