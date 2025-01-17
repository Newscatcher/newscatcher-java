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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SourcesResponseDto.Builder.class)
public final class SourcesResponseDto {
    private final String message;

    private final List<SourcesResponseDtoSourcesItem> sources;

    private final Map<String, Object> userInput;

    private final Map<String, Object> additionalProperties;

    private SourcesResponseDto(
            String message,
            List<SourcesResponseDtoSourcesItem> sources,
            Map<String, Object> userInput,
            Map<String, Object> additionalProperties) {
        this.message = message;
        this.sources = sources;
        this.userInput = userInput;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A message indicating the result of the request.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @return A list of news sources that match the specified criteria.
     */
    @JsonProperty("sources")
    public List<SourcesResponseDtoSourcesItem> getSources() {
        return sources;
    }

    /**
     * @return The user input parameters for the request.
     */
    @JsonProperty("user_input")
    public Map<String, Object> getUserInput() {
        return userInput;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SourcesResponseDto && equalTo((SourcesResponseDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SourcesResponseDto other) {
        return message.equals(other.message) && sources.equals(other.sources) && userInput.equals(other.userInput);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.message, this.sources, this.userInput);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MessageStage builder() {
        return new Builder();
    }

    public interface MessageStage {
        _FinalStage message(@NotNull String message);

        Builder from(SourcesResponseDto other);
    }

    public interface _FinalStage {
        SourcesResponseDto build();

        _FinalStage sources(List<SourcesResponseDtoSourcesItem> sources);

        _FinalStage addSources(SourcesResponseDtoSourcesItem sources);

        _FinalStage addAllSources(List<SourcesResponseDtoSourcesItem> sources);

        _FinalStage userInput(Map<String, Object> userInput);

        _FinalStage putAllUserInput(Map<String, Object> userInput);

        _FinalStage userInput(String key, Object value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MessageStage, _FinalStage {
        private String message;

        private Map<String, Object> userInput = new LinkedHashMap<>();

        private List<SourcesResponseDtoSourcesItem> sources = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SourcesResponseDto other) {
            message(other.getMessage());
            sources(other.getSources());
            userInput(other.getUserInput());
            return this;
        }

        /**
         * <p>A message indicating the result of the request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("message")
        public _FinalStage message(@NotNull String message) {
            this.message = Objects.requireNonNull(message, "message must not be null");
            return this;
        }

        /**
         * <p>The user input parameters for the request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage userInput(String key, Object value) {
            this.userInput.put(key, value);
            return this;
        }

        /**
         * <p>The user input parameters for the request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage putAllUserInput(Map<String, Object> userInput) {
            this.userInput.putAll(userInput);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "user_input", nulls = Nulls.SKIP)
        public _FinalStage userInput(Map<String, Object> userInput) {
            this.userInput.clear();
            this.userInput.putAll(userInput);
            return this;
        }

        /**
         * <p>A list of news sources that match the specified criteria.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllSources(List<SourcesResponseDtoSourcesItem> sources) {
            this.sources.addAll(sources);
            return this;
        }

        /**
         * <p>A list of news sources that match the specified criteria.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addSources(SourcesResponseDtoSourcesItem sources) {
            this.sources.add(sources);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "sources", nulls = Nulls.SKIP)
        public _FinalStage sources(List<SourcesResponseDtoSourcesItem> sources) {
            this.sources.clear();
            this.sources.addAll(sources);
            return this;
        }

        @java.lang.Override
        public SourcesResponseDto build() {
            return new SourcesResponseDto(message, sources, userInput, additionalProperties);
        }
    }
}