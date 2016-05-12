package joogl.glfw;

import joogl.GLNativeException;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL11;

import java.nio.ByteBuffer;

//TODO: Some of these don't have OGL checks
//TODO: Some of the docs reference "glfw***" methods

/**
 * Represents a pair of functions, managing windows and managing the context. This class contains methods for creating
 * {@link GLFWWindow}s and GLFW contexts.
 * @see <a href="http://www.glfw.org/docs/latest/context.html">The GLFW guide on contexts</a>
 */
public class GLFWWindows {
    /**
     * This function sets the error callback, which is called with an error code and a human-readable description each
     * time a GLFW error occurs.
     * The error callback is called on the thread where the error occurred. If you are using GLFW from multiple threads,
     * your error callback needs to be written accordingly.
     * @param callback The new callback, or NULL to remove the currently set callback
     * @return The previously set callback, or NULL if no callback was set.
     */
    public static synchronized GLFWErrorCallback setErrorCallback(GLFWErrorCallback callback){
        return GLFW.glfwSetErrorCallback(callback);
    }

    /**
     * This function makes the OpenGL or OpenGL ES context of the specified window current on the calling thread. A
     * context can only be made current on a single thread at a time and each thread can have only a single current
     * context at a time.
     * @param window
     * @throws GLNativeException
     */
    public static synchronized void makeContextCurrent(GLFWWindow window) throws GLNativeException {
        GLFW.glfwMakeContextCurrent(window.getGLFWWindow());
        GLNativeException.checkOGL();
    }

    public static synchronized GLFWWindow getCurrentContext() throws GLNativeException {
        return GLFW::glfwGetCurrentContext; // Damn that's some fly code
    }

    /**
     * This function initializes the GLFW library. Before most GLFW functions can be used, GLFW must be initialized,
     * and before an application terminates GLFW should be terminated in order to free any resources allocated during or
     * after initialization.
     * <b>May only be called from the main thread.</b>
     * {@link GLFWWindows#terminate()} can be called before {@link GLFWWindows#init()}
     * @return true if successful false if not
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized boolean init() throws GLNativeException {
        boolean init = GLFW.glfwInit() == GL11.GL_TRUE;
        GLNativeException.checkOGL();
        return init;
    }

    /**
     * This function destroys all remaining windows and cursors, restores any modified gamma ramps and frees any other
     * allocated resources. Once this function is called, you must again call glfwInit successfully before you will be
     * able to use most GLFW functions.
     * <b>May only be called from the main thread.</b>
     * {@link GLFWWindows#terminate()} can be called before {@link GLFWWindows#init()}
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized void terminate() throws GLNativeException {
        GLFW.glfwTerminate();
        GLNativeException.checkOGL();
    }

    /**
     * This function retrieves the major, minor and revision numbers of the GLFW library. It is intended for when you
     * are using GLFW as a shared library and want to ensure that you are using the minimum required version.
     * <b>This function may be called from any thread, synchronized</b>
     * This function may be called before {@link GLFW#glfwInit()}.
     * {@link GLFWWindows#getVersion()} can be called before {@link GLFWWindows#init()}
     * @return  the major, minor and revision numbers of the GLFW library. It is intended for when you are using GLFW
     *          as a shared library and want to ensure that you are using the minimum required version
     */
    public static synchronized GLFWVersion getVersion(){
        // Ugly... But it works!
        ByteBuffer major = BufferUtils.createByteBuffer(4);
        ByteBuffer minor = BufferUtils.createByteBuffer(4);
        ByteBuffer patch = BufferUtils.createByteBuffer(4);
        GLFW.glfwGetVersion(major, minor, patch);
        GLNativeException.checkOGL();

        return new GLFWVersion() {
            @Override
            public int getMajorVersion() {
                return major.getInt(0);
            }

            @Override
            public int getMinorVersion() {
                return minor.getInt(0);
            }

            @Override
            public int getPatchVersion() {
                return patch.getInt(0);
            }
        };
    }

    /**
     * This function returns the compile-time generated version string of the GLFW library binary. It describes the
     * version, platform, compiler and any platform-specific compile-time options.
     * {@link GLFWWindows#getVersionString()} can be called before {@link GLFWWindows#init()}
     * @return The GLFW version string.
     */
    public static synchronized String getVersionString(){
        return GLFW.glfwGetVersionString();
    }

    /**
     * This function creates a window and its associated OpenGL or OpenGL ES context. Most of the options controlling
     * how the window and its context should be created are specified with window hints.
     * <b>May only be called from the main thread.</b>
     * @param width   The desired width, in screen coordinates, of the window. This must be greater than zero.
     * @param height  The desired height, in screen coordinates, of the window. This must be greater than zero.
     * @param title   The initial, UTF-8 encoded window title.
     * @param monitor The monitor to use for full screen mode, or NULL to use windowed mode.
     * @param share   The window whose context to share resources with, or NULL to not share resources.
     * @return The handle of the created window, or NULL if an error occurred.
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized GLFWWindow createWindow(int width, int height, String title, long monitor, long share) throws GLNativeException {
        return () -> GLFW.glfwCreateWindow(width, height, title, monitor, share);
    }

    /**
     * This function sets hints for the next call to glfwCreateWindow. The hints, once set, retain their values until
     * changed by a call to glfwWindowHint or glfwDefaultWindowHints, or until the library is terminated.
     * <b>May only be called from the main thread.</b>
     * @throws GLNativeException because API calls can return OpenGL errors
     * @param target The window hint to set
     * @param hint   The new value to set
     */
    public static synchronized void hint(int target, int hint) throws GLNativeException {
        GLFW.glfwWindowHint(target, hint);
    }

    /**
     * Resets all windows to their default values
     * http://www.glfw.org/docs/latest/window.html#window_hints_values
     * <b>May only be called from the main thread.</b>
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized void defaultWindowHints() throws GLNativeException {
        GLFW.glfwDefaultWindowHints();
    }

    /**
     * This function processes only those events that are already in the event queue and then returns immediately.
     * Processing events will cause the window and input callbacks associated with those events to be called
     * <b>May only be called from the main thread.</b>
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized void pollEvents() throws GLNativeException {
        GLFW.glfwPollEvents();
    }

    /**
     * This function posts an empty event from the current thread to the event queue, causing glfwWaitEvents to return.
     * <b>May only be called from the main thread.</b>
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized void postEmptyEvent() throws GLNativeException {
        GLFW.glfwPostEmptyEvent();
    }

    /**
     * This function puts the calling thread to sleep until at least one event is available in the event queue. Once
     * one or more events are available, it behaves exactly like glfwPollEvents, i.e. the events in the queue are
     * processed and the function then returns immediately. Processing events will cause the window and input callbacks
     * associated with those events to be called.
     * <b>May only be called from the main thread.</b>
     * @throws GLNativeException because API calls can return OpenGL errors
     */
    public static synchronized void waitEvents() throws GLNativeException {
        GLFW.glfwWaitEvents();
        GLNativeException.checkOGL();
    }

}
