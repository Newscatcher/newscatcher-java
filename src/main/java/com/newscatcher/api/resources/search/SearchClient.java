/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.resources.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.newscatcher.api.core.ClientOptions;
import com.newscatcher.api.core.MediaTypes;
import com.newscatcher.api.core.NewscatcherApiApiException;
import com.newscatcher.api.core.NewscatcherApiException;
import com.newscatcher.api.core.ObjectMappers;
import com.newscatcher.api.core.RequestOptions;
import com.newscatcher.api.errors.BadRequestError;
import com.newscatcher.api.errors.ForbiddenError;
import com.newscatcher.api.errors.InternalServerError;
import com.newscatcher.api.errors.RequestTimeoutError;
import com.newscatcher.api.errors.TooManyRequestsError;
import com.newscatcher.api.errors.UnauthorizedError;
import com.newscatcher.api.errors.UnprocessableEntityError;
import com.newscatcher.api.resources.search.requests.SearchGetRequest;
import com.newscatcher.api.resources.search.requests.SearchPostRequest;
import com.newscatcher.api.resources.search.types.SearchGetResponse;
import com.newscatcher.api.resources.search.types.SearchPostResponse;
import com.newscatcher.api.types.Error;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SearchClient {
    protected final ClientOptions clientOptions;

    public SearchClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Searches for articles based on specified criteria such as keyword, language, country, source, and more.
     */
    public SearchGetResponse get(SearchGetRequest request) {
        return get(request, null);
    }

    /**
     * Searches for articles based on specified criteria such as keyword, language, country, source, and more.
     */
    public SearchGetResponse get(SearchGetRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/search");
        httpUrl.addQueryParameter("q", request.getQ());
        if (request.getSearchIn().isPresent()) {
            httpUrl.addQueryParameter("search_in", request.getSearchIn().get());
        }
        if (request.getPredefinedSources().isPresent()) {
            httpUrl.addQueryParameter(
                    "predefined_sources", request.getPredefinedSources().get());
        }
        if (request.getSourceName().isPresent()) {
            httpUrl.addQueryParameter("source_name", request.getSourceName().get());
        }
        if (request.getSources().isPresent()) {
            httpUrl.addQueryParameter("sources", request.getSources().get());
        }
        if (request.getNotSources().isPresent()) {
            httpUrl.addQueryParameter("not_sources", request.getNotSources().get());
        }
        if (request.getLang().isPresent()) {
            httpUrl.addQueryParameter("lang", request.getLang().get());
        }
        if (request.getNotLang().isPresent()) {
            httpUrl.addQueryParameter("not_lang", request.getNotLang().get());
        }
        if (request.getCountries().isPresent()) {
            httpUrl.addQueryParameter("countries", request.getCountries().get());
        }
        if (request.getNotCountries().isPresent()) {
            httpUrl.addQueryParameter("not_countries", request.getNotCountries().get());
        }
        if (request.getNotAuthorName().isPresent()) {
            httpUrl.addQueryParameter(
                    "not_author_name", request.getNotAuthorName().get());
        }
        if (request.getFrom().isPresent()) {
            httpUrl.addQueryParameter("from_", request.getFrom().get().toString());
        }
        if (request.getTo().isPresent()) {
            httpUrl.addQueryParameter("to_", request.getTo().get().toString());
        }
        if (request.getPublishedDatePrecision().isPresent()) {
            httpUrl.addQueryParameter(
                    "published_date_precision",
                    request.getPublishedDatePrecision().get().toString());
        }
        if (request.getByParseDate().isPresent()) {
            httpUrl.addQueryParameter(
                    "by_parse_date", request.getByParseDate().get().toString());
        }
        if (request.getSortBy().isPresent()) {
            httpUrl.addQueryParameter("sort_by", request.getSortBy().get().toString());
        }
        if (request.getRankedOnly().isPresent()) {
            httpUrl.addQueryParameter(
                    "ranked_only", request.getRankedOnly().get().toString());
        }
        if (request.getFromRank().isPresent()) {
            httpUrl.addQueryParameter("from_rank", request.getFromRank().get().toString());
        }
        if (request.getToRank().isPresent()) {
            httpUrl.addQueryParameter("to_rank", request.getToRank().get().toString());
        }
        if (request.getIsHeadline().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_headline", request.getIsHeadline().get().toString());
        }
        if (request.getIsOpinion().isPresent()) {
            httpUrl.addQueryParameter("is_opinion", request.getIsOpinion().get().toString());
        }
        if (request.getIsPaidContent().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_paid_content", request.getIsPaidContent().get().toString());
        }
        if (request.getParentUrl().isPresent()) {
            httpUrl.addQueryParameter("parent_url", request.getParentUrl().get());
        }
        if (request.getAllLinks().isPresent()) {
            httpUrl.addQueryParameter("all_links", request.getAllLinks().get());
        }
        if (request.getAllDomainLinks().isPresent()) {
            httpUrl.addQueryParameter(
                    "all_domain_links", request.getAllDomainLinks().get());
        }
        if (request.getAdditionalDomainInfo().isPresent()) {
            httpUrl.addQueryParameter(
                    "additional_domain_info",
                    request.getAdditionalDomainInfo().get().toString());
        }
        if (request.getIsNewsDomain().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_news_domain", request.getIsNewsDomain().get().toString());
        }
        if (request.getNewsDomainType().isPresent()) {
            httpUrl.addQueryParameter(
                    "news_domain_type", request.getNewsDomainType().get().toString());
        }
        if (request.getNewsType().isPresent()) {
            httpUrl.addQueryParameter("news_type", request.getNewsType().get());
        }
        if (request.getWordCountMin().isPresent()) {
            httpUrl.addQueryParameter(
                    "word_count_min", request.getWordCountMin().get().toString());
        }
        if (request.getWordCountMax().isPresent()) {
            httpUrl.addQueryParameter(
                    "word_count_max", request.getWordCountMax().get().toString());
        }
        if (request.getPage().isPresent()) {
            httpUrl.addQueryParameter("page", request.getPage().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getClusteringEnabled().isPresent()) {
            httpUrl.addQueryParameter(
                    "clustering_enabled", request.getClusteringEnabled().get().toString());
        }
        if (request.getClusteringVariable().isPresent()) {
            httpUrl.addQueryParameter(
                    "clustering_variable", request.getClusteringVariable().get().toString());
        }
        if (request.getClusteringThreshold().isPresent()) {
            httpUrl.addQueryParameter(
                    "clustering_threshold",
                    request.getClusteringThreshold().get().toString());
        }
        if (request.getIncludeNlpData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_nlp_data", request.getIncludeNlpData().get().toString());
        }
        if (request.getHasNlp().isPresent()) {
            httpUrl.addQueryParameter("has_nlp", request.getHasNlp().get().toString());
        }
        if (request.getTheme().isPresent()) {
            httpUrl.addQueryParameter("theme", request.getTheme().get());
        }
        if (request.getNotTheme().isPresent()) {
            httpUrl.addQueryParameter("not_theme", request.getNotTheme().get());
        }
        if (request.getOrgEntityName().isPresent()) {
            httpUrl.addQueryParameter(
                    "ORG_entity_name", request.getOrgEntityName().get());
        }
        if (request.getPerEntityName().isPresent()) {
            httpUrl.addQueryParameter(
                    "PER_entity_name", request.getPerEntityName().get());
        }
        if (request.getLocEntityName().isPresent()) {
            httpUrl.addQueryParameter(
                    "LOC_entity_name", request.getLocEntityName().get());
        }
        if (request.getMiscEntityName().isPresent()) {
            httpUrl.addQueryParameter(
                    "MISC_entity_name", request.getMiscEntityName().get());
        }
        if (request.getTitleSentimentMin().isPresent()) {
            httpUrl.addQueryParameter(
                    "title_sentiment_min", request.getTitleSentimentMin().get().toString());
        }
        if (request.getTitleSentimentMax().isPresent()) {
            httpUrl.addQueryParameter(
                    "title_sentiment_max", request.getTitleSentimentMax().get().toString());
        }
        if (request.getContentSentimentMin().isPresent()) {
            httpUrl.addQueryParameter(
                    "content_sentiment_min",
                    request.getContentSentimentMin().get().toString());
        }
        if (request.getContentSentimentMax().isPresent()) {
            httpUrl.addQueryParameter(
                    "content_sentiment_max",
                    request.getContentSentimentMax().get().toString());
        }
        if (request.getIptcTags().isPresent()) {
            httpUrl.addQueryParameter("iptc_tags", request.getIptcTags().get());
        }
        if (request.getNotIptcTags().isPresent()) {
            httpUrl.addQueryParameter("not_iptc_tags", request.getNotIptcTags().get());
        }
        if (request.getIabTags().isPresent()) {
            httpUrl.addQueryParameter("iab_tags", request.getIabTags().get());
        }
        if (request.getNotIabTags().isPresent()) {
            httpUrl.addQueryParameter("not_iab_tags", request.getNotIabTags().get());
        }
        if (request.getCustomTags().isPresent()) {
            httpUrl.addQueryParameter("custom_tags", request.getCustomTags().get());
        }
        if (request.getExcludeDuplicates().isPresent()) {
            httpUrl.addQueryParameter(
                    "exclude_duplicates", request.getExcludeDuplicates().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchGetResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 403:
                        throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 408:
                        throw new RequestTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 422:
                        throw new UnprocessableEntityError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, String.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new NewscatcherApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new NewscatcherApiException("Network error executing HTTP request", e);
        }
    }

    /**
     * Searches for articles based on specified criteria such as keyword, language, country, source, and more.
     */
    public SearchPostResponse post(SearchPostRequest request) {
        return post(request, null);
    }

    /**
     * Searches for articles based on specified criteria such as keyword, language, country, source, and more.
     */
    public SearchPostResponse post(SearchPostRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/search")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new NewscatcherApiException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchPostResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 403:
                        throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 408:
                        throw new RequestTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 422:
                        throw new UnprocessableEntityError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, String.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new NewscatcherApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new NewscatcherApiException("Network error executing HTTP request", e);
        }
    }
}
