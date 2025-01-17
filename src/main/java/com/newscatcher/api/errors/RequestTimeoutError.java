/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.errors;

import com.newscatcher.api.core.NewscatcherApiApiException;
import com.newscatcher.api.types.Error;

public final class RequestTimeoutError extends NewscatcherApiApiException {
    /**
     * The body of the response that triggered the exception.
     */
    private final Error body;

    public RequestTimeoutError(Error body) {
        super("RequestTimeoutError", 408, body);
        this.body = body;
    }

    /**
     * @return the body
     */
    @java.lang.Override
    public Error body() {
        return this.body;
    }
}
