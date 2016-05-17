package jgloom.gl;

import org.lwjgl.opengl.GL11;

/**
 * A texture is an OpenGL Object that contains one or more images that all have the same image format. A texture can be
 * used in two ways. It can be the source of a texture access from a Shader, or it can be used as a render target.
 */
public interface GLTexture {
    /** @return The texture's identifier */
    public int getTexture();

    /** The OpenGL texture object identifier */
    public static final int IDENTIFIER = GL11.GL_TEXTURE;
}