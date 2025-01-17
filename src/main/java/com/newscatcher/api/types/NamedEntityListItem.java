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
@JsonDeserialize(builder = NamedEntityListItem.Builder.class)
public final class NamedEntityListItem {
    private final Optional<String> entityName;

    private final Optional<Integer> count;

    private final Map<String, Object> additionalProperties;

    private NamedEntityListItem(
            Optional<String> entityName, Optional<Integer> count, Map<String, Object> additionalProperties) {
        this.entityName = entityName;
        this.count = count;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the entity identified in the article.
     */
    @JsonProperty("entity_name")
    public Optional<String> getEntityName() {
        return entityName;
    }

    /**
     * @return The number of times this entity appears in the article.
     */
    @JsonProperty("count")
    public Optional<Integer> getCount() {
        return count;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NamedEntityListItem && equalTo((NamedEntityListItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(NamedEntityListItem other) {
        return entityName.equals(other.entityName) && count.equals(other.count);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.entityName, this.count);
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
        private Optional<String> entityName = Optional.empty();

        private Optional<Integer> count = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(NamedEntityListItem other) {
            entityName(other.getEntityName());
            count(other.getCount());
            return this;
        }

        @JsonSetter(value = "entity_name", nulls = Nulls.SKIP)
        public Builder entityName(Optional<String> entityName) {
            this.entityName = entityName;
            return this;
        }

        public Builder entityName(String entityName) {
            this.entityName = Optional.ofNullable(entityName);
            return this;
        }

        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<Integer> count) {
            this.count = count;
            return this;
        }

        public Builder count(Integer count) {
            this.count = Optional.ofNullable(count);
            return this;
        }

        public NamedEntityListItem build() {
            return new NamedEntityListItem(entityName, count, additionalProperties);
        }
    }
}
