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
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = LatestHeadlinesRequestClusteringThreshold.Deserializer.class)
public final class LatestHeadlinesRequestClusteringThreshold {
    private final Object value;

    private final int type;

    private LatestHeadlinesRequestClusteringThreshold(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((double) this.value);
        } else if (this.type == 1) {
            return visitor.visit((String) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LatestHeadlinesRequestClusteringThreshold
                && equalTo((LatestHeadlinesRequestClusteringThreshold) other);
    }

    private boolean equalTo(LatestHeadlinesRequestClusteringThreshold other) {
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

    public static LatestHeadlinesRequestClusteringThreshold of(double value) {
        return new LatestHeadlinesRequestClusteringThreshold(value, 0);
    }

    public static LatestHeadlinesRequestClusteringThreshold of(String value) {
        return new LatestHeadlinesRequestClusteringThreshold(value, 1);
    }

    public interface Visitor<T> {
        T visit(double value);

        T visit(String value);
    }

    static final class Deserializer extends StdDeserializer<LatestHeadlinesRequestClusteringThreshold> {
        Deserializer() {
            super(LatestHeadlinesRequestClusteringThreshold.class);
        }

        @java.lang.Override
        public LatestHeadlinesRequestClusteringThreshold deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException {
            Object value = p.readValueAs(Object.class);
            if (value instanceof Double) {
                return of((Double) value);
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
