package org.jgloom.gl.functions.renderbuffer;

/**
 * Renderbuffer Objects are OpenGL Objects that contain images. They are created and used specifically with Framebuffer
 * Objects. They are optimized for enable as render targets, while Textures may not be, and are the logical choice when you
 * do not need to sample (i.e. in a post-pass shader) from the produced image. If you need to resample (such as when
 * reading depth back in a second shader pass), enable Textures instead. Renderbuffer objects also natively accommodate
 * Multisampling (MSAA).
 */
public interface GLFRenderbufferGetParameter extends GLFRenderbuffer {
    /**
     * @param pname The pname
     * @return the renderbuffer's parameter value
     */
    int getParameter(int pname);
}
