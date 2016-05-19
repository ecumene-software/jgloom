package jgloom.common.gl.glsl;

import jgloom.gl.glsl.GLSLShader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import jgloom.gl.glsl.GLSLProgram;

/**
 * Handles operations such as creating and setting the currently used
 * {@link GLSLProgram}
 */
public class GLSLPrograms {

	/**
	 * @return The currently bound shader program set by {@link GLSLProgramContainer#use()}
     */
	public static synchronized GLSLProgram getCurrentProgram(){
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
	 * @return
	 */
	public static synchronized GLSLProgram createProgram() {
		final int program = GL20.glCreateProgram();
		return new GLSLProgram() {
			@Override
			public int getGLSLProgram() {
				return program;
			}
		};
	}

}
