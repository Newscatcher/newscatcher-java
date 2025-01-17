/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newscatcher.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SentimentScores.Builder.class)
public final class SentimentScores {
    private final Optional<Float> title;

    private final Optional<Float> content;

    private final Map<String, Object> additionalProperties;

    private SentimentScores(Optional<Float> title, Optional<Float> content, Map<String, Object> additionalProperties) {
        this.title = title;
        this.content = content;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The sentiment score for the article title (-1.0 to 1.0).
     */
    @JsonProperty("title")
    public Optional<Float> getTitle() {
        return title;
    }

    /**
     * @return The sentiment score for the article content (-1.0 to 1.0).
     */
    @JsonProperty("content")
    public Optional<Float> getContent() {
        return content;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SentimentScores && equalTo((SentimentScores) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SentimentScores other) {
        return title.equals(other.title) && content.equals(other.content);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.title, this.content);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Float> title = Optional.empty();

        private Optional<Float> content = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SentimentScores other) {
            title(other.getTitle());
            content(other.getContent());
            return this;
        }

        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public Builder title(Optional<Float> title) {
            this.title = title;
            return this;
        }

        public Builder title(Float title) {
            this.title = Optional.ofNullable(title);
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<Float> content) {
            this.content = content;
            return this;
        }

        public Builder content(Float content) {
            this.content = Optional.ofNullable(content);
            return this;
        }

        public SentimentScores build() {
            return new SentimentScores(title, content, additionalProperties);
        }
    }
}
