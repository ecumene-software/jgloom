package jgloom.gl.glsl;

import jgloom.common.gl.glsl.GLSLProgramContainer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL43;

/**
 * A GLSL Object is an object in the OpenGL API that encapsulates the compiled or linked Shaders that execute portions
 * of the OpenGL Pipeline. These objects represent code written in the OpenGL Shading Language (GLSL). Though they are
 * called "objects", most of them do not fit within the OpenGL Object paradigm.
 * @see <a href=https://www.opengl.org/wiki/GLSL_Object>opengl.org - GLSL Objects</a>
 */
public interface GLSLProgram {
    /** @return The GLSL program identifier */
    public int getGLSLProgram();

    /** The OpenGL shader program object identifier */
    public static final int IDENTIFIER = GL43.GL_PROGRAM;

    /**
     * @return The currently bound shader program set by {@link GLSLProgramContainer#use()}
     */
    public static GLSLProgram getCurrentProgram(){
        return new GLSLProgram() {
            @Override
            public int getGLSLProgram() {
                return GL11.glGetInteger(GL20.GL_CURRENT_PROGRAM);
            }
        };
    }

    /**
     * Creates an empty GLSL program for attaching shaders to and using for
     * rendering
     * @return A generated GLSL program using glCreateProgram
     */
    public static GLSLProgram createProgram() {
        int program = GL20.glCreateProgram();
        return new GLSLProgram() {
            @Override
            public int getGLSLProgram() {
                return program;
            }
        };
    }

}
