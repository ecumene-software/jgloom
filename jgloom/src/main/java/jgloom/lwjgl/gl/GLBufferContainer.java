package jgloom.lwjgl.gl;

import jgloom.gl.GLBuffer;
import org.lwjgl.opengl.*;

import java.nio.*;

/**
 * Buffer Objects are OpenGL Objects that store an array of unformatted memory allocated by the OpenGL context (aka: the
 * GPU). These can be used to store vertex data, pixel data retrieved from images or the framebuffer, and a variety of
 * other things.
 *
 * Use {@link GLBuffer} to create {@link jgloom.gl.GLBuffer} objects
 */

public class GLBufferContainer extends AbstractGLBuffer {

    /** @param buffer The buffer to track */
    public GLBufferContainer(GLBuffer buffer){
        super(buffer);
    }

    @Override
    public void bind(int target) {
        GL15.glBindBuffer(target, getBuffer());
    }

    @Override
    public void delete() {
        GL15.glDeleteBuffers(getBuffer());
    }

    @Override
    public void data(int target, long size, int usage) {
        GL15.glBufferData(target, size, usage);
    }

    @Override
    public void data(int target, ByteBuffer data, int usage) {
        GL15.glBufferData(target, data, usage);
    }

    @Override
    public void data(int target, ShortBuffer data, int usage) {
        GL15.glBufferData(target, data, usage);
    }

    @Override
    public void data(int target, IntBuffer data, int usage) {
        GL15.glBufferData(target, data, usage);
    }

    @Override
    public void data(int target, FloatBuffer data, int usage) {
        GL15.glBufferData(target, data, usage);
    }

    @Override
    public void data(int target, DoubleBuffer data, int usage) {
        GL15.glBufferData(target, data, usage);
    }

    @Override
    public void subData(int target, long offset, ByteBuffer data) {
        GL15.glBufferSubData(target, offset, data);
    }

    @Override
    public void subData(int target, long offset, ShortBuffer data) {
        GL15.glBufferSubData(target, offset, data);
    }

    @Override
    public void subData(int target, long offset, IntBuffer data) {
        GL15.glBufferSubData(target, offset, data);
    }

    @Override
    public void subData(int target, long offset, FloatBuffer data) {
        GL15.glBufferSubData(target, offset, data);
    }

    @Override
    public void subData(int target, long offset, DoubleBuffer data) {
        GL15.glBufferSubData(target, offset, data);
    }

    @Override
    public void getSubData(int target, long offset, ByteBuffer data) {
        GL15.glGetBufferSubData(target, offset, data);
    }

    @Override
    public void getSubData(int target, long offset, ShortBuffer data) {
        GL15.glGetBufferSubData(target, offset, data);
    }

    @Override
    public void getSubData(int target, long offset, IntBuffer data) {
        GL15.glGetBufferSubData(target, offset, data);
    }

    @Override
    public void getSubData(int target, long offset, FloatBuffer data) {
        GL15.glGetBufferSubData(target, offset, data);
    }

    @Override
    public void storage(int target, ByteBuffer data, int flags) {
        GL44.glBufferStorage(target, data, flags);
    }

    @Override
    public void storage(int target, ShortBuffer data, int flags) {
        GL44.glBufferStorage(target, data, flags);
    }

    @Override
    public void storage(int target, IntBuffer data, int flags) {
        GL44.glBufferStorage(target, data, flags);
    }

    @Override
    public void storage(int target, FloatBuffer data, int flags) {
        GL44.glBufferStorage(target, data, flags);
    }

    @Override
    public void storage(int target, DoubleBuffer data, int flags) {
        GL44.glBufferStorage(target, data, flags);
    }

    @Override
    public void storage(int target, long size, int flags) {
        GL44.glBufferStorage(target, size, flags);
    }

    @Override
    public void clear(int target, int internalformat, int format, int type, ByteBuffer data) {
        GL43.glClearBufferData(target, internalformat, format, type, data);
    }

    @Override
    public void clear(int target, int internalformat, int format, int type, ShortBuffer data) {
        GL43.glClearBufferData(target, internalformat, format, type, data);
    }

    @Override
    public void clear(int target, int internalformat, int format, int type, IntBuffer data) {
        GL43.glClearBufferData(target, internalformat, format, type, data);
    }

    @Override
    public void clear(int target, int internalformat, int format, int type, FloatBuffer data) {
        GL43.glClearBufferData(target, internalformat, format, type, data);
    }

    @Override
    public void subClear(int target, int internalformat, long offset, long size, int format, int type, ByteBuffer data) {
        GL43.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    @Override
    public void subClear(int target, int internalformat, long offset, long size, int format, int type, ShortBuffer data) {
        GL43.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    @Override
    public void subClear(int target, int internalformat, long offset, long size, int format, int type, IntBuffer data) {
        GL43.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    @Override
    public void subClear(int target, int internalformat, long offset, long size, int format, int type, FloatBuffer data) {
        GL43.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    @Override
    public void getSubData(int target, long offset, DoubleBuffer data) {
        GL15.glGetBufferSubData(target, offset, data);
    }

    @Override
    public void map(int target, int access) {
        GL15.glMapBuffer(target, access);
    }

    @Override
    public boolean unmap(int target) {
        return GL15.glUnmapBuffer(target);
    }

    @Override
    public void invalidate() {
        GL43.glInvalidateBufferData(getBuffer());
    }

    @Override
    public void invalidateRange(int offset, int size) {
        GL43.glInvalidateBufferSubData(getBuffer(), offset, size);
    }

    @Override
    public IntBuffer getParameters(int target, int pname) {
        IntBuffer out = null;
        GL15.glGetBufferParameteriv(target, pname, out);
        return out;
    }

    @Override
    public int getParameter(int target, int pname) {
        return GL15.glGetBufferParameteri(target, pname);
    }

}