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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = NlpDataEntity.Builder.class)
public final class NlpDataEntity {
    private final Optional<String> theme;

    private final Optional<String> summary;

    private final Optional<SentimentScores> sentiment;

    private final Optional<List<Float>> newEmbedding;

    private final Optional<List<NamedEntityListItem>> nerPer;

    private final Optional<List<NamedEntityListItem>> nerOrg;

    private final Optional<List<NamedEntityListItem>> nerMisc;

    private final Optional<List<NamedEntityListItem>> nerLoc;

    private final Optional<List<String>> iptcTagsName;

    private final Optional<List<String>> iptcTagsId;

    private final Optional<List<String>> iabTagsName;

    private final Map<String, Object> additionalProperties;

    private NlpDataEntity(
            Optional<String> theme,
            Optional<String> summary,
            Optional<SentimentScores> sentiment,
            Optional<List<Float>> newEmbedding,
            Optional<List<NamedEntityListItem>> nerPer,
            Optional<List<NamedEntityListItem>> nerOrg,
            Optional<List<NamedEntityListItem>> nerMisc,
            Optional<List<NamedEntityListItem>> nerLoc,
            Optional<List<String>> iptcTagsName,
            Optional<List<String>> iptcTagsId,
            Optional<List<String>> iabTagsName,
            Map<String, Object> additionalProperties) {
        this.theme = theme;
        this.summary = summary;
        this.sentiment = sentiment;
        this.newEmbedding = newEmbedding;
        this.nerPer = nerPer;
        this.nerOrg = nerOrg;
        this.nerMisc = nerMisc;
        this.nerLoc = nerLoc;
        this.iptcTagsName = iptcTagsName;
        this.iptcTagsId = iptcTagsId;
        this.iabTagsName = iabTagsName;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The themes or categories identified in the article.
     */
    @JsonProperty("theme")
    public Optional<String> getTheme() {
        return theme;
    }

    /**
     * @return A brief AI-generated summary of the article content.
     */
    @JsonProperty("summary")
    public Optional<String> getSummary() {
        return summary;
    }

    @JsonProperty("sentiment")
    public Optional<SentimentScores> getSentiment() {
        return sentiment;
    }

    /**
     * @return A dense 1024-dimensional vector representation of the article content, generated using  the <a href="https://huggingface.co/intfloat/multilingual-e5-large">multilingual-e5-large</a> model.
     * <p><strong>Note</strong>: The <code>new_embedding</code> field is only available in the <code>v3_local_news_nlp_embeddings</code> subscription plan.</p>
     */
    @JsonProperty("new_embedding")
    public Optional<List<Float>> getNewEmbedding() {
        return newEmbedding;
    }

    /**
     * @return Named Entity Recognition for person entities (individuals' names).
     */
    @JsonProperty("ner_PER")
    public Optional<List<NamedEntityListItem>> getNerPer() {
        return nerPer;
    }

    /**
     * @return Named Entity Recognition for organization entities (company names, institutions).
     */
    @JsonProperty("ner_ORG")
    public Optional<List<NamedEntityListItem>> getNerOrg() {
        return nerOrg;
    }

    /**
     * @return Named Entity Recognition for miscellaneous entities (events, nationalities, products).
     */
    @JsonProperty("ner_MISC")
    public Optional<List<NamedEntityListItem>> getNerMisc() {
        return nerMisc;
    }

    /**
     * @return Named Entity Recognition for location entities (cities, countries, geographic features).
     */
    @JsonProperty("ner_LOC")
    public Optional<List<NamedEntityListItem>> getNerLoc() {
        return nerLoc;
    }

    /**
     * @return IPTC media topic taxonomy paths identified in the article content. Each path represents a hierarchical category following the IPTC standard.
     */
    @JsonProperty("iptc_tags_name")
    public Optional<List<String>> getIptcTagsName() {
        return iptcTagsName;
    }

    /**
     * @return IPTC media topic numeric codes identified in the article content. These codes correspond to the standardized IPTC media topic taxonomy.
     */
    @JsonProperty("iptc_tags_id")
    public Optional<List<String>> getIptcTagsId() {
        return iptcTagsId;
    }

    /**
     * @return IAB content taxonomy paths identified in the article content. Each path represents a hierarchical category following the IAB content standard.
     */
    @JsonProperty("iab_tags_name")
    public Optional<List<String>> getIabTagsName() {
        return iabTagsName;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NlpDataEntity && equalTo((NlpDataEntity) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(NlpDataEntity other) {
        return theme.equals(other.theme)
                && summary.equals(other.summary)
                && sentiment.equals(other.sentiment)
                && newEmbedding.equals(other.newEmbedding)
                && nerPer.equals(other.nerPer)
                && nerOrg.equals(other.nerOrg)
                && nerMisc.equals(other.nerMisc)
                && nerLoc.equals(other.nerLoc)
                && iptcTagsName.equals(other.iptcTagsName)
                && iptcTagsId.equals(other.iptcTagsId)
                && iabTagsName.equals(other.iabTagsName);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.theme,
                this.summary,
                this.sentiment,
                this.newEmbedding,
                this.nerPer,
                this.nerOrg,
                this.nerMisc,
                this.nerLoc,
                this.iptcTagsName,
                this.iptcTagsId,
                this.iabTagsName);
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
        private Optional<String> theme = Optional.empty();

        private Optional<String> summary = Optional.empty();

        private Optional<SentimentScores> sentiment = Optional.empty();

        private Optional<List<Float>> newEmbedding = Optional.empty();

        private Optional<List<NamedEntityListItem>> nerPer = Optional.empty();

        private Optional<List<NamedEntityListItem>> nerOrg = Optional.empty();

        private Optional<List<NamedEntityListItem>> nerMisc = Optional.empty();

        private Optional<List<NamedEntityListItem>> nerLoc = Optional.empty();

        private Optional<List<String>> iptcTagsName = Optional.empty();

        private Optional<List<String>> iptcTagsId = Optional.empty();

        private Optional<List<String>> iabTagsName = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(NlpDataEntity other) {
            theme(other.getTheme());
            summary(other.getSummary());
            sentiment(other.getSentiment());
            newEmbedding(other.getNewEmbedding());
            nerPer(other.getNerPer());
            nerOrg(other.getNerOrg());
            nerMisc(other.getNerMisc());
            nerLoc(other.getNerLoc());
            iptcTagsName(other.getIptcTagsName());
            iptcTagsId(other.getIptcTagsId());
            iabTagsName(other.getIabTagsName());
            return this;
        }

        @JsonSetter(value = "theme", nulls = Nulls.SKIP)
        public Builder theme(Optional<String> theme) {
            this.theme = theme;
            return this;
        }

        public Builder theme(String theme) {
            this.theme = Optional.ofNullable(theme);
            return this;
        }

        @JsonSetter(value = "summary", nulls = Nulls.SKIP)
        public Builder summary(Optional<String> summary) {
            this.summary = summary;
            return this;
        }

        public Builder summary(String summary) {
            this.summary = Optional.ofNullable(summary);
            return this;
        }

        @JsonSetter(value = "sentiment", nulls = Nulls.SKIP)
        public Builder sentiment(Optional<SentimentScores> sentiment) {
            this.sentiment = sentiment;
            return this;
        }

        public Builder sentiment(SentimentScores sentiment) {
            this.sentiment = Optional.ofNullable(sentiment);
            return this;
        }

        @JsonSetter(value = "new_embedding", nulls = Nulls.SKIP)
        public Builder newEmbedding(Optional<List<Float>> newEmbedding) {
            this.newEmbedding = newEmbedding;
            return this;
        }

        public Builder newEmbedding(List<Float> newEmbedding) {
            this.newEmbedding = Optional.ofNullable(newEmbedding);
            return this;
        }

        @JsonSetter(value = "ner_PER", nulls = Nulls.SKIP)
        public Builder nerPer(Optional<List<NamedEntityListItem>> nerPer) {
            this.nerPer = nerPer;
            return this;
        }

        public Builder nerPer(List<NamedEntityListItem> nerPer) {
            this.nerPer = Optional.ofNullable(nerPer);
            return this;
        }

        @JsonSetter(value = "ner_ORG", nulls = Nulls.SKIP)
        public Builder nerOrg(Optional<List<NamedEntityListItem>> nerOrg) {
            this.nerOrg = nerOrg;
            return this;
        }

        public Builder nerOrg(List<NamedEntityListItem> nerOrg) {
            this.nerOrg = Optional.ofNullable(nerOrg);
            return this;
        }

        @JsonSetter(value = "ner_MISC", nulls = Nulls.SKIP)
        public Builder nerMisc(Optional<List<NamedEntityListItem>> nerMisc) {
            this.nerMisc = nerMisc;
            return this;
        }

        public Builder nerMisc(List<NamedEntityListItem> nerMisc) {
            this.nerMisc = Optional.ofNullable(nerMisc);
            return this;
        }

        @JsonSetter(value = "ner_LOC", nulls = Nulls.SKIP)
        public Builder nerLoc(Optional<List<NamedEntityListItem>> nerLoc) {
            this.nerLoc = nerLoc;
            return this;
        }

        public Builder nerLoc(List<NamedEntityListItem> nerLoc) {
            this.nerLoc = Optional.ofNullable(nerLoc);
            return this;
        }

        @JsonSetter(value = "iptc_tags_name", nulls = Nulls.SKIP)
        public Builder iptcTagsName(Optional<List<String>> iptcTagsName) {
            this.iptcTagsName = iptcTagsName;
            return this;
        }

        public Builder iptcTagsName(List<String> iptcTagsName) {
            this.iptcTagsName = Optional.ofNullable(iptcTagsName);
            return this;
        }

        @JsonSetter(value = "iptc_tags_id", nulls = Nulls.SKIP)
        public Builder iptcTagsId(Optional<List<String>> iptcTagsId) {
            this.iptcTagsId = iptcTagsId;
            return this;
        }

        public Builder iptcTagsId(List<String> iptcTagsId) {
            this.iptcTagsId = Optional.ofNullable(iptcTagsId);
            return this;
        }

        @JsonSetter(value = "iab_tags_name", nulls = Nulls.SKIP)
        public Builder iabTagsName(Optional<List<String>> iabTagsName) {
            this.iabTagsName = iabTagsName;
            return this;
        }

        public Builder iabTagsName(List<String> iabTagsName) {
            this.iabTagsName = Optional.ofNullable(iabTagsName);
            return this;
        }

        public NlpDataEntity build() {
            return new NlpDataEntity(
                    theme,
                    summary,
                    sentiment,
                    newEmbedding,
                    nerPer,
                    nerOrg,
                    nerMisc,
                    nerLoc,
                    iptcTagsName,
                    iptcTagsId,
                    iabTagsName,
                    additionalProperties);
        }
    }
}
