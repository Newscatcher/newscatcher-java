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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AggregationCountResponseDto.Builder.class)
public final class AggregationCountResponseDto implements IBaseSearchResponseDto {
    private final String status;

    private final int totalHits;

    private final int page;

    private final int totalPages;

    private final int pageSize;

    private final Optional<Aggregations> aggregations;

    private final Optional<Map<String, Object>> userInput;

    private final Map<String, Object> additionalProperties;

    private AggregationCountResponseDto(
            String status,
            int totalHits,
            int page,
            int totalPages,
            int pageSize,
            Optional<Aggregations> aggregations,
            Optional<Map<String, Object>> userInput,
            Map<String, Object> additionalProperties) {
        this.status = status;
        this.totalHits = totalHits;
        this.page = page;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.aggregations = aggregations;
        this.userInput = userInput;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The status of the response.
     */
    @JsonProperty("status")
    @java.lang.Override
    public String getStatus() {
        return status;
    }

    /**
     * @return The total number of articles matching the search criteria.
     */
    @JsonProperty("total_hits")
    @java.lang.Override
    public int getTotalHits() {
        return totalHits;
    }

    /**
     * @return The current page number of the results.
     */
    @JsonProperty("page")
    @java.lang.Override
    public int getPage() {
        return page;
    }

    /**
     * @return The total number of pages available for the given search criteria.
     */
    @JsonProperty("total_pages")
    @java.lang.Override
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @return The number of articles per page.
     */
    @JsonProperty("page_size")
    @java.lang.Override
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @return The aggregation results. Can be either a dictionary or a list of dictionaries.
     */
    @JsonProperty("aggregations")
    public Optional<Aggregations> getAggregations() {
        return aggregations;
    }

    @JsonProperty("user_input")
    public Optional<Map<String, Object>> getUserInput() {
        return userInput;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AggregationCountResponseDto && equalTo((AggregationCountResponseDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AggregationCountResponseDto other) {
        return status.equals(other.status)
                && totalHits == other.totalHits
                && page == other.page
                && totalPages == other.totalPages
                && pageSize == other.pageSize
                && aggregations.equals(other.aggregations)
                && userInput.equals(other.userInput);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.status,
                this.totalHits,
                this.page,
                this.totalPages,
                this.pageSize,
                this.aggregations,
                this.userInput);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        TotalHitsStage status(@NotNull String status);

        Builder from(AggregationCountResponseDto other);
    }

    public interface TotalHitsStage {
        PageStage totalHits(int totalHits);
    }

    public interface PageStage {
        TotalPagesStage page(int page);
    }

    public interface TotalPagesStage {
        PageSizeStage totalPages(int totalPages);
    }

    public interface PageSizeStage {
        _FinalStage pageSize(int pageSize);
    }

    public interface _FinalStage {
        AggregationCountResponseDto build();

        _FinalStage aggregations(Optional<Aggregations> aggregations);

        _FinalStage aggregations(Aggregations aggregations);

        _FinalStage userInput(Optional<Map<String, Object>> userInput);

        _FinalStage userInput(Map<String, Object> userInput);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements StatusStage, TotalHitsStage, PageStage, TotalPagesStage, PageSizeStage, _FinalStage {
        private String status;

        private int totalHits;

        private int page;

        private int totalPages;

        private int pageSize;

        private Optional<Map<String, Object>> userInput = Optional.empty();

        private Optional<Aggregations> aggregations = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(AggregationCountResponseDto other) {
            status(other.getStatus());
            totalHits(other.getTotalHits());
            page(other.getPage());
            totalPages(other.getTotalPages());
            pageSize(other.getPageSize());
            aggregations(other.getAggregations());
            userInput(other.getUserInput());
            return this;
        }

        /**
         * <p>The status of the response.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("status")
        public TotalHitsStage status(@NotNull String status) {
            this.status = Objects.requireNonNull(status, "status must not be null");
            return this;
        }

        /**
         * <p>The total number of articles matching the search criteria.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("total_hits")
        public PageStage totalHits(int totalHits) {
            this.totalHits = totalHits;
            return this;
        }

        /**
         * <p>The current page number of the results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("page")
        public TotalPagesStage page(int page) {
            this.page = page;
            return this;
        }

        /**
         * <p>The total number of pages available for the given search criteria.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("total_pages")
        public PageSizeStage totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        /**
         * <p>The number of articles per page.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("page_size")
        public _FinalStage pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        @java.lang.Override
        public _FinalStage userInput(Map<String, Object> userInput) {
            this.userInput = Optional.ofNullable(userInput);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "user_input", nulls = Nulls.SKIP)
        public _FinalStage userInput(Optional<Map<String, Object>> userInput) {
            this.userInput = userInput;
            return this;
        }

        /**
         * <p>The aggregation results. Can be either a dictionary or a list of dictionaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage aggregations(Aggregations aggregations) {
            this.aggregations = Optional.ofNullable(aggregations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "aggregations", nulls = Nulls.SKIP)
        public _FinalStage aggregations(Optional<Aggregations> aggregations) {
            this.aggregations = aggregations;
            return this;
        }

        @java.lang.Override
        public AggregationCountResponseDto build() {
            return new AggregationCountResponseDto(
                    status, totalHits, page, totalPages, pageSize, aggregations, userInput, additionalProperties);
        }
    }
}