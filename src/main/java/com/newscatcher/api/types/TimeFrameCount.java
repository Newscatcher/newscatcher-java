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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newscatcher.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TimeFrameCount.Builder.class)
public final class TimeFrameCount {
    private final OffsetDateTime timeFrame;

    private final int articleCount;

    private final Map<String, Object> additionalProperties;

    private TimeFrameCount(OffsetDateTime timeFrame, int articleCount, Map<String, Object> additionalProperties) {
        this.timeFrame = timeFrame;
        this.articleCount = articleCount;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The timestamp for the aggregation period in format &quot;YYYY-MM-DD HH:mm:ss&quot;
     */
    @JsonProperty("time_frame")
    public OffsetDateTime getTimeFrame() {
        return timeFrame;
    }

    /**
     * @return The number of articles published during this time frame
     */
    @JsonProperty("article_count")
    public int getArticleCount() {
        return articleCount;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TimeFrameCount && equalTo((TimeFrameCount) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TimeFrameCount other) {
        return timeFrame.equals(other.timeFrame) && articleCount == other.articleCount;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.timeFrame, this.articleCount);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TimeFrameStage builder() {
        return new Builder();
    }

    public interface TimeFrameStage {
        ArticleCountStage timeFrame(@NotNull OffsetDateTime timeFrame);

        Builder from(TimeFrameCount other);
    }

    public interface ArticleCountStage {
        _FinalStage articleCount(int articleCount);
    }

    public interface _FinalStage {
        TimeFrameCount build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TimeFrameStage, ArticleCountStage, _FinalStage {
        private OffsetDateTime timeFrame;

        private int articleCount;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TimeFrameCount other) {
            timeFrame(other.getTimeFrame());
            articleCount(other.getArticleCount());
            return this;
        }

        /**
         * <p>The timestamp for the aggregation period in format &quot;YYYY-MM-DD HH:mm:ss&quot;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("time_frame")
        public ArticleCountStage timeFrame(@NotNull OffsetDateTime timeFrame) {
            this.timeFrame = Objects.requireNonNull(timeFrame, "timeFrame must not be null");
            return this;
        }

        /**
         * <p>The number of articles published during this time frame</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("article_count")
        public _FinalStage articleCount(int articleCount) {
            this.articleCount = articleCount;
            return this;
        }

        @java.lang.Override
        public TimeFrameCount build() {
            return new TimeFrameCount(timeFrame, articleCount, additionalProperties);
        }
    }
}
