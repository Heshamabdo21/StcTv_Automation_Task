
/*
 * Copyright (c) 2023.
 * Hesham Abd Elhamed Gharib
 */

package Utils;

public class BadConfigurationException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public BadConfigurationException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
