/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.resources.authors.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.newscatcher.api.core.ObjectMappers;
import com.newscatcher.api.types.FailedSearchResponse;
import com.newscatcher.api.types.SearchResponse;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = AuthorsPostResponse.Deserializer.class)
public final class AuthorsPostResponse {
    private final Object value;

    private final int type;

    private AuthorsPostResponse(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((SearchResponse) this.value);
        } else if (this.type == 1) {
            return visitor.visit((FailedSearchResponse) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AuthorsPostResponse && equalTo((AuthorsPostResponse) other);
    }

    private boolean equalTo(AuthorsPostResponse other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static AuthorsPostResponse of(SearchResponse value) {
        return new AuthorsPostResponse(value, 0);
    }

    public static AuthorsPostResponse of(FailedSearchResponse value) {
        return new AuthorsPostResponse(value, 1);
    }

    public interface Visitor<T> {
        T visit(SearchResponse value);

        T visit(FailedSearchResponse value);
    }

    static final class Deserializer extends StdDeserializer<AuthorsPostResponse> {
        Deserializer() {
            super(AuthorsPostResponse.class);
        }

        @java.lang.Override
        public AuthorsPostResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, SearchResponse.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, FailedSearchResponse.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}