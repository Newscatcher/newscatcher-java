/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.resources.latestheadlines.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.newscatcher.api.core.ObjectMappers;
import com.newscatcher.api.types.ClusteringSearchResponse;
import com.newscatcher.api.types.LatestHeadlinesResponse;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = LatestHeadlinesPostResponse.Deserializer.class)
public final class LatestHeadlinesPostResponse {
    private final Object value;

    private final int type;

    private LatestHeadlinesPostResponse(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((ClusteringSearchResponse) this.value);
        } else if (this.type == 1) {
            return visitor.visit((LatestHeadlinesResponse) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LatestHeadlinesPostResponse && equalTo((LatestHeadlinesPostResponse) other);
    }

    private boolean equalTo(LatestHeadlinesPostResponse other) {
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

    public static LatestHeadlinesPostResponse of(ClusteringSearchResponse value) {
        return new LatestHeadlinesPostResponse(value, 0);
    }

    public static LatestHeadlinesPostResponse of(LatestHeadlinesResponse value) {
        return new LatestHeadlinesPostResponse(value, 1);
    }

    public interface Visitor<T> {
        T visit(ClusteringSearchResponse value);

        T visit(LatestHeadlinesResponse value);
    }

    static final class Deserializer extends StdDeserializer<LatestHeadlinesPostResponse> {
        Deserializer() {
            super(LatestHeadlinesPostResponse.class);
        }

        @java.lang.Override
        public LatestHeadlinesPostResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, ClusteringSearchResponse.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, LatestHeadlinesResponse.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
