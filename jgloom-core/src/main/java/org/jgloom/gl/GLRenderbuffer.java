package org.jgloom.gl;

/**
 * Renderbuffer Objects are OpenGL Objects that contain images. They are created and used specifically with Framebuffer
 * Objects. They are optimized for enable as render targets, while Textures may not be, and are the logical choice when you
 * do not need to sample (i.e. in a post-pass shader) from the produced image. If you need to resample (such as when
 * reading depth back in a second shader pass), enable Textures instead. Renderbuffer objects also natively accommodate
 * Multisampling (MSAA).
 * @see <a href="https://www.opengl.org/wiki/Renderbuffer_Object">opengl.org - framebuffer object</a>
 */
@FunctionalInterface
public interface GLRenderbuffer {
    /** @return The identifier for the renderbuffer */
    int getRenderBuffer();
}
