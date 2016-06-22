package jgloom.io.resources;

import java.io.IOException;

/**
 * Signifies that a {@link Resource} is invalid, usually because its corresponding file does not exist
 */
public class InvalidResourceException extends IOException {
    private static final long serialVersionUID = 1L;
    
    public InvalidResourceException(String desc) {
        super(desc);
    }
}
