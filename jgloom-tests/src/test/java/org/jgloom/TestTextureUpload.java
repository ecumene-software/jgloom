package org.jgloom;

import org.jgloom.concurrent.NonConcurrentTest;
import org.jgloom.concurrent.RunInThread;
import org.jgloom.lwjgl.gl.GLTextureContainer;
import org.jgloom.lwjgl.gl.LWJGLTextures;
import org.junit.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;

public class TestTextureUpload extends NonConcurrentTest {
    @Test
    @RunInThread
    public void testTextureUpload(){
        TestGLUtil.openContext();
        float[] texture = new float[]{
                0.1f, 0.5f, 0.5f,
                0.1f, 0.5f, 0.5f,
                0.1f, 0.5f, 0.5f,

                0.0f, 0.0f, 0.1f,
                0.0f, 0.0f, 0.1f,
                0.0f, 0.0f, 0.1f,

                0.0f, 0.1f, 0.0f,
                0.0f, 0.1f, 0.0f,
                0.0f, 0.1f, 0.0f,
        };

        FloatBuffer buffer = BufferUtils.createFloatBuffer(3*3*3);
        buffer.put(texture);
        buffer.flip();

        GLTextureContainer textureContainer = new GLTextureContainer(LWJGLTextures.createTexture());
        textureContainer.bind(GL11.GL_TEXTURE_2D);
        textureContainer.image2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, 3, 3, 0, GL11.GL_RGB, GL11.GL_FLOAT, buffer);
        textureContainer.setParameter(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        textureContainer.setParameter(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);

        textureContainer.delete();

        TestGLUtil.closeContext();
    }
}
