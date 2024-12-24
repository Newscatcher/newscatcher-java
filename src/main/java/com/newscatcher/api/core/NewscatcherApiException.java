/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.core;

/**
 * This class serves as the base exception for all errors in the SDK.
 */
public class NewscatcherApiException extends RuntimeException {
    public NewscatcherApiException(String message) {
        super(message);
    }

    public NewscatcherApiException(String message, Exception e) {
        super(message, e);
    }
}
