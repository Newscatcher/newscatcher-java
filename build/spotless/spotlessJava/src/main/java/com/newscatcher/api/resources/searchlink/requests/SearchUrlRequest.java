/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.resources.searchlink.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newscatcher.api.core.ObjectMappers;
import com.newscatcher.api.resources.searchlink.types.SearchUrlRequestFrom;
import com.newscatcher.api.resources.searchlink.types.SearchUrlRequestTo;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SearchUrlRequest.Builder.class)
public final class SearchUrlRequest {
    private final Optional<Object> ids;

    private final Optional<Object> links;

    private final Optional<SearchUrlRequestFrom> from;

    private final Optional<SearchUrlRequestTo> to;

    private final Optional<Integer> page;

    private final Optional<Integer> pageSize;

    private final Map<String, Object> additionalProperties;

    private SearchUrlRequest(
            Optional<Object> ids,
            Optional<Object> links,
            Optional<SearchUrlRequestFrom> from,
            Optional<SearchUrlRequestTo> to,
            Optional<Integer> page,
            Optional<Integer> pageSize,
            Map<String, Object> additionalProperties) {
        this.ids = ids;
        this.links = links;
        this.from = from;
        this.to = to;
        this.page = page;
        this.pageSize = pageSize;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("ids")
    public Optional<Object> getIds() {
        return ids;
    }

    @JsonProperty("links")
    public Optional<Object> getLinks() {
        return links;
    }

    @JsonProperty("from_")
    public Optional<SearchUrlRequestFrom> getFrom() {
        return from;
    }

    @JsonProperty("to_")
    public Optional<SearchUrlRequestTo> getTo() {
        return to;
    }

    @JsonProperty("page")
    public Optional<Integer> getPage() {
        return page;
    }

    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchUrlRequest && equalTo((SearchUrlRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SearchUrlRequest other) {
        return ids.equals(other.ids)
                && links.equals(other.links)
                && from.equals(other.from)
                && to.equals(other.to)
                && page.equals(other.page)
                && pageSize.equals(other.pageSize);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.ids, this.links, this.from, this.to, this.page, this.pageSize);
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
        private Optional<Object> ids = Optional.empty();

        private Optional<Object> links = Optional.empty();

        private Optional<SearchUrlRequestFrom> from = Optional.empty();

        private Optional<SearchUrlRequestTo> to = Optional.empty();

        private Optional<Integer> page = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SearchUrlRequest other) {
            ids(other.getIds());
            links(other.getLinks());
            from(other.getFrom());
            to(other.getTo());
            page(other.getPage());
            pageSize(other.getPageSize());
            return this;
        }

        @JsonSetter(value = "ids", nulls = Nulls.SKIP)
        public Builder ids(Optional<Object> ids) {
            this.ids = ids;
            return this;
        }

        public Builder ids(Object ids) {
            this.ids = Optional.ofNullable(ids);
            return this;
        }

        @JsonSetter(value = "links", nulls = Nulls.SKIP)
        public Builder links(Optional<Object> links) {
            this.links = links;
            return this;
        }

        public Builder links(Object links) {
            this.links = Optional.ofNullable(links);
            return this;
        }

        @JsonSetter(value = "from_", nulls = Nulls.SKIP)
        public Builder from(Optional<SearchUrlRequestFrom> from) {
            this.from = from;
            return this;
        }

        public Builder from(SearchUrlRequestFrom from) {
            this.from = Optional.ofNullable(from);
            return this;
        }

        @JsonSetter(value = "to_", nulls = Nulls.SKIP)
        public Builder to(Optional<SearchUrlRequestTo> to) {
            this.to = to;
            return this;
        }

        public Builder to(SearchUrlRequestTo to) {
            this.to = Optional.ofNullable(to);
            return this;
        }

        @JsonSetter(value = "page", nulls = Nulls.SKIP)
        public Builder page(Optional<Integer> page) {
            this.page = page;
            return this;
        }

        public Builder page(Integer page) {
            this.page = Optional.ofNullable(page);
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        public SearchUrlRequest build() {
            return new SearchUrlRequest(ids, links, from, to, page, pageSize, additionalProperties);
        }
    }
}
