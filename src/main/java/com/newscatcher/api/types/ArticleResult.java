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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ArticleResult.Builder.class)
public final class ArticleResult {
    private final String title;

    private final Optional<String> author;

    private final Optional<Authors> authors;

    private final Optional<Journalists> journalists;

    private final Optional<String> publishedDate;

    private final Optional<String> publishedDatePrecision;

    private final Optional<String> updatedDate;

    private final Optional<String> updatedDatePrecision;

    private final Optional<String> parseDate;

    private final String link;

    private final String domainUrl;

    private final String fullDomainUrl;

    private final Optional<String> nameSource;

    private final Optional<String> isHeadline;

    private final Optional<Boolean> paidContent;

    private final String extractionData;

    private final Optional<String> country;

    private final Optional<String> rights;

    private final int rank;

    private final Optional<String> media;

    private final Optional<String> language;

    private final Optional<String> description;

    private final String content;

    private final Optional<String> titleTranslatedEn;

    private final Optional<String> contentTranslatedEn;

    private final Optional<Integer> wordCount;

    private final Optional<Boolean> isOpinion;

    private final Optional<String> twitterAccount;

    private final Optional<DtoResponsesMoreLikeThisResponseArticleResultAllLinks> allLinks;

    private final Optional<DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks> allDomainLinks;

    private final Optional<Map<String, Object>> nlp;

    private final String id;

    private final double score;

    private final Optional<List<SimilarDocument>> similarDocuments;

    private final Optional<Map<String, Object>> customTags;

    private final Map<String, Object> additionalProperties;

