/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.types;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IArticleEntity {
    String getTitle();

    Optional<String> getAuthor();

    Optional<Authors> getAuthors();

    Optional<Journalists> getJournalists();

    Optional<String> getPublishedDate();

    Optional<String> getPublishedDatePrecision();

    Optional<String> getUpdatedDate();

    Optional<String> getUpdatedDatePrecision();

    Optional<String> getParseDate();

    String getLink();

    String getDomainUrl();

    String getFullDomainUrl();

    Optional<String> getNameSource();

    Optional<Boolean> getIsHeadline();

    Optional<Boolean> getPaidContent();

    String getParentUrl();

    Optional<String> getCountry();

    Optional<String> getRights();

    int getRank();

    Optional<String> getMedia();

    Optional<String> getLanguage();

    Optional<String> getDescription();

    String getContent();

    Optional<Integer> getWordCount();

    Optional<Boolean> getIsOpinion();

    Optional<String> getTwitterAccount();

    Optional<ArticleEntityAllLinks> getAllLinks();

    Optional<ArticleEntityAllDomainLinks> getAllDomainLinks();

    Optional<NlpDataEntity> getNlp();

    String getId();

    double getScore();

    Optional<Map<String, List<String>>> getCustomTags();

    Optional<AdditionalDomainInfoEntity> getAdditionalDomainInfo();
}
