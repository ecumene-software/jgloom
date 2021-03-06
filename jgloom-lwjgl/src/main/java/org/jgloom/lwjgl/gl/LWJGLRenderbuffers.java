package org.jgloom.lwjgl.gl;

import org.jgloom.gl.GLRenderbuffer;
import org.lwjgl.opengl.GL30;

/**
 * Renderbuffer Objects are OpenGL Objects that contain images. They are created and used specifically with Framebuffer
 * Objects. They are optimized for enable as render targets, while Textures may not be, and are the logical choice when you
 * do not need to sample (i.e. in a post-pass shader) from the produced image. If you need to resample (such as when
 * reading depth back in a second shader pass), enable Textures instead. Renderbuffer objects also natively accommodate
 * Multisampling (MSAA).
 * @see <a href="https://www.opengl.org/wiki/Renderbuffer_Object">opengl.org - framebuffer object</a>
 */
public class LWJGLRenderbuffers {
    /** The OpenGL renderbuffer object identifier */
    public static int IDENTIFIER = GL30.GL_RENDERBUFFER;

    /** @return Renderbuffer object names */
    public static GLRenderbuffer createRenderBuffer() {
        int renderBuffer = GL30.glGenRenderbuffers();
        return () -> renderBuffer;
    }

    /**
     * @param rb
     * @return if an integer corresponds to an OpenGL renderbuffer object
     */
    public static boolean isRenderBuffer(int rb){
        return GL30.glIsRenderbuffer(rb);
    }
}
