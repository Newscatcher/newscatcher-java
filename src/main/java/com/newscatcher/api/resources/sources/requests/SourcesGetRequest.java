/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.resources.sources.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newscatcher.api.core.ObjectMappers;
import com.newscatcher.api.resources.sources.types.SourcesGetRequestNewsDomainType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SourcesGetRequest.Builder.class)
public final class SourcesGetRequest {
    private final Optional<String> lang;

    private final Optional<String> countries;

    private final Optional<String> predefinedSources;

    private final Optional<String> sourceName;

    private final Optional<String> sourceUrl;

    private final Optional<Boolean> includeAdditionalInfo;

    private final Optional<Boolean> isNewsDomain;

    private final Optional<SourcesGetRequestNewsDomainType> newsDomainType;

    private final Optional<String> newsType;

    private final Optional<Integer> fromRank;

    private final Optional<Integer> toRank;

    private final Map<String, Object> additionalProperties;

    private SourcesGetRequest(
            Optional<String> lang,
            Optional<String> countries,
            Optional<String> predefinedSources,
            Optional<String> sourceName,
            Optional<String> sourceUrl,
            Optional<Boolean> includeAdditionalInfo,
            Optional<Boolean> isNewsDomain,
            Optional<SourcesGetRequestNewsDomainType> newsDomainType,
            Optional<String> newsType,
            Optional<Integer> fromRank,
            Optional<Integer> toRank,
            Map<String, Object> additionalProperties) {
        this.lang = lang;
        this.countries = countries;
        this.predefinedSources = predefinedSources;
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
        this.includeAdditionalInfo = includeAdditionalInfo;
        this.isNewsDomain = isNewsDomain;
        this.newsDomainType = newsDomainType;
        this.newsType = newsType;
        this.fromRank = fromRank;
        this.toRank = toRank;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The language(s) of the search. The only accepted format is the two-letter <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a> code. To select multiple languages, use a comma-separated string.
     * <p>Example: <code>&quot;en, es&quot;</code></p>
     * <p>To learn more, see <a href="/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang">Enumerated parameters &gt; Language</a>.</p>
     */
    @JsonProperty("lang")
    public Optional<String> getLang() {
        return lang;
    }

    /**
     * @return The countries where the news publisher is located. The accepted format is the two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> code. To select multiple countries, use a comma-separated string.
     * <p>Example: <code>&quot;US, CA&quot;</code></p>
     * <p>To learn more, see <a href="/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country">Enumerated parameters &gt; Country</a>.</p>
     */
    @JsonProperty("countries")
    public Optional<String> getCountries() {
        return countries;
    }

    /**
     * @return Predefined top news sources per country.
     * <p>Format: start with the word <code>top</code>, followed by the number of desired sources, and then the two-letter country code <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>. Multiple countries with the number of top sources can be specified as a comma-separated string.</p>
     * <p>Examples:</p>
     * <ul>
     * <li><code>&quot;top 100 US&quot;</code></li>
     * <li><code>&quot;top 33 AT&quot;</code></li>
     * <li><code>&quot;top 50 US, top 20 GB&quot;</code></li>
     * <li><code>&quot;top 33 AT, top 50 IT&quot;</code></li>
     * </ul>
     */
    @JsonProperty("predefined_sources")
    public Optional<String> getPredefinedSources() {
        return predefinedSources;
    }

    /**
     * @return Word or phrase to search within the source names. To specify multiple values, use a comma-separated string.
     * <p>Example: <code>&quot;sport, tech&quot;</code></p>
     * <p><strong>Note</strong>: The search doesn't require an exact match and returns sources containing the specified terms in their names. You can use any word or phrase, like <code>&quot;sport&quot;</code> or <code>&quot;new york times&quot;</code>. For example, <code>&quot;sport&quot;</code> returns sources such as <code>&quot;Motorsport&quot;</code>, <code>&quot;Dot Esport&quot;</code>, and <code>&quot;Tuttosport&quot;</code>.</p>
     */
    @JsonProperty("source_name")
    public Optional<String> getSourceName() {
        return sourceName;
    }

    /**
     * @return The domain(s) of the news publication to search for.
     * <p><strong>Caution</strong>:  When specifying the <code>source_url</code> parameter,
     * you can only use <code>include_additional_info</code> as an extra parameter.</p>
     */
    @JsonProperty("source_url")
    public Optional<String> getSourceUrl() {
        return sourceUrl;
    }

    /**
     * @return If true, returns the following additional datapoints about each news source:
     * <ul>
     * <li><code>nb_articles_for_7d</code>: The number of articles published by the source in the last week.</li>
     * <li><code>country</code>: Source country of origin.</li>
     * <li><code>rank</code>: SEO rank.</li>
     * <li><code>is_news_domain</code>: Boolean indicating if the source is a news domain.</li>
     * <li><code>news_domain_type</code>: Type of news domain (e.g., &quot;Original Content&quot;).</li>
     * <li><code>news_type</code>: Category of news (e.g., &quot;General News Outlets&quot;).</li>
     * </ul>
     */
    @JsonProperty("include_additional_info")
    public Optional<Boolean> getIncludeAdditionalInfo() {
        return includeAdditionalInfo;
    }

    /**
     * @return If true, filters results to include only news domains.
     */
    @JsonProperty("is_news_domain")
    public Optional<Boolean> getIsNewsDomain() {
        return isNewsDomain;
    }

    /**
     * @return Filters results based on the news domain type. Possible values are:
     * <ul>
     * <li><code>Original Content</code>: Sources that produce their own content.</li>
     * <li><code>Aggregator</code>: Sources that collect content from various other sources.</li>
     * <li><code>Press Releases</code>: Sources primarily publishing press releases.</li>
     * <li><code>Republisher</code>: Sources that republish content from other sources.</li>
     * <li><code>Other</code>: Sources that don't fit into main categories.</li>
     * </ul>
     */
    @JsonProperty("news_domain_type")
    public Optional<SourcesGetRequestNewsDomainType> getNewsDomainType() {
        return newsDomainType;
    }

    /**
     * @return Filters results based on the news type. Multiple types can be specified using a comma-separated string.
     * <p>Example: <code>&quot;General News Outlets,Tech News and Updates&quot;</code></p>
     * <p>For a complete list of available news types, see <a href="/docs/v3/api-reference/overview/enumerated-parameters#news-type-news-type">Enumerated parameters &gt; News type</a>.</p>
     */
    @JsonProperty("news_type")
    public Optional<String> getNewsType() {
        return newsType;
    }

    /**
     * @return The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
     */
    @JsonProperty("from_rank")
    public Optional<Integer> getFromRank() {
        return fromRank;
    }

    /**
     * @return The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
     */
    @JsonProperty("to_rank")
    public Optional<Integer> getToRank() {
        return toRank;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SourcesGetRequest && equalTo((SourcesGetRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SourcesGetRequest other) {
        return lang.equals(other.lang)
                && countries.equals(other.countries)
                && predefinedSources.equals(other.predefinedSources)
                && sourceName.equals(other.sourceName)
                && sourceUrl.equals(other.sourceUrl)
                && includeAdditionalInfo.equals(other.includeAdditionalInfo)
                && isNewsDomain.equals(other.isNewsDomain)
                && newsDomainType.equals(other.newsDomainType)
                && newsType.equals(other.newsType)
                && fromRank.equals(other.fromRank)
                && toRank.equals(other.toRank);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.lang,
                this.countries,
                this.predefinedSources,
                this.sourceName,
                this.sourceUrl,
                this.includeAdditionalInfo,
                this.isNewsDomain,
                this.newsDomainType,
                this.newsType,
                this.fromRank,
                this.toRank);
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
        private Optional<String> lang = Optional.empty();

        private Optional<String> countries = Optional.empty();

        private Optional<String> predefinedSources = Optional.empty();

        private Optional<String> sourceName = Optional.empty();

        private Optional<String> sourceUrl = Optional.empty();

        private Optional<Boolean> includeAdditionalInfo = Optional.empty();

        private Optional<Boolean> isNewsDomain = Optional.empty();

        private Optional<SourcesGetRequestNewsDomainType> newsDomainType = Optional.empty();

        private Optional<String> newsType = Optional.empty();

        private Optional<Integer> fromRank = Optional.empty();

        private Optional<Integer> toRank = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SourcesGetRequest other) {
            lang(other.getLang());
            countries(other.getCountries());
            predefinedSources(other.getPredefinedSources());
            sourceName(other.getSourceName());
            sourceUrl(other.getSourceUrl());
            includeAdditionalInfo(other.getIncludeAdditionalInfo());
            isNewsDomain(other.getIsNewsDomain());
            newsDomainType(other.getNewsDomainType());
            newsType(other.getNewsType());
            fromRank(other.getFromRank());
            toRank(other.getToRank());
            return this;
        }

        @JsonSetter(value = "lang", nulls = Nulls.SKIP)
        public Builder lang(Optional<String> lang) {
            this.lang = lang;
            return this;
        }

        public Builder lang(String lang) {
            this.lang = Optional.ofNullable(lang);
            return this;
        }

        @JsonSetter(value = "countries", nulls = Nulls.SKIP)
        public Builder countries(Optional<String> countries) {
            this.countries = countries;
            return this;
        }

        public Builder countries(String countries) {
            this.countries = Optional.ofNullable(countries);
            return this;
        }

        @JsonSetter(value = "predefined_sources", nulls = Nulls.SKIP)
        public Builder predefinedSources(Optional<String> predefinedSources) {
            this.predefinedSources = predefinedSources;
            return this;
        }

        public Builder predefinedSources(String predefinedSources) {
            this.predefinedSources = Optional.ofNullable(predefinedSources);
            return this;
        }

        @JsonSetter(value = "source_name", nulls = Nulls.SKIP)
        public Builder sourceName(Optional<String> sourceName) {
            this.sourceName = sourceName;
            return this;
        }

        public Builder sourceName(String sourceName) {
            this.sourceName = Optional.ofNullable(sourceName);
            return this;
        }

        @JsonSetter(value = "source_url", nulls = Nulls.SKIP)
        public Builder sourceUrl(Optional<String> sourceUrl) {
            this.sourceUrl = sourceUrl;
            return this;
        }

        public Builder sourceUrl(String sourceUrl) {
            this.sourceUrl = Optional.ofNullable(sourceUrl);
            return this;
        }

        @JsonSetter(value = "include_additional_info", nulls = Nulls.SKIP)
        public Builder includeAdditionalInfo(Optional<Boolean> includeAdditionalInfo) {
            this.includeAdditionalInfo = includeAdditionalInfo;
            return this;
        }

        public Builder includeAdditionalInfo(Boolean includeAdditionalInfo) {
            this.includeAdditionalInfo = Optional.ofNullable(includeAdditionalInfo);
            return this;
        }

        @JsonSetter(value = "is_news_domain", nulls = Nulls.SKIP)
        public Builder isNewsDomain(Optional<Boolean> isNewsDomain) {
            this.isNewsDomain = isNewsDomain;
            return this;
        }

        public Builder isNewsDomain(Boolean isNewsDomain) {
            this.isNewsDomain = Optional.ofNullable(isNewsDomain);
            return this;
        }

        @JsonSetter(value = "news_domain_type", nulls = Nulls.SKIP)
        public Builder newsDomainType(Optional<SourcesGetRequestNewsDomainType> newsDomainType) {
            this.newsDomainType = newsDomainType;
            return this;
        }

        public Builder newsDomainType(SourcesGetRequestNewsDomainType newsDomainType) {
            this.newsDomainType = Optional.ofNullable(newsDomainType);
            return this;
        }

        @JsonSetter(value = "news_type", nulls = Nulls.SKIP)
        public Builder newsType(Optional<String> newsType) {
            this.newsType = newsType;
            return this;
        }

        public Builder newsType(String newsType) {
            this.newsType = Optional.ofNullable(newsType);
            return this;
        }

        @JsonSetter(value = "from_rank", nulls = Nulls.SKIP)
        public Builder fromRank(Optional<Integer> fromRank) {
            this.fromRank = fromRank;
            return this;
        }

        public Builder fromRank(Integer fromRank) {
            this.fromRank = Optional.ofNullable(fromRank);
            return this;
        }

        @JsonSetter(value = "to_rank", nulls = Nulls.SKIP)
        public Builder toRank(Optional<Integer> toRank) {
            this.toRank = toRank;
            return this;
        }

        public Builder toRank(Integer toRank) {
            this.toRank = Optional.ofNullable(toRank);
            return this;
        }

        public SourcesGetRequest build() {
            return new SourcesGetRequest(
                    lang,
                    countries,
                    predefinedSources,
                    sourceName,
                    sourceUrl,
                    includeAdditionalInfo,
                    isNewsDomain,
                    newsDomainType,
                    newsType,
                    fromRank,
                    toRank,
                    additionalProperties);
        }
    }
}
