# Reference
## Search
<details><summary><code>client.search.get() -> SearchGetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles based on specified criteria such as keyword, language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.search().get(
    SearchGetRequest
        .builder()
        .q("technology AND (Apple OR Microsoft) NOT Google")
        .searchIn("title_content, title_content_translated")
        .includeTranslationFields(true)
        .predefinedSources("top 100 US, top 5 GB")
        .from(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .to(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Business,Finance")
        .notTheme("Crime")
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .iabTags("Business,Events")
        .notIabTags("Agriculture,Metals")
        .customTags("Tag1,Tag2,Tag3")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**q:** `String` 

The keyword(s) to search for in articles. Query syntax supports logical operators (`AND`, `OR`, `NOT`) and wildcards:

- For an exact match, use double quotes. For example, `"technology news"`.
- Use `*` to search for any keyword.
- Use `+` to include and `-` to exclude specific words or phrases. 
  For example, `+Apple`, `-Google`.
- Use `AND`, `OR`, and `NOT` to refine search results. 
  For example, `technology AND (Apple OR Microsoft) NOT Google`.

For more details, see [Advanced querying](/docs/v3/documentation/guides-and-concepts/advanced-querying).
    
</dd>
</dl>

<dl>
<dd>

**searchIn:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Multiple countries with the number of top sources can be specified as a comma-separated string.

Examples: 
- `"top 100 US"`
- `"top 33 AT"`
- `"top 50 US, top 20 GB"`
- `"top 33 AT, top 50 IT"`
    
</dd>
</dl>

<dl>
<dd>

**sourceName:** `Optional<String>` 

Word or phrase to search within the source names. To specify multiple values, use a comma-separated string.

Example: `"sport, tech"`

**Note**: The search doesn't require an exact match and returns sources containing the specified terms in their names. You can use any word or phrase, like `"sport"` or `"new york times"`. For example, `"sport"` returns sources such as `"Motorsport"`, `"Dot Esport"`, and `"Tuttosport"`.
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` 

One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.

Examples:
- `"nytimes.com"`
- `"theguardian.com, finance.yahoo.com"`
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` 

The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string. 

Example: `"cnn.com, wsj.com"`
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string. 

Example: `"en, es"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

Example: `"fr, de"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

Example: `"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

Example:`"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` 

The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.

Example: `"John Doe, Jane Doe"`
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<OffsetDateTime>` 

The starting point in time to search from. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `7 day ago`, `today`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<OffsetDateTime>` 

The ending point in time to search up to. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `1 day ago`, `now`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<SearchGetRequestPublishedDatePrecision>` 

The precision of the published date. There are three types:
- `full`: The day and time of an article is correctly identified with the appropriate timezone.
- `timezone unknown`: The day and time of an article is correctly identified without timezone.
- `date`: Only the day is identified without an exact time.
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` — If true, the `from_` and `to_` parameters use article parse dates instead of published dates. Additionally, the `parse_date` variable is added to the output for each article object.
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<SearchGetRequestSortBy>` 

The sorting order of the results. Possible values are:
- `relevancy`: The most relevant results first.
- `date`: The most recently published results first.
- `rank`: The results from the highest-ranked sources first.
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` — If true, limits the search to sources ranked in the top 1 million online websites. If false, includes unranked sources which are assigned a rank of 999999.
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` — The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` — The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` — If true, only returns articles that were posted on the home page of a given news domain.
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` — If true, returns only opinion pieces. If false, excludes opinion-based articles and returns news only.
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` — If false, returns only articles that have publicly available complete content. Some publishers partially block content, so this setting ensures that only full articles are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<String>` 

The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.

Example: `"wsj.com/politics, wsj.com/tech"`
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

Example: `"https://aiindex.stanford.edu/report, https://www.stateof.ai"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

Example: `"who.int, nih.gov"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**additionalDomainInfo:** `Optional<Boolean>` 

If true, includes additional domain information in the response for each article:
- `is_news_domain`: Boolean indicating if the source is a news domain.
- `news_domain_type`: Type of news domain (e.g., `"Original Content"`).
- `news_type`: Category of news (e.g., `"News and Blogs"`).
    
</dd>
</dl>

<dl>
<dd>

**isNewsDomain:** `Optional<Boolean>` — If true, filters results to include only news domains.
    
</dd>
</dl>

<dl>
<dd>

**newsDomainType:** `Optional<SearchGetRequestNewsDomainType>` 

Filters results based on the news domain type. Possible values are:
- `Original Content`: Sources that produce their own content.
- `Aggregator`: Sources that collect content from various other sources.
- `Press Releases`: Sources primarily publishing press releases.
- `Republisher`: Sources that republish content from other sources.
- `Other`: Sources that don't fit into main categories.
    
</dd>
</dl>

<dl>
<dd>

**newsType:** `Optional<String>` 

Filters results based on the news type. Multiple types can be specified using a comma-separated string.

Example: `"General News Outlets,Tech News and Updates"`

For a complete list of available news types, see [Enumerated parameters > News type](/docs/v3/api-reference/overview/enumerated-parameters#news-type-news-type).
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` — The minimum number of words an article must contain. To be used for avoiding articles with small content.
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` — The maximum number of words an article can contain. To be used for avoiding articles with large content.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**clusteringEnabled:** `Optional<Boolean>` 

Determines whether to group similar articles into clusters. If true, the API returns clustered results.

To learn more, see [Clustering news articles](/docs/v3/documentation/guides-and-concepts/clustering-news-articles).
    
</dd>
</dl>

<dl>
<dd>

**clusteringVariable:** `Optional<SearchGetRequestClusteringVariable>` 

Specifies which part of the article to use for determining similarity when clustering.

Possible values are:
- `content`: Uses the full article content (default).
- `title`: Uses only the article title.
- `summary`: Uses the article summary.

To learn more, see [Clustering news articles](/docs/v3/documentation/guides-and-concepts/clustering-news-articles).
    
</dd>
</dl>

<dl>
<dd>

**clusteringThreshold:** `Optional<Float>` 

Sets the similarity threshold for grouping articles into clusters. A lower value creates more inclusive clusters, while a higher value requires greater similarity between articles.

Examples:
- `0.3`: Results in larger, more diverse clusters.
- `0.6`: Balances cluster size and article similarity (default).
- `0.9`: Creates smaller, tightly related clusters.

To learn more, see [Clustering news articles](/docs/v3/documentation/guides-and-concepts/clustering-news-articles).
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<String>` 

Filters articles based on their general topic, as determined by NLP analysis. To select multiple themes, use a comma-separated string.

Example: `"Finance, Tech"`

**Note**: The `theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).

Available options: `Business`, `Economics`, `Entertainment`, `Finance`, `Health`, `Politics`, `Science`, `Sports`, `Tech`, `Crime`, `Financial Crime`, `Lifestyle`, `Automotive`, `Travel`, `Weather`, `General`.
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 

Inverse of the `theme` parameter. Excludes articles based on their general topic, as determined by NLP analysis. To exclude multiple themes, use a comma-separated string. 

Example: `"Crime, Tech"`

**Note**: The `not_theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 

Filters articles that mention specific organization names, as identified by NLP analysis. To specify multiple organizations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Apple, Microsoft"`

**Note**: The `ORG_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 

Filters articles that mention specific person names, as identified by NLP analysis. To specify multiple names, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Elon Musk, Jeff Bezos"`

**Note**: The `PER_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 

Filters articles that mention specific location names, as identified by NLP analysis. To specify multiple locations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"California, New York"`

**Note**: The `LOC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 

Filters articles that mention other named entities not falling under person, organization, or location categories. Includes events, nationalities, products, works of art, and more. To specify multiple entities, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Bitcoin, Blockchain"`

**Note**: The `MISC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

Example: `"20000199, 20000209"`

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs. 

Example: `"20000205, 20000209"`

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<String>` 

Filters articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories, use a comma-separated string. 

Example: `"Business, Events"`

**Note**: The `iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<String>` 

Inverse of the `iab_tags` parameter. Excludes articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories to exclude, use a comma-separated string. 

Example: `"Agriculture, Metals"`

**Note**: The `not_iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2,Tag3`, where `taxonomy` is the taxonomy name and `Tag1,Tag2,Tag3` is a comma-separated list of tags.

Example: `custom_tags.industry="Manufacturing, Supply Chain, Logistics"`

To learn more, see the [Custom tags](/docs/v3/documentation/guides-and-concepts/custom-tags).
    
</dd>
</dl>

<dl>
<dd>

**excludeDuplicates:** `Optional<Boolean>` 

If true, excludes duplicate and highly similar articles from the search results. If false, returns all relevant articles, including duplicates. 

To learn more, see [Articles deduplication](/docs/v3/documentation/guides-and-concepts/articles-deduplication).
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.search.post(request) -> SearchPostResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles based on specified criteria such as keyword, language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.search().post(
    SearchPostRequest
        .builder()
        .q("renewable energy")
        .predefinedSources(
            PredefinedSources.of()
        )
        .lang(
            Lang.of()
        )
        .from(
            From.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-06-30T00:00:00Z"))
        )
        .additionalDomainInfo(true)
        .isNewsDomain(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**q:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**searchIn:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<PredefinedSources>` 
    
</dd>
</dl>

<dl>
<dd>

**sourceName:** `Optional<SourceName>` 
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<Sources>` 
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<NotSources>` 
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<Lang>` 
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<NotLang>` 
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<Countries>` 
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<NotCountries>` 
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<NotAuthorName>` 
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<From>` 
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<To>` 
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<PublishedDatePrecision>` 
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<SortBy>` 
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<ParentUrl>` 
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<AllLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<AllDomainLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**additionalDomainInfo:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isNewsDomain:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**newsDomainType:** `Optional<NewsDomainType>` 
    
</dd>
</dl>

<dl>
<dd>

**newsType:** `Optional<NewsType>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**clusteringEnabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**clusteringVariable:** `Optional<ClusteringVariable>` 
    
</dd>
</dl>

<dl>
<dd>

**clusteringThreshold:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<Theme>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<NotTheme>` 
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<IptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<NotIptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<IabTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<NotIabTags>` 
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<CustomTags>` 
    
</dd>
</dl>

<dl>
<dd>

**excludeDuplicates:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## LatestHeadlines
<details><summary><code>client.latestheadlines.get() -> LatestHeadlinesGetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the latest headlines for the specified time period. You can filter results by language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.latestheadlines().get(
    LatestHeadlinesGetRequest
        .builder()
        .predefinedSources("top 100 US, top 5 GB")
        .includeTranslationFields(true)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Business,Finance")
        .notTheme("Crime")
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .iabTags("Business,Events")
        .notIabTags("Agriculture,Metals")
        .customTags("Tag1,Tag2,Tag3")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**when:** `Optional<String>` 

The time period for which you want to get the latest headlines.

Format examples:
- `7d`: Last seven days
- `30d`: Last 30 days
- `1h`: Last hour
- `24h`: Last 24 hours
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` — If true, the `from_` and `to_` parameters use article parse dates instead of published dates. Additionally, the `parse_date` variable is added to the output for each article object.
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string. 

Example: `"en, es"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

Example: `"fr, de"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

Example: `"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

Example:`"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Multiple countries with the number of top sources can be specified as a comma-separated string.

Examples: 
- `"top 100 US"`
- `"top 33 AT"`
- `"top 50 US, top 20 GB"`
- `"top 33 AT, top 50 IT"`
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` 

One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.

Examples:
- `"nytimes.com"`
- `"theguardian.com, finance.yahoo.com"`
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` 

The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string. 

Example: `"cnn.com, wsj.com"`
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` 

The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.

Example: `"John Doe, Jane Doe"`
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` — If true, limits the search to sources ranked in the top 1 million online websites. If false, includes unranked sources which are assigned a rank of 999999.
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` — If true, only returns articles that were posted on the home page of a given news domain.
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` — If true, returns only opinion pieces. If false, excludes opinion-based articles and returns news only.
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` — If false, returns only articles that have publicly available complete content. Some publishers partially block content, so this setting ensures that only full articles are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<String>` 

The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.

Example: `"wsj.com/politics, wsj.com/tech"`
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

Example: `"https://aiindex.stanford.edu/report, https://www.stateof.ai"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

Example: `"who.int, nih.gov"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` — The minimum number of words an article must contain. To be used for avoiding articles with small content.
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` — The maximum number of words an article can contain. To be used for avoiding articles with large content.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**clusteringEnabled:** `Optional<Boolean>` 

Determines whether to group similar articles into clusters. If true, the API returns clustered results.

To learn more, see [Clustering news articles](/docs/v3/documentation/guides-and-concepts/clustering-news-articles).
    
</dd>
</dl>

<dl>
<dd>

**clusteringVariable:** `Optional<LatestHeadlinesGetRequestClusteringVariable>` 

Specifies which part of the article to use for determining similarity when clustering.

Possible values are:
- `content`: Uses the full article content (default).
- `title`: Uses only the article title.
- `summary`: Uses the article summary.

To learn more, see [Clustering news articles](/docs/v3/documentation/guides-and-concepts/clustering-news-articles).
    
</dd>
</dl>

<dl>
<dd>

**clusteringThreshold:** `Optional<Float>` 

Sets the similarity threshold for grouping articles into clusters. A lower value creates more inclusive clusters, while a higher value requires greater similarity between articles.

Examples:
- `0.3`: Results in larger, more diverse clusters.
- `0.6`: Balances cluster size and article similarity (default).
- `0.9`: Creates smaller, tightly related clusters.

To learn more, see [Clustering news articles](/docs/v3/documentation/guides-and-concepts/clustering-news-articles).
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<String>` 

Filters articles based on their general topic, as determined by NLP analysis. To select multiple themes, use a comma-separated string.

Example: `"Finance, Tech"`

**Note**: The `theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).

Available options: `Business`, `Economics`, `Entertainment`, `Finance`, `Health`, `Politics`, `Science`, `Sports`, `Tech`, `Crime`, `Financial Crime`, `Lifestyle`, `Automotive`, `Travel`, `Weather`, `General`.
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 

Inverse of the `theme` parameter. Excludes articles based on their general topic, as determined by NLP analysis. To exclude multiple themes, use a comma-separated string. 

Example: `"Crime, Tech"`

**Note**: The `not_theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 

Filters articles that mention specific organization names, as identified by NLP analysis. To specify multiple organizations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Apple, Microsoft"`

**Note**: The `ORG_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 

Filters articles that mention specific person names, as identified by NLP analysis. To specify multiple names, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Elon Musk, Jeff Bezos"`

**Note**: The `PER_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 

Filters articles that mention specific location names, as identified by NLP analysis. To specify multiple locations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"California, New York"`

**Note**: The `LOC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 

Filters articles that mention other named entities not falling under person, organization, or location categories. Includes events, nationalities, products, works of art, and more. To specify multiple entities, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Bitcoin, Blockchain"`

**Note**: The `MISC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

Example: `"20000199, 20000209"`

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs. 

Example: `"20000205, 20000209"`

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<String>` 

Filters articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories, use a comma-separated string. 

Example: `"Business, Events"`

**Note**: The `iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<String>` 

Inverse of the `iab_tags` parameter. Excludes articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories to exclude, use a comma-separated string. 

Example: `"Agriculture, Metals"`

**Note**: The `not_iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2,Tag3`, where `taxonomy` is the taxonomy name and `Tag1,Tag2,Tag3` is a comma-separated list of tags.

Example: `custom_tags.industry="Manufacturing, Supply Chain, Logistics"`

To learn more, see the [Custom tags](/docs/v3/documentation/guides-and-concepts/custom-tags).
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.latestheadlines.post(request) -> LatestHeadlinesPostResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the latest headlines for the specified time period. You can filter results by language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.latestheadlines().post(
    LatestHeadlinesPostRequest
        .builder()
        .lang(
            Lang.of("en")
        )
        .predefinedSources(
            PredefinedSources.of()
        )
        .isOpinion(false)
        .pageSize(10)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**when:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<Lang>` 
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<NotLang>` 
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<Countries>` 
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<NotCountries>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<PredefinedSources>` 
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<Sources>` 
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<NotSources>` 
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<NotAuthorName>` 
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<ParentUrl>` 
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<AllLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<AllDomainLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**clusteringEnabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**clusteringVariable:** `Optional<ClusteringVariable>` 
    
</dd>
</dl>

<dl>
<dd>

**clusteringThreshold:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<Theme>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<NotTheme>` 
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<IptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<NotIptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<IabTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<NotIabTags>` 
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<CustomTags>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Breaking News
<details><summary><code>client.breakingNews.breakingNewsGet() -> BreakingNewsResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves breaking news articles and sorts them based on specified criteria.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.breakingNews().breakingNewsGet(
    BreakingNewsGetRequest
        .builder()
        .topNArticles(5)
        .includeTranslationFields(true)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Business,Finance")
        .notTheme("Crime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sortBy:** `Optional<BreakingNewsGetRequestSortBy>` 

The sorting order of the results. Possible values are:
- `relevancy`: The most relevant results first.
- `date`: The most recently published results first.
- `rank`: The results from the highest-ranked sources first.
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` — If true, limits the search to sources ranked in the top 1 million online websites. If false, includes unranked sources which are assigned a rank of 999999.
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` — The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` — The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**topNArticles:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<String>` 

Filters articles based on their general topic, as determined by NLP analysis. To select multiple themes, use a comma-separated string.

Example: `"Finance, Tech"`

**Note**: The `theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).

Available options: `Business`, `Economics`, `Entertainment`, `Finance`, `Health`, `Politics`, `Science`, `Sports`, `Tech`, `Crime`, `Financial Crime`, `Lifestyle`, `Automotive`, `Travel`, `Weather`, `General`.
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 

Inverse of the `theme` parameter. Excludes articles based on their general topic, as determined by NLP analysis. To exclude multiple themes, use a comma-separated string. 

Example: `"Crime, Tech"`

**Note**: The `not_theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 

Filters articles that mention specific organization names, as identified by NLP analysis. To specify multiple organizations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Apple, Microsoft"`

**Note**: The `ORG_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 

Filters articles that mention specific person names, as identified by NLP analysis. To specify multiple names, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Elon Musk, Jeff Bezos"`

**Note**: The `PER_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 

Filters articles that mention specific location names, as identified by NLP analysis. To specify multiple locations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"California, New York"`

**Note**: The `LOC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 

Filters articles that mention other named entities not falling under person, organization, or location categories. Includes events, nationalities, products, works of art, and more. To specify multiple entities, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Bitcoin, Blockchain"`

**Note**: The `MISC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.breakingNews.breakingNewsPost(request) -> BreakingNewsResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves breaking news articles and sorts them based on specified criteria.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.breakingNews().breakingNewsPost(
    BreakingNewsPostRequest
        .builder()
        .sortBy(SortBy.RELEVANCY)
        .page(1)
        .pageSize(100)
        .includeNlpData(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sortBy:** `Optional<SortBy>` 
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**topNArticles:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<Theme>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<NotTheme>` 
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentientMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Authors
<details><summary><code>client.authors.get() -> AuthorsGetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles written by a specified author. You can filter results by language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.authors().get(
    AuthorsGetRequest
        .builder()
        .authorName("Jane Smith")
        .predefinedSources("top 100 US, top 5 GB")
        .from(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .to(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .includeTranslationFields(true)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Business,Finance")
        .notTheme("Crime")
        .nerName("Tesla")
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .iabTags("Business,Events")
        .notIabTags("Agriculture,Metals")
        .customTags("Tag1,Tag2,Tag3")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authorName:** `String` — The name of the author to search for. This parameter returns exact matches only.
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` 

The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.

Example: `"John Doe, Jane Doe"`
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Multiple countries with the number of top sources can be specified as a comma-separated string.

Examples: 
- `"top 100 US"`
- `"top 33 AT"`
- `"top 50 US, top 20 GB"`
- `"top 33 AT, top 50 IT"`
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` 

One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.

Examples:
- `"nytimes.com"`
- `"theguardian.com, finance.yahoo.com"`
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` 

The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string. 

Example: `"cnn.com, wsj.com"`
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string. 

Example: `"en, es"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

Example: `"fr, de"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

Example: `"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

Example:`"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<OffsetDateTime>` 

The starting point in time to search from. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `7 day ago`, `today`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<OffsetDateTime>` 

The ending point in time to search up to. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `1 day ago`, `now`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<AuthorsGetRequestPublishedDatePrecision>` 

The precision of the published date. There are three types:
- `full`: The day and time of an article is correctly identified with the appropriate timezone.
- `timezone unknown`: The day and time of an article is correctly identified without timezone.
- `date`: Only the day is identified without an exact time.
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` — If true, the `from_` and `to_` parameters use article parse dates instead of published dates. Additionally, the `parse_date` variable is added to the output for each article object.
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<AuthorsGetRequestSortBy>` 

The sorting order of the results. Possible values are:
- `relevancy`: The most relevant results first.
- `date`: The most recently published results first.
- `rank`: The results from the highest-ranked sources first.
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` — If true, limits the search to sources ranked in the top 1 million online websites. If false, includes unranked sources which are assigned a rank of 999999.
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` — The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` — The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` — If true, only returns articles that were posted on the home page of a given news domain.
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` — If true, returns only opinion pieces. If false, excludes opinion-based articles and returns news only.
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` — If false, returns only articles that have publicly available complete content. Some publishers partially block content, so this setting ensures that only full articles are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<String>` 

The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.

Example: `"wsj.com/politics, wsj.com/tech"`
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

Example: `"https://aiindex.stanford.edu/report, https://www.stateof.ai"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

Example: `"who.int, nih.gov"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` — The minimum number of words an article must contain. To be used for avoiding articles with small content.
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` — The maximum number of words an article can contain. To be used for avoiding articles with large content.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<String>` 

Filters articles based on their general topic, as determined by NLP analysis. To select multiple themes, use a comma-separated string.

Example: `"Finance, Tech"`

**Note**: The `theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).

Available options: `Business`, `Economics`, `Entertainment`, `Finance`, `Health`, `Politics`, `Science`, `Sports`, `Tech`, `Crime`, `Financial Crime`, `Lifestyle`, `Automotive`, `Travel`, `Weather`, `General`.
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 

Inverse of the `theme` parameter. Excludes articles based on their general topic, as determined by NLP analysis. To exclude multiple themes, use a comma-separated string. 

Example: `"Crime, Tech"`

**Note**: The `not_theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**nerName:** `Optional<String>` 

The name of person, organization, location, product or other named entity to search for. To specify multiple names use a comma-separated string. 

Example: `"Tesla, Amazon"`
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

Example: `"20000199, 20000209"`

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs. 

Example: `"20000205, 20000209"`

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<String>` 

Filters articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories, use a comma-separated string. 

Example: `"Business, Events"`

**Note**: The `iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<String>` 

Inverse of the `iab_tags` parameter. Excludes articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories to exclude, use a comma-separated string. 

Example: `"Agriculture, Metals"`

**Note**: The `not_iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2,Tag3`, where `taxonomy` is the taxonomy name and `Tag1,Tag2,Tag3` is a comma-separated list of tags.

Example: `custom_tags.industry="Manufacturing, Supply Chain, Logistics"`

To learn more, see the [Custom tags](/docs/v3/documentation/guides-and-concepts/custom-tags).
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.authors.post(request) -> AuthorsPostResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles by author. You can filter results by language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.authors().post(
    AuthorsPostRequest
        .builder()
        .authorName("Joanna Stern")
        .sources(
            Sources.of()
        )
        .lang(
            Lang.of("en")
        )
        .from(
            From.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-06-30T00:00:00Z"))
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authorName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<NotAuthorName>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<PredefinedSources>` 
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<Sources>` 
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<NotSources>` 
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<Lang>` 
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<NotLang>` 
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<Countries>` 
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<NotCountries>` 
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<From>` 
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<To>` 
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<PublishedDatePrecision>` 
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<SortBy>` 
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<ParentUrl>` 
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<AllLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<AllDomainLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<Theme>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<NotTheme>` 
    
</dd>
</dl>

<dl>
<dd>

**nerName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<IptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<NotIptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<IabTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<NotIabTags>` 
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<CustomTags>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## SearchLink
<details><summary><code>client.searchLink.searchUrlGet() -> SearchResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles based on specified links or IDs. You can filter results by date range.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.searchLink().searchUrlGet(
    SearchUrlGetRequest
        .builder()
        .from(
            From.of(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` 

The Newscatcher article ID (corresponds to the `_id` field in API response) or a list of article IDs to search for. To specify multiple IDs, use a comma-separated string. 

Example: `"1234567890abcdef, abcdef1234567890"`

**Caution**: You can use either the `links` or the `ids` parameter, but not both at the same time.
    
</dd>
</dl>

<dl>
<dd>

**links:** `Optional<String>` 

The article link or list of article links to search for. To specify multiple links, use a comma-separated string. 

Example: `"https://example.com/article1, https://example.com/article2"`

**Caution**: You can use either the `links` or the `ids` parameter, but not both at the same time.
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<From>` 
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<To>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.searchLink.searchUrlPost(request) -> SearchResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles using their ID(s) or link(s).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.searchLink().searchUrlPost(
    SearchUrlPostRequest
        .builder()
        .ids(
            Ids.of()
        )
        .links(
            Links.of()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<Ids>` 
    
</dd>
</dl>

<dl>
<dd>

**links:** `Optional<Links>` 
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<From>` 

The starting point in time to search from. Accepts date-time strings in ISO 8601 format and plain text strings. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `1 day ago`, `today`
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<To>` 

The ending point in time to search up to. Accepts date-time strings in ISO 8601 format and plain text strings. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `1 day ago`, `now`
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## SearchSimilar
<details><summary><code>client.searchsimilar.get() -> SearchSimilarGetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles similar to a specified query.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.searchsimilar().get(
    SearchSimilarGetRequest
        .builder()
        .q("technology AND (Apple OR Microsoft) NOT Google")
        .searchIn("title_content, title_content_translated")
        .includeTranslationFields(true)
        .similarDocumentsFields("title,summary")
        .predefinedSources("top 100 US, top 5 GB")
        .from(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .to(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Business,Finance")
        .notTheme("Crime")
        .nerName("Tesla")
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .customTags("Tag1,Tag2,Tag3")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**q:** `String` 

The keyword(s) to search for in articles. Query syntax supports logical operators (`AND`, `OR`, `NOT`) and wildcards:

- For an exact match, use double quotes. For example, `"technology news"`.
- Use `*` to search for any keyword.
- Use `+` to include and `-` to exclude specific words or phrases. 
  For example, `+Apple`, `-Google`.
- Use `AND`, `OR`, and `NOT` to refine search results. 
  For example, `technology AND (Apple OR Microsoft) NOT Google`.

For more details, see [Advanced querying](/docs/v3/documentation/guides-and-concepts/advanced-querying).
    
</dd>
</dl>

<dl>
<dd>

**searchIn:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeSimilarDocuments:** `Optional<Boolean>` — If true, includes similar documents in the response.
    
</dd>
</dl>

<dl>
<dd>

**similarDocumentsNumber:** `Optional<Integer>` — The number of similar documents to return.
    
</dd>
</dl>

<dl>
<dd>

**similarDocumentsFields:** `Optional<String>` — The fields to consider for finding similar documents.
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Multiple countries with the number of top sources can be specified as a comma-separated string.

Examples: 
- `"top 100 US"`
- `"top 33 AT"`
- `"top 50 US, top 20 GB"`
- `"top 33 AT, top 50 IT"`
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` 

One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.

Examples:
- `"nytimes.com"`
- `"theguardian.com, finance.yahoo.com"`
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` 

The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string. 

Example: `"cnn.com, wsj.com"`
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string. 

Example: `"en, es"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

Example: `"fr, de"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

Example: `"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

Example:`"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<OffsetDateTime>` 

The starting point in time to search from. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `7 day ago`, `today`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<OffsetDateTime>` 

The ending point in time to search up to. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `1 day ago`, `now`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` — If true, the `from_` and `to_` parameters use article parse dates instead of published dates. Additionally, the `parse_date` variable is added to the output for each article object.
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<SearchSimilarGetRequestPublishedDatePrecision>` 

The precision of the published date. There are three types:
- `full`: The day and time of an article is correctly identified with the appropriate timezone.
- `timezone unknown`: The day and time of an article is correctly identified without timezone.
- `date`: Only the day is identified without an exact time.
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<SearchSimilarGetRequestSortBy>` 

The sorting order of the results. Possible values are:
- `relevancy`: The most relevant results first.
- `date`: The most recently published results first.
- `rank`: The results from the highest-ranked sources first.
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` — If true, limits the search to sources ranked in the top 1 million online websites. If false, includes unranked sources which are assigned a rank of 999999.
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` — The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` — The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` — If true, only returns articles that were posted on the home page of a given news domain.
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` — If true, returns only opinion pieces. If false, excludes opinion-based articles and returns news only.
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` — If false, returns only articles that have publicly available complete content. Some publishers partially block content, so this setting ensures that only full articles are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<String>` 

The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.

Example: `"wsj.com/politics, wsj.com/tech"`
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

Example: `"https://aiindex.stanford.edu/report, https://www.stateof.ai"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

Example: `"who.int, nih.gov"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` — The minimum number of words an article must contain. To be used for avoiding articles with small content.
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` — The maximum number of words an article can contain. To be used for avoiding articles with large content.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<String>` 

Filters articles based on their general topic, as determined by NLP analysis. To select multiple themes, use a comma-separated string.

Example: `"Finance, Tech"`

**Note**: The `theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).

Available options: `Business`, `Economics`, `Entertainment`, `Finance`, `Health`, `Politics`, `Science`, `Sports`, `Tech`, `Crime`, `Financial Crime`, `Lifestyle`, `Automotive`, `Travel`, `Weather`, `General`.
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 

Inverse of the `theme` parameter. Excludes articles based on their general topic, as determined by NLP analysis. To exclude multiple themes, use a comma-separated string. 

Example: `"Crime, Tech"`

**Note**: The `not_theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**nerName:** `Optional<String>` 

The name of person, organization, location, product or other named entity to search for. To specify multiple names use a comma-separated string. 

Example: `"Tesla, Amazon"`
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

Example: `"20000199, 20000209"`

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs. 

Example: `"20000205, 20000209"`

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2,Tag3`, where `taxonomy` is the taxonomy name and `Tag1,Tag2,Tag3` is a comma-separated list of tags.

Example: `custom_tags.industry="Manufacturing, Supply Chain, Logistics"`

To learn more, see the [Custom tags](/docs/v3/documentation/guides-and-concepts/custom-tags).
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.searchsimilar.post(request) -> SearchSimilarPostResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles similar to the specified query. You can filter results by language, country, source, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.searchsimilar().post(
    SearchSimilarPostRequest
        .builder()
        .q("artificial intelligence")
        .includeSimilarDocuments(true)
        .similarDocumentsNumber(5)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**q:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**searchIn:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**includeTranslationFields:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeSimilarDocuments:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**similarDocumentsNumber:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**similarDocumentsFields:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<PredefinedSources>` 
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<Sources>` 
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<NotSources>` 
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<Lang>` 
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<NotLang>` 
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<Countries>` 
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<NotCountries>` 
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<From>` 
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<To>` 
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<PublishedDatePrecision>` 
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<SortBy>` 
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<ParentUrl>` 
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<AllLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<AllDomainLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<Theme>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<NotTheme>` 
    
</dd>
</dl>

<dl>
<dd>

**nerName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<IptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<NotIptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<CustomTags>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sources
<details><summary><code>client.sources.get() -> SourcesResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a list of sources based on specified criteria such as language, country, rank, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sources().get(
    SourcesGetRequest
        .builder()
        .predefinedSources("top 100 US, top 5 GB")
        .sourceUrl("bbc.com")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string. 

Example: `"en, es"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

Example: `"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Multiple countries with the number of top sources can be specified as a comma-separated string.

Examples: 
- `"top 100 US"`
- `"top 33 AT"`
- `"top 50 US, top 20 GB"`
- `"top 33 AT, top 50 IT"`
    
</dd>
</dl>

<dl>
<dd>

**sourceName:** `Optional<String>` 

Word or phrase to search within the source names. To specify multiple values, use a comma-separated string.

Example: `"sport, tech"`

**Note**: The search doesn't require an exact match and returns sources containing the specified terms in their names. You can use any word or phrase, like `"sport"` or `"new york times"`. For example, `"sport"` returns sources such as `"Motorsport"`, `"Dot Esport"`, and `"Tuttosport"`.
    
</dd>
</dl>

<dl>
<dd>

**sourceUrl:** `Optional<String>` 

The domain(s) of the news publication to search for. 

**Caution**:  When specifying the `source_url` parameter, 
you can only use `include_additional_info` as an extra parameter.
    
</dd>
</dl>

<dl>
<dd>

**includeAdditionalInfo:** `Optional<Boolean>` 

If true, returns the following additional datapoints about each news source:
- `nb_articles_for_7d`: The number of articles published by the source in the last week.
- `country`: Source country of origin.
- `rank`: SEO rank.
- `is_news_domain`: Boolean indicating if the source is a news domain.
- `news_domain_type`: Type of news domain (e.g., "Original Content").
- `news_type`: Category of news (e.g., "General News Outlets").
    
</dd>
</dl>

<dl>
<dd>

**isNewsDomain:** `Optional<Boolean>` — If true, filters results to include only news domains.
    
</dd>
</dl>

<dl>
<dd>

**newsDomainType:** `Optional<SourcesGetRequestNewsDomainType>` 

Filters results based on the news domain type. Possible values are:
- `Original Content`: Sources that produce their own content.
- `Aggregator`: Sources that collect content from various other sources.
- `Press Releases`: Sources primarily publishing press releases.
- `Republisher`: Sources that republish content from other sources.
- `Other`: Sources that don't fit into main categories.
    
</dd>
</dl>

<dl>
<dd>

**newsType:** `Optional<String>` 

Filters results based on the news type. Multiple types can be specified using a comma-separated string.

Example: `"General News Outlets,Tech News and Updates"`

For a complete list of available news types, see [Enumerated parameters > News type](/docs/v3/api-reference/overview/enumerated-parameters#news-type-news-type).
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` — The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` — The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sources.post(request) -> SourcesResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the list of sources available in the database. You can filter the sources by language, country, and more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sources().post(
    SourcesPostRequest
        .builder()
        .predefinedSources(
            PredefinedSources.of()
        )
        .includeAdditionalInfo(true)
        .isNewsDomain(true)
        .newsDomainType(NewsDomainType.ORIGINAL_CONTENT)
        .newsType(
            NewsType.of("General News Outlets")
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**lang:** `Optional<Lang>` 
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<Countries>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<PredefinedSources>` 
    
</dd>
</dl>

<dl>
<dd>

**sourceName:** `Optional<SourceName>` 
    
</dd>
</dl>

<dl>
<dd>

**sourceUrl:** `Optional<SourceUrl>` 
    
</dd>
</dl>

<dl>
<dd>

**includeAdditionalInfo:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isNewsDomain:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**newsDomainType:** `Optional<NewsDomainType>` 
    
</dd>
</dl>

<dl>
<dd>

**newsType:** `Optional<NewsType>` 
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Aggregation
<details><summary><code>client.aggregation.get() -> AggregationGetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the count of articles aggregated by day or hour based on various search criteria, such as keyword, language, country, and source.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.aggregation().get(
    AggregationGetRequest
        .builder()
        .q("technology AND (Apple OR Microsoft) NOT Google")
        .searchIn("title_content, title_content_translated")
        .predefinedSources("top 100 US, top 5 GB")
        .from(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .to(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Business,Finance")
        .notTheme("Crime")
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**q:** `String` 

The keyword(s) to search for in articles. Query syntax supports logical operators (`AND`, `OR`, `NOT`) and wildcards:

- For an exact match, use double quotes. For example, `"technology news"`.
- Use `*` to search for any keyword.
- Use `+` to include and `-` to exclude specific words or phrases. 
  For example, `+Apple`, `-Google`.
- Use `AND`, `OR`, and `NOT` to refine search results. 
  For example, `technology AND (Apple OR Microsoft) NOT Google`.

For more details, see [Advanced querying](/docs/v3/documentation/guides-and-concepts/advanced-querying).
    
</dd>
</dl>

<dl>
<dd>

**aggregationBy:** `Optional<AggregationBy>` 
    
</dd>
</dl>

<dl>
<dd>

**searchIn:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Multiple countries with the number of top sources can be specified as a comma-separated string.

Examples: 
- `"top 100 US"`
- `"top 33 AT"`
- `"top 50 US, top 20 GB"`
- `"top 33 AT, top 50 IT"`
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` 

One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.

Examples:
- `"nytimes.com"`
- `"theguardian.com, finance.yahoo.com"`
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` 

The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string. 

Example: `"cnn.com, wsj.com"`
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string. 

Example: `"en, es"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

Example: `"fr, de"`

To learn more, see [Enumerated parameters > Language](/docs/v3/api-reference/overview/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

Example: `"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

Example:`"US, CA"`

To learn more, see [Enumerated parameters > Country](/docs/v3/api-reference/overview/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` 

The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.

Example: `"John Doe, Jane Doe"`
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<OffsetDateTime>` 

The starting point in time to search from. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `7 day ago`, `today`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<OffsetDateTime>` 

The ending point in time to search up to. Accepts date-time strings in ISO 8601 format and plain text. The default time zone is UTC. 

Formats with examples:
- YYYY-mm-ddTHH:MM:SS: `2024-07-01T00:00:00`
- YYYY-MM-dd: `2024-07-01`
- YYYY/mm/dd HH:MM:SS: `2024/07/01 00:00:00`
- YYYY/mm/dd: `2024/07/01`
- English phrases: `1 day ago`, `now`

**Note**: By default, applied to the publication date of the article. To use the article's parse date instead, set the `by_parse_date` parameter to `true`.
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<AggregationGetRequestPublishedDatePrecision>` 

The precision of the published date. There are three types:
- `full`: The day and time of an article is correctly identified with the appropriate timezone.
- `timezone unknown`: The day and time of an article is correctly identified without timezone.
- `date`: Only the day is identified without an exact time.
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` — If true, the `from_` and `to_` parameters use article parse dates instead of published dates. Additionally, the `parse_date` variable is added to the output for each article object.
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<AggregationGetRequestSortBy>` 

The sorting order of the results. Possible values are:
- `relevancy`: The most relevant results first.
- `date`: The most recently published results first.
- `rank`: The results from the highest-ranked sources first.
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` — If true, limits the search to sources ranked in the top 1 million online websites. If false, includes unranked sources which are assigned a rank of 999999.
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` — The lowest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` — The highest boundary of the rank of a news website to filter by. A lower rank indicates a more popular source.
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` — If true, only returns articles that were posted on the home page of a given news domain.
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` — If true, returns only opinion pieces. If false, excludes opinion-based articles and returns news only.
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` — If false, returns only articles that have publicly available complete content. Some publishers partially block content, so this setting ensures that only full articles are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<String>` 

The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.

Example: `"wsj.com/politics, wsj.com/tech"`
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

Example: `"https://aiindex.stanford.edu/report, https://www.stateof.ai"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

Example: `"who.int, nih.gov"`

For more details, see [Search by URL](/docs/v3/documentation/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` — The minimum number of words an article must contain. To be used for avoiding articles with small content.
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` — The maximum number of words an article can contain. To be used for avoiding articles with large content.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 

The page number to scroll through the results. Use for pagination, as a single API response can return up to 1,000 articles. 

For details, see [How to paginate large datasets](https://www.newscatcherapi.com/docs/v3/documentation/how-to/paginate-large-datasets).
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of articles to return per page.
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<String>` 

Filters articles based on their general topic, as determined by NLP analysis. To select multiple themes, use a comma-separated string.

Example: `"Finance, Tech"`

**Note**: The `theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).

Available options: `Business`, `Economics`, `Entertainment`, `Finance`, `Health`, `Politics`, `Science`, `Sports`, `Tech`, `Crime`, `Financial Crime`, `Lifestyle`, `Automotive`, `Travel`, `Weather`, `General`.
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 

Inverse of the `theme` parameter. Excludes articles based on their general topic, as determined by NLP analysis. To exclude multiple themes, use a comma-separated string. 

Example: `"Crime, Tech"`

**Note**: The `not_theme` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 

Filters articles that mention specific organization names, as identified by NLP analysis. To specify multiple organizations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Apple, Microsoft"`

**Note**: The `ORG_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 

Filters articles that mention specific person names, as identified by NLP analysis. To specify multiple names, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Elon Musk, Jeff Bezos"`

**Note**: The `PER_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 

Filters articles that mention specific location names, as identified by NLP analysis. To specify multiple locations, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"California, New York"`

**Note**: The `LOC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 

Filters articles that mention other named entities not falling under person, organization, or location categories. Includes events, nationalities, products, works of art, and more. To specify multiple entities, use a comma-separated string. To search named entities in translations, combine with the translation options of the `search_in` parameter (e.g., `title_content_translated`).

Example: `"Bitcoin, Blockchain"`

**Note**: The `MISC_entity_name` parameter is only available if NLP is included in your subscription plan.

To learn more, see [Search by entity](/docs/v3/documentation/how-to/search-by-entity).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their titles.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `title_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 

Filters articles based on the minimum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_min` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 

Filters articles based on the maximum sentiment score of their content.

Range is `-1.0` to `1.0`, where:
- Negative values indicate negative sentiment.
- Positive values indicate positive sentiment.
- Values close to 0 indicate neutral sentiment.

**Note**: The `content_sentiment_max` parameter is only available if NLP is included in your subscription plan.

To learn more, see [NLP features](/docs/v3/documentation/guides-and-concepts/nlp-features).
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

Example: `"20000199, 20000209"`

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs. 

Example: `"20000205, 20000209"`

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` — If true, returns only articles/sources that comply with the publisher's robots.txt rules. If false, returns only articles/sources that do not comply with robots.txt rules. If omitted, returns all articles/sources regardless of compliance status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aggregation.post(request) -> AggregationPostResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the count of articles aggregated by day or hour based on various search criteria, such as keyword, language, country, and source.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.aggregation().post(
    AggregationPostRequest
        .builder()
        .q("renewable energy")
        .aggregationBy(AggregationBy.DAY)
        .predefinedSources(
            PredefinedSources.of("top 50 US")
        )
        .from(
            From.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-06-30T00:00:00Z"))
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**q:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**aggregationBy:** `Optional<AggregationBy>` 
    
</dd>
</dl>

<dl>
<dd>

**searchIn:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<PredefinedSources>` 
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<Sources>` 
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<NotSources>` 
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<Lang>` 
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<NotLang>` 
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<Countries>` 
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<NotCountries>` 
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<NotAuthorName>` 
    
</dd>
</dl>

<dl>
<dd>

**from:** `Optional<From>` 
    
</dd>
</dl>

<dl>
<dd>

**to:** `Optional<To>` 
    
</dd>
</dl>

<dl>
<dd>

**publishedDatePrecision:** `Optional<PublishedDatePrecision>` 
    
</dd>
</dl>

<dl>
<dd>

**byParseDate:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**sortBy:** `Optional<SortBy>` 
    
</dd>
</dl>

<dl>
<dd>

**rankedOnly:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**fromRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**toRank:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**isHeadline:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isOpinion:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**isPaidContent:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**parentUrl:** `Optional<ParentUrl>` 
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<AllLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<AllDomainLinks>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMin:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**wordCountMax:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**includeNlpData:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasNlp:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**theme:** `Optional<Theme>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<NotTheme>` 
    
</dd>
</dl>

<dl>
<dd>

**orgEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**perEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**locEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**miscEntityName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**titleSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMin:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**contentSentimentMax:** `Optional<Float>` 
    
</dd>
</dl>

<dl>
<dd>

**iptcTags:** `Optional<IptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<NotIptcTags>` 
    
</dd>
</dl>

<dl>
<dd>

**robotsCompliant:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Subscription
<details><summary><code>client.subscription.get() -> SubscriptionResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves information about your subscription plan.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscription().get();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscription.post() -> SubscriptionResponseDto</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves information about your subscription plan.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscription().post();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>