    private ArticleResult(
            String title,
            Optional<String> author,
            Optional<Authors> authors,
            Optional<Journalists> journalists,
            Optional<String> publishedDate,
            Optional<String> publishedDatePrecision,
            Optional<String> updatedDate,
            Optional<String> updatedDatePrecision,
            Optional<String> parseDate,
            String link,
            String domainUrl,
            String fullDomainUrl,
            Optional<String> nameSource,
            Optional<String> isHeadline,
            Optional<Boolean> paidContent,
            String extractionData,
            Optional<String> country,
            Optional<String> rights,
            int rank,
            Optional<String> media,
            Optional<String> language,
            Optional<String> description,
            String content,
            Optional<String> titleTranslatedEn,
            Optional<String> contentTranslatedEn,
            Optional<Integer> wordCount,
            Optional<Boolean> isOpinion,
            Optional<String> twitterAccount,
            Optional<DtoResponsesMoreLikeThisResponseArticleResultAllLinks> allLinks,
            Optional<DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks> allDomainLinks,
            Optional<Map<String, Object>> nlp,
            String id,
            double score,
            Optional<List<SimilarDocument>> similarDocuments,
            Optional<Map<String, Object>> customTags,
            Map<String, Object> additionalProperties) {
        this.title = title;
        this.author = author;
        this.authors = authors;
        this.journalists = journalists;
        this.publishedDate = publishedDate;
        this.publishedDatePrecision = publishedDatePrecision;
        this.updatedDate = updatedDate;
        this.updatedDatePrecision = updatedDatePrecision;
        this.parseDate = parseDate;
        this.link = link;
        this.domainUrl = domainUrl;
        this.fullDomainUrl = fullDomainUrl;
        this.nameSource = nameSource;
        this.isHeadline = isHeadline;
        this.paidContent = paidContent;
        this.extractionData = extractionData;
        this.country = country;
        this.rights = rights;
        this.rank = rank;
        this.media = media;
        this.language = language;
        this.description = description;
        this.content = content;
        this.titleTranslatedEn = titleTranslatedEn;
        this.contentTranslatedEn = contentTranslatedEn;
        this.wordCount = wordCount;
        this.isOpinion = isOpinion;
        this.twitterAccount = twitterAccount;
        this.allLinks = allLinks;
        this.allDomainLinks = allDomainLinks;
        this.nlp = nlp;
        this.id = id;
        this.score = score;
        this.similarDocuments = similarDocuments;
        this.customTags = customTags;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("author")
    public Optional<String> getAuthor() {
        return author;
    }

    @JsonProperty("authors")
    public Optional<Authors> getAuthors() {
        return authors;
    }

    @JsonProperty("journalists")
    public Optional<Journalists> getJournalists() {
        return journalists;
    }

    @JsonProperty("published_date")
    public Optional<String> getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("published_date_precision")
    public Optional<String> getPublishedDatePrecision() {
        return publishedDatePrecision;
    }

    @JsonProperty("updated_date")
    public Optional<String> getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("updated_date_precision")
    public Optional<String> getUpdatedDatePrecision() {
        return updatedDatePrecision;
    }

    @JsonProperty("parse_date")
    public Optional<String> getParseDate() {
        return parseDate;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("domain_url")
    public String getDomainUrl() {
        return domainUrl;
    }

    @JsonProperty("full_domain_url")
    public String getFullDomainUrl() {
        return fullDomainUrl;
    }

    @JsonProperty("name_source")
    public Optional<String> getNameSource() {
        return nameSource;
    }

    @JsonProperty("is_headline")
    public Optional<String> getIsHeadline() {
        return isHeadline;
    }

    @JsonProperty("paid_content")
    public Optional<Boolean> getPaidContent() {
        return paidContent;
    }

    @JsonProperty("extraction_data")
    public String getExtractionData() {
        return extractionData;
    }

    @JsonProperty("country")
    public Optional<String> getCountry() {
        return country;
    }

    @JsonProperty("rights")
    public Optional<String> getRights() {
        return rights;
    }

    @JsonProperty("rank")
    public int getRank() {
        return rank;
    }

    @JsonProperty("media")
    public Optional<String> getMedia() {
        return media;
    }

    @JsonProperty("language")
    public Optional<String> getLanguage() {
        return language;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("title_translated_en")
    public Optional<String> getTitleTranslatedEn() {
        return titleTranslatedEn;
    }

    @JsonProperty("content_translated_en")
    public Optional<String> getContentTranslatedEn() {
        return contentTranslatedEn;
    }

    @JsonProperty("word_count")
    public Optional<Integer> getWordCount() {
        return wordCount;
    }

    @JsonProperty("is_opinion")
    public Optional<Boolean> getIsOpinion() {
        return isOpinion;
    }

    @JsonProperty("twitter_account")
    public Optional<String> getTwitterAccount() {
        return twitterAccount;
    }

    @JsonProperty("all_links")
    public Optional<DtoResponsesMoreLikeThisResponseArticleResultAllLinks> getAllLinks() {
        return allLinks;
    }

    @JsonProperty("all_domain_links")
    public Optional<DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks> getAllDomainLinks() {
        return allDomainLinks;
    }

    @JsonProperty("nlp")
    public Optional<Map<String, Object>> getNlp() {
        return nlp;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("score")
    public double getScore() {
        return score;
    }

    @JsonProperty("similar_documents")
    public Optional<List<SimilarDocument>> getSimilarDocuments() {
        return similarDocuments;
    }

    @JsonProperty("custom_tags")
    public Optional<Map<String, Object>> getCustomTags() {
        return customTags;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ArticleResult && equalTo((ArticleResult) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ArticleResult other) {
        return title.equals(other.title)
                && author.equals(other.author)
                && authors.equals(other.authors)
                && journalists.equals(other.journalists)
                && publishedDate.equals(other.publishedDate)
                && publishedDatePrecision.equals(other.publishedDatePrecision)
                && updatedDate.equals(other.updatedDate)
                && updatedDatePrecision.equals(other.updatedDatePrecision)
                && parseDate.equals(other.parseDate)
                && link.equals(other.link)
                && domainUrl.equals(other.domainUrl)
                && fullDomainUrl.equals(other.fullDomainUrl)
                && nameSource.equals(other.nameSource)
                && isHeadline.equals(other.isHeadline)
                && paidContent.equals(other.paidContent)
                && extractionData.equals(other.extractionData)
                && country.equals(other.country)
                && rights.equals(other.rights)
                && rank == other.rank
                && media.equals(other.media)
                && language.equals(other.language)
                && description.equals(other.description)
                && content.equals(other.content)
                && titleTranslatedEn.equals(other.titleTranslatedEn)
                && contentTranslatedEn.equals(other.contentTranslatedEn)
                && wordCount.equals(other.wordCount)
                && isOpinion.equals(other.isOpinion)
                && twitterAccount.equals(other.twitterAccount)
                && allLinks.equals(other.allLinks)
                && allDomainLinks.equals(other.allDomainLinks)
                && nlp.equals(other.nlp)
                && id.equals(other.id)
                && score == other.score
                && similarDocuments.equals(other.similarDocuments)
                && customTags.equals(other.customTags);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.title,
                this.author,
                this.authors,
                this.journalists,
                this.publishedDate,
                this.publishedDatePrecision,
                this.updatedDate,
                this.updatedDatePrecision,
                this.parseDate,
                this.link,
                this.domainUrl,
                this.fullDomainUrl,
                this.nameSource,
                this.isHeadline,
                this.paidContent,
                this.extractionData,
                this.country,
                this.rights,
                this.rank,
                this.media,
                this.language,
                this.description,
                this.content,
                this.titleTranslatedEn,
                this.contentTranslatedEn,
                this.wordCount,
                this.isOpinion,
                this.twitterAccount,
                this.allLinks,
                this.allDomainLinks,
                this.nlp,
                this.id,
                this.score,
                this.similarDocuments,
                this.customTags);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TitleStage builder() {
        return new Builder();
    }

    public interface TitleStage {
        LinkStage title(@NotNull String title);

        Builder from(ArticleResult other);
    }

    public interface LinkStage {
        DomainUrlStage link(@NotNull String link);
    }

    public interface DomainUrlStage {
        FullDomainUrlStage domainUrl(@NotNull String domainUrl);
    }

    public interface FullDomainUrlStage {
        ExtractionDataStage fullDomainUrl(@NotNull String fullDomainUrl);
    }

    public interface ExtractionDataStage {
        RankStage extractionData(@NotNull String extractionData);
    }

    public interface RankStage {
        ContentStage rank(int rank);
    }

    public interface ContentStage {
        IdStage content(@NotNull String content);
    }

    public interface IdStage {
        ScoreStage id(@NotNull String id);
    }

    public interface ScoreStage {
        _FinalStage score(double score);
    }

    public interface _FinalStage {
        ArticleResult build();

        _FinalStage author(Optional<String> author);

        _FinalStage author(String author);

        _FinalStage authors(Optional<Authors> authors);

        _FinalStage authors(Authors authors);

        _FinalStage journalists(Optional<Journalists> journalists);

        _FinalStage journalists(Journalists journalists);

        _FinalStage publishedDate(Optional<String> publishedDate);

        _FinalStage publishedDate(String publishedDate);

        _FinalStage publishedDatePrecision(Optional<String> publishedDatePrecision);

        _FinalStage publishedDatePrecision(String publishedDatePrecision);

        _FinalStage updatedDate(Optional<String> updatedDate);

        _FinalStage updatedDate(String updatedDate);

        _FinalStage updatedDatePrecision(Optional<String> updatedDatePrecision);

        _FinalStage updatedDatePrecision(String updatedDatePrecision);

        _FinalStage parseDate(Optional<String> parseDate);

        _FinalStage parseDate(String parseDate);

        _FinalStage nameSource(Optional<String> nameSource);

        _FinalStage nameSource(String nameSource);

        _FinalStage isHeadline(Optional<String> isHeadline);

        _FinalStage isHeadline(String isHeadline);

        _FinalStage paidContent(Optional<Boolean> paidContent);

        _FinalStage paidContent(Boolean paidContent);

        _FinalStage country(Optional<String> country);

        _FinalStage country(String country);

        _FinalStage rights(Optional<String> rights);

        _FinalStage rights(String rights);

        _FinalStage media(Optional<String> media);

        _FinalStage media(String media);

        _FinalStage language(Optional<String> language);

        _FinalStage language(String language);

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage titleTranslatedEn(Optional<String> titleTranslatedEn);

        _FinalStage titleTranslatedEn(String titleTranslatedEn);

        _FinalStage contentTranslatedEn(Optional<String> contentTranslatedEn);

        _FinalStage contentTranslatedEn(String contentTranslatedEn);

        _FinalStage wordCount(Optional<Integer> wordCount);

        _FinalStage wordCount(Integer wordCount);

        _FinalStage isOpinion(Optional<Boolean> isOpinion);

        _FinalStage isOpinion(Boolean isOpinion);

        _FinalStage twitterAccount(Optional<String> twitterAccount);

        _FinalStage twitterAccount(String twitterAccount);

        _FinalStage allLinks(Optional<DtoResponsesMoreLikeThisResponseArticleResultAllLinks> allLinks);

        _FinalStage allLinks(DtoResponsesMoreLikeThisResponseArticleResultAllLinks allLinks);

        _FinalStage allDomainLinks(
                Optional<DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks> allDomainLinks);

        _FinalStage allDomainLinks(DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks allDomainLinks);

        _FinalStage nlp(Optional<Map<String, Object>> nlp);

        _FinalStage nlp(Map<String, Object> nlp);

        _FinalStage similarDocuments(Optional<List<SimilarDocument>> similarDocuments);

        _FinalStage similarDocuments(List<SimilarDocument> similarDocuments);

        _FinalStage customTags(Optional<Map<String, Object>> customTags);

        _FinalStage customTags(Map<String, Object> customTags);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TitleStage,
                    LinkStage,
                    DomainUrlStage,
                    FullDomainUrlStage,
                    ExtractionDataStage,
                    RankStage,
                    ContentStage,
                    IdStage,
                    ScoreStage,
                    _FinalStage {
        private String title;

        private String link;

        private String domainUrl;

        private String fullDomainUrl;

        private String extractionData;

        private int rank;

        private String content;

        private String id;

        private double score;

        private Optional<Map<String, Object>> customTags = Optional.empty();

        private Optional<List<SimilarDocument>> similarDocuments = Optional.empty();

        private Optional<Map<String, Object>> nlp = Optional.empty();

        private Optional<DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks> allDomainLinks = Optional.empty();

        private Optional<DtoResponsesMoreLikeThisResponseArticleResultAllLinks> allLinks = Optional.empty();

        private Optional<String> twitterAccount = Optional.empty();

        private Optional<Boolean> isOpinion = Optional.empty();

        private Optional<Integer> wordCount = Optional.empty();

        private Optional<String> contentTranslatedEn = Optional.empty();

        private Optional<String> titleTranslatedEn = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> language = Optional.empty();

        private Optional<String> media = Optional.empty();

        private Optional<String> rights = Optional.empty();

        private Optional<String> country = Optional.empty();

        private Optional<Boolean> paidContent = Optional.empty();

        private Optional<String> isHeadline = Optional.empty();

        private Optional<String> nameSource = Optional.empty();

        private Optional<String> parseDate = Optional.empty();

        private Optional<String> updatedDatePrecision = Optional.empty();

        private Optional<String> updatedDate = Optional.empty();

        private Optional<String> publishedDatePrecision = Optional.empty();

        private Optional<String> publishedDate = Optional.empty();

        private Optional<Journalists> journalists = Optional.empty();

        private Optional<Authors> authors = Optional.empty();

        private Optional<String> author = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ArticleResult other) {
            title(other.getTitle());
            author(other.getAuthor());
            authors(other.getAuthors());
            journalists(other.getJournalists());
            publishedDate(other.getPublishedDate());
            publishedDatePrecision(other.getPublishedDatePrecision());
            updatedDate(other.getUpdatedDate());
            updatedDatePrecision(other.getUpdatedDatePrecision());
            parseDate(other.getParseDate());
            link(other.getLink());
            domainUrl(other.getDomainUrl());
            fullDomainUrl(other.getFullDomainUrl());
            nameSource(other.getNameSource());
            isHeadline(other.getIsHeadline());
            paidContent(other.getPaidContent());
            extractionData(other.getExtractionData());
            country(other.getCountry());
            rights(other.getRights());
            rank(other.getRank());
            media(other.getMedia());
            language(other.getLanguage());
            description(other.getDescription());
            content(other.getContent());
            titleTranslatedEn(other.getTitleTranslatedEn());
            contentTranslatedEn(other.getContentTranslatedEn());
            wordCount(other.getWordCount());
            isOpinion(other.getIsOpinion());
            twitterAccount(other.getTwitterAccount());
            allLinks(other.getAllLinks());
            allDomainLinks(other.getAllDomainLinks());
            nlp(other.getNlp());
            id(other.getId());
            score(other.getScore());
            similarDocuments(other.getSimilarDocuments());
            customTags(other.getCustomTags());
            return this;
        }

        @java.lang.Override
        @JsonSetter("title")
        public LinkStage title(@NotNull String title) {
            this.title = Objects.requireNonNull(title, "title must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("link")
        public DomainUrlStage link(@NotNull String link) {
            this.link = Objects.requireNonNull(link, "link must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("domain_url")
        public FullDomainUrlStage domainUrl(@NotNull String domainUrl) {
            this.domainUrl = Objects.requireNonNull(domainUrl, "domainUrl must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("full_domain_url")
        public ExtractionDataStage fullDomainUrl(@NotNull String fullDomainUrl) {
            this.fullDomainUrl = Objects.requireNonNull(fullDomainUrl, "fullDomainUrl must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("extraction_data")
        public RankStage extractionData(@NotNull String extractionData) {
            this.extractionData = Objects.requireNonNull(extractionData, "extractionData must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("rank")
        public ContentStage rank(int rank) {
            this.rank = rank;
            return this;
        }

        @java.lang.Override
        @JsonSetter("content")
        public IdStage content(@NotNull String content) {
            this.content = Objects.requireNonNull(content, "content must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("id")
        public ScoreStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("score")
        public _FinalStage score(double score) {
            this.score = score;
            return this;
        }

        @java.lang.Override
        public _FinalStage customTags(Map<String, Object> customTags) {
            this.customTags = Optional.ofNullable(customTags);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "custom_tags", nulls = Nulls.SKIP)
        public _FinalStage customTags(Optional<Map<String, Object>> customTags) {
            this.customTags = customTags;
            return this;
        }

        @java.lang.Override
        public _FinalStage similarDocuments(List<SimilarDocument> similarDocuments) {
            this.similarDocuments = Optional.ofNullable(similarDocuments);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "similar_documents", nulls = Nulls.SKIP)
        public _FinalStage similarDocuments(Optional<List<SimilarDocument>> similarDocuments) {
            this.similarDocuments = similarDocuments;
            return this;
        }

        @java.lang.Override
        public _FinalStage nlp(Map<String, Object> nlp) {
            this.nlp = Optional.ofNullable(nlp);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "nlp", nulls = Nulls.SKIP)
        public _FinalStage nlp(Optional<Map<String, Object>> nlp) {
            this.nlp = nlp;
            return this;
        }

        @java.lang.Override
        public _FinalStage allDomainLinks(DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks allDomainLinks) {
            this.allDomainLinks = Optional.ofNullable(allDomainLinks);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "all_domain_links", nulls = Nulls.SKIP)
        public _FinalStage allDomainLinks(
                Optional<DtoResponsesMoreLikeThisResponseArticleResultAllDomainLinks> allDomainLinks) {
            this.allDomainLinks = allDomainLinks;
            return this;
        }

        @java.lang.Override
        public _FinalStage allLinks(DtoResponsesMoreLikeThisResponseArticleResultAllLinks allLinks) {
            this.allLinks = Optional.ofNullable(allLinks);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "all_links", nulls = Nulls.SKIP)
        public _FinalStage allLinks(Optional<DtoResponsesMoreLikeThisResponseArticleResultAllLinks> allLinks) {
            this.allLinks = allLinks;
            return this;
        }

        @java.lang.Override
        public _FinalStage twitterAccount(String twitterAccount) {
            this.twitterAccount = Optional.ofNullable(twitterAccount);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "twitter_account", nulls = Nulls.SKIP)
        public _FinalStage twitterAccount(Optional<String> twitterAccount) {
            this.twitterAccount = twitterAccount;
            return this;
        }

        @java.lang.Override
        public _FinalStage isOpinion(Boolean isOpinion) {
            this.isOpinion = Optional.ofNullable(isOpinion);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_opinion", nulls = Nulls.SKIP)
        public _FinalStage isOpinion(Optional<Boolean> isOpinion) {
            this.isOpinion = isOpinion;
            return this;
        }

        @java.lang.Override
        public _FinalStage wordCount(Integer wordCount) {
            this.wordCount = Optional.ofNullable(wordCount);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "word_count", nulls = Nulls.SKIP)
        public _FinalStage wordCount(Optional<Integer> wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        @java.lang.Override
        public _FinalStage contentTranslatedEn(String contentTranslatedEn) {
            this.contentTranslatedEn = Optional.ofNullable(contentTranslatedEn);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "content_translated_en", nulls = Nulls.SKIP)
        public _FinalStage contentTranslatedEn(Optional<String> contentTranslatedEn) {
            this.contentTranslatedEn = contentTranslatedEn;
            return this;
        }

        @java.lang.Override
        public _FinalStage titleTranslatedEn(String titleTranslatedEn) {
            this.titleTranslatedEn = Optional.ofNullable(titleTranslatedEn);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "title_translated_en", nulls = Nulls.SKIP)
        public _FinalStage titleTranslatedEn(Optional<String> titleTranslatedEn) {
            this.titleTranslatedEn = titleTranslatedEn;
            return this;
        }

        @java.lang.Override
        public _FinalStage description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        @java.lang.Override
        public _FinalStage language(String language) {
            this.language = Optional.ofNullable(language);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "language", nulls = Nulls.SKIP)
        public _FinalStage language(Optional<String> language) {
            this.language = language;
            return this;
        }

        @java.lang.Override
        public _FinalStage media(String media) {
            this.media = Optional.ofNullable(media);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "media", nulls = Nulls.SKIP)
        public _FinalStage media(Optional<String> media) {
            this.media = media;
            return this;
        }

        @java.lang.Override
        public _FinalStage rights(String rights) {
            this.rights = Optional.ofNullable(rights);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "rights", nulls = Nulls.SKIP)
        public _FinalStage rights(Optional<String> rights) {
            this.rights = rights;
            return this;
        }

        @java.lang.Override
        public _FinalStage country(String country) {
            this.country = Optional.ofNullable(country);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "country", nulls = Nulls.SKIP)
        public _FinalStage country(Optional<String> country) {
            this.country = country;
            return this;
        }

        @java.lang.Override
        public _FinalStage paidContent(Boolean paidContent) {
            this.paidContent = Optional.ofNullable(paidContent);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "paid_content", nulls = Nulls.SKIP)
        public _FinalStage paidContent(Optional<Boolean> paidContent) {
            this.paidContent = paidContent;
            return this;
        }

        @java.lang.Override
        public _FinalStage isHeadline(String isHeadline) {
            this.isHeadline = Optional.ofNullable(isHeadline);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_headline", nulls = Nulls.SKIP)
        public _FinalStage isHeadline(Optional<String> isHeadline) {
            this.isHeadline = isHeadline;
            return this;
        }

        @java.lang.Override
        public _FinalStage nameSource(String nameSource) {
            this.nameSource = Optional.ofNullable(nameSource);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "name_source", nulls = Nulls.SKIP)
        public _FinalStage nameSource(Optional<String> nameSource) {
            this.nameSource = nameSource;
            return this;
        }

        @java.lang.Override
        public _FinalStage parseDate(String parseDate) {
            this.parseDate = Optional.ofNullable(parseDate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "parse_date", nulls = Nulls.SKIP)
        public _FinalStage parseDate(Optional<String> parseDate) {
            this.parseDate = parseDate;
            return this;
        }

        @java.lang.Override
        public _FinalStage updatedDatePrecision(String updatedDatePrecision) {
            this.updatedDatePrecision = Optional.ofNullable(updatedDatePrecision);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "updated_date_precision", nulls = Nulls.SKIP)
        public _FinalStage updatedDatePrecision(Optional<String> updatedDatePrecision) {
            this.updatedDatePrecision = updatedDatePrecision;
            return this;
        }

        @java.lang.Override
        public _FinalStage updatedDate(String updatedDate) {
            this.updatedDate = Optional.ofNullable(updatedDate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "updated_date", nulls = Nulls.SKIP)
        public _FinalStage updatedDate(Optional<String> updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        @java.lang.Override
        public _FinalStage publishedDatePrecision(String publishedDatePrecision) {
            this.publishedDatePrecision = Optional.ofNullable(publishedDatePrecision);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "published_date_precision", nulls = Nulls.SKIP)
        public _FinalStage publishedDatePrecision(Optional<String> publishedDatePrecision) {
            this.publishedDatePrecision = publishedDatePrecision;
            return this;
        }

        @java.lang.Override
        public _FinalStage publishedDate(String publishedDate) {
            this.publishedDate = Optional.ofNullable(publishedDate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "published_date", nulls = Nulls.SKIP)
        public _FinalStage publishedDate(Optional<String> publishedDate) {
            this.publishedDate = publishedDate;
            return this;
        }

        @java.lang.Override
        public _FinalStage journalists(Journalists journalists) {
            this.journalists = Optional.ofNullable(journalists);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "journalists", nulls = Nulls.SKIP)
        public _FinalStage journalists(Optional<Journalists> journalists) {
            this.journalists = journalists;
            return this;
        }

        @java.lang.Override
        public _FinalStage authors(Authors authors) {
            this.authors = Optional.ofNullable(authors);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "authors", nulls = Nulls.SKIP)
        public _FinalStage authors(Optional<Authors> authors) {
            this.authors = authors;
            return this;
        }

        @java.lang.Override
        public _FinalStage author(String author) {
            this.author = Optional.ofNullable(author);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "author", nulls = Nulls.SKIP)
        public _FinalStage author(Optional<String> author) {
            this.author = author;
            return this;
        }

        @java.lang.Override
        public ArticleResult build() {
            return new ArticleResult(
                    title,
                    author,
                    authors,
                    journalists,
                    publishedDate,
                    publishedDatePrecision,
                    updatedDate,
                    updatedDatePrecision,
                    parseDate,
                    link,
                    domainUrl,
                    fullDomainUrl,
                    nameSource,
                    isHeadline,
                    paidContent,
                    extractionData,
                    country,
                    rights,
                    rank,
                    media,
                    language,
                    description,
                    content,
                    titleTranslatedEn,
                    contentTranslatedEn,
                    wordCount,
                    isOpinion,
                    twitterAccount,
                    allLinks,
                    allDomainLinks,
                    nlp,
                    id,
                    score,
                    similarDocuments,
                    customTags,
                    additionalProperties);
        }
    }
}