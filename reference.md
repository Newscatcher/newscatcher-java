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

Searches for articles based on specified criteria such as keywords, language, country, source, and more.
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
        .q("\"supply chain\" AND Amazon NOT China")
        .searchIn("title_content, title_content_translated")
        .includeTranslationFields(true)
        .predefinedSources("top 50 US, top 20 GB")
        .sourceName("sport,tech")
        .sources("nytimes.com,finance.yahoo.com")
        .notSources("cnn.com,wsj.com")
        .lang("en,es")
        .notLang("fr,de")
        .countries("US,CA")
        .notCountries("UK,FR")
        .notAuthorName("John Doe, Jane Doe")
        .from(
            From.of(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .publishedDatePrecision("full")
        .byParseDate(true)
        .rankedOnly(true)
        .fromRank(100)
        .toRank(100)
        .isHeadline(true)
        .isOpinion(true)
        .isPaidContent(false)
        .parentUrl("wsj.com/politics,wsj.com/tech")
        .allLinks("https://aiindex.stanford.edu/report,https://www.stateof.ai")
        .allDomainLinks("who.int,nih.gov")
        .allLinksText("Nvidia,Tesla")
        .additionalDomainInfo(true)
        .isNewsDomain(true)
        .newsType("General News Outlets,Tech News and Updates")
        .wordCountMin(300)
        .wordCountMax(1000)
        .page(2)
        .pageSize(50)
        .clusteringEnabled(true)
        .clusteringThreshold(0.6f)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Finance,Tech")
        .notTheme("Crime,Sports")
        .orgEntityName("\"Apple Inc\" OR Microsoft")
        .perEntityName("\"Elon Musk\" OR \"Jeff Bezos\"")
        .locEntityName("\"San Francisco\" OR \"New York City\"")
        .miscEntityName("AWS OR \"Microsoft Azure\"")
        .titleSentimentMin(-0.5f)
        .titleSentimentMax(0.5f)
        .contentSentimentMin(-0.5f)
        .contentSentimentMax(0.5f)
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .iabTags("Business,Events")
        .notIabTags("Agriculture,Metals")
        .customTags("Tag1,Tag2")
        .excludeDuplicates(true)
        .robotsCompliant(true)
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

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). 

Multiple countries with the number of top sources can be specified as a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**sourceName:** `Optional<String>` 

Word or phrase to search within the source names. To specify multiple values, use a comma-separated string.

**Note**: The search doesn't require an exact match and returns sources containing the specified terms in their names. You can use any word or phrase, like `"sport"` or `"new york times"`. For example, `"sport"` returns sources such as `"Motorsport"`, `"Dot Esport"`, and `"Tuttosport"`.
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` — One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` — The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string.

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` — The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.
    
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

**publishedDatePrecision:** `Optional<String>` 
    
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

**parentUrl:** `Optional<String>` — The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allLinksText:** `Optional<String>` 

The text content of links mentioned in the article. Searches for links where the anchor text contains the specified terms. For multiple terms, use a comma-separated string.

**Note**: When this parameter is used, the response includes the `all_links_data` field with detailed link information.

To learn more, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
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

**newsType:** `Optional<String>` 

Filters results based on the news type. Multiple types can be specified using a comma-separated string.

For a complete list of available news types, see [Enumerated parameters > News type](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#news-type-news-type).
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs.

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<String>` 

Filters articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories, use a comma-separated string.

**Note**: The `iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<String>` 

Inverse of the `iab_tags` parameter. Excludes articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories to exclude, use a comma-separated string.

**Note**: The `not_iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2`, where `taxonomy` is the taxonomy name and `Tag1,Tag2` is a comma-separated list of tag names.

Example: `custom_tags.industry="Manufacturing,Logistics"`

To learn more, see the [Custom tags](https://www.newscatcherapi.com/docs/news-api/guides-and-concepts/custom-tags).
    
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

<details><summary><code>client.search.post(request) -> SearchPostResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for articles based on specified criteria such as keywords, language, country, source, and more.
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
        .q("\"supply chain\" AND Amazon NOT China")
        .pageSize(1)
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

**publishedDatePrecision:** `Optional<String>` 
    
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

**allLinksText:** `Optional<AllLinksText>` 
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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
<details><summary><code>client.latestHeadlines.latestHeadlinesGet() -> LatestHeadlinesGetResponse</code></summary>
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
client.latestHeadlines().latestHeadlinesGet(
    LatestHeadlinesGetRequest
        .builder()
        .when("7d")
        .byParseDate(true)
        .lang("en,es")
        .notLang("fr,de")
        .countries("US,CA")
        .notCountries("UK,FR")
        .predefinedSources("top 50 US, top 20 GB")
        .sources("nytimes.com,finance.yahoo.com")
        .notSources("cnn.com,wsj.com")
        .notAuthorName("John Doe, Jane Doe")
        .rankedOnly(true)
        .isHeadline(true)
        .isOpinion(true)
        .isPaidContent(false)
        .parentUrl("wsj.com/politics,wsj.com/tech")
        .allLinks("https://aiindex.stanford.edu/report,https://www.stateof.ai")
        .allDomainLinks("who.int,nih.gov")
        .allLinksText("Nvidia,Tesla")
        .wordCountMin(300)
        .wordCountMax(1000)
        .page(2)
        .pageSize(50)
        .clusteringEnabled(true)
        .clusteringThreshold(0.6f)
        .includeTranslationFields(true)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Finance,Tech")
        .notTheme("Crime,Sports")
        .orgEntityName("\"Apple Inc\" OR Microsoft")
        .perEntityName("\"Elon Musk\" OR \"Jeff Bezos\"")
        .locEntityName("\"San Francisco\" OR \"New York City\"")
        .miscEntityName("AWS OR \"Microsoft Azure\"")
        .titleSentimentMin(-0.5f)
        .titleSentimentMax(0.5f)
        .contentSentimentMin(-0.5f)
        .contentSentimentMax(0.5f)
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .iabTags("Business,Events")
        .notIabTags("Agriculture,Metals")
        .customTags("Tag1,Tag2")
        .robotsCompliant(true)
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

**sortBy:** `Optional<SortBy>` 
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string.

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). 

Multiple countries with the number of top sources can be specified as a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` — One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` — The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` — The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.
    
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

**parentUrl:** `Optional<String>` — The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allLinksText:** `Optional<String>` 

The text content of links mentioned in the article. Searches for links where the anchor text contains the specified terms. For multiple terms, use a comma-separated string.

**Note**: When this parameter is used, the response includes the `all_links_data` field with detailed link information.

To learn more, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs.

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<String>` 

Filters articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories, use a comma-separated string.

**Note**: The `iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<String>` 

Inverse of the `iab_tags` parameter. Excludes articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories to exclude, use a comma-separated string.

**Note**: The `not_iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2`, where `taxonomy` is the taxonomy name and `Tag1,Tag2` is a comma-separated list of tag names.

Example: `custom_tags.industry="Manufacturing,Logistics"`

To learn more, see the [Custom tags](https://www.newscatcherapi.com/docs/news-api/guides-and-concepts/custom-tags).
    
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

<details><summary><code>client.latestHeadlines.latestHeadlinesPost(request) -> LatestHeadlinesPostResponse</code></summary>
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
client.latestHeadlines().latestHeadlinesPost(
    LatestHeadlinesPostRequest
        .builder()
        .when("7d")
        .pageSize(1)
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

**allLinksText:** `Optional<AllLinksText>` 
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

## BreakingNews
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
        .rankedOnly(true)
        .fromRank(100)
        .toRank(100)
        .page(2)
        .pageSize(50)
        .topNArticles(5)
        .includeTranslationFields(true)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Finance,Tech")
        .notTheme("Crime,Sports")
        .orgEntityName("\"Apple Inc\" OR Microsoft")
        .perEntityName("\"Elon Musk\" OR \"Jeff Bezos\"")
        .locEntityName("\"San Francisco\" OR \"New York City\"")
        .miscEntityName("AWS OR \"Microsoft Azure\"")
        .titleSentimentMin(-0.5f)
        .titleSentimentMax(0.5f)
        .contentSentimentMin(-0.5f)
        .contentSentimentMax(0.5f)
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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
        .rankedOnly(true)
        .topNArticles(1)
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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
        .notAuthorName("John Doe, Jane Doe")
        .predefinedSources("top 50 US, top 20 GB")
        .sources("nytimes.com,finance.yahoo.com")
        .notSources("cnn.com,wsj.com")
        .lang("en,es")
        .notLang("fr,de")
        .countries("US,CA")
        .notCountries("UK,FR")
        .from(
            From.of(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .publishedDatePrecision("full")
        .byParseDate(true)
        .rankedOnly(true)
        .fromRank(100)
        .toRank(100)
        .isHeadline(true)
        .isOpinion(true)
        .isPaidContent(false)
        .parentUrl("wsj.com/politics,wsj.com/tech")
        .allLinks("https://aiindex.stanford.edu/report,https://www.stateof.ai")
        .allDomainLinks("who.int,nih.gov")
        .allLinksText("Nvidia,Tesla")
        .wordCountMin(300)
        .wordCountMax(1000)
        .page(2)
        .pageSize(50)
        .includeTranslationFields(true)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Finance,Tech")
        .notTheme("Crime,Sports")
        .nerName("Tesla,Amazon")
        .titleSentimentMin(-0.5f)
        .titleSentimentMax(0.5f)
        .contentSentimentMin(-0.5f)
        .contentSentimentMax(0.5f)
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .iabTags("Business,Events")
        .notIabTags("Agriculture,Metals")
        .customTags("Tag1,Tag2")
        .robotsCompliant(true)
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

**notAuthorName:** `Optional<String>` — The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). 

Multiple countries with the number of top sources can be specified as a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` — One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` — The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string.

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
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

**publishedDatePrecision:** `Optional<String>` 
    
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

**parentUrl:** `Optional<String>` — The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allLinksText:** `Optional<String>` 

The text content of links mentioned in the article. Searches for links where the anchor text contains the specified terms. For multiple terms, use a comma-separated string.

**Note**: When this parameter is used, the response includes the `all_links_data` field with detailed link information.

To learn more, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs.

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**iabTags:** `Optional<String>` 

Filters articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories, use a comma-separated string.

**Note**: The `iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**notIabTags:** `Optional<String>` 

Inverse of the `iab_tags` parameter. Excludes articles based on Interactive Advertising Bureau (IAB) content categories. These tags provide a standardized taxonomy for digital advertising content categorization. To specify multiple IAB categories to exclude, use a comma-separated string.

**Note**: The `not_iab_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see the [IAB Content taxonomy](https://iabtechlab.com/standards/content-taxonomy/).
    
</dd>
</dl>

<dl>
<dd>

**customTags:** `Optional<String>` 

Filters articles based on provided taxonomy that is tailored to your specific needs and is accessible only with your API key. To specify tags, use the following pattern: 

- `custom_tags.taxonomy=Tag1,Tag2`, where `taxonomy` is the taxonomy name and `Tag1,Tag2` is a comma-separated list of tag names.

Example: `custom_tags.industry="Manufacturing,Logistics"`

To learn more, see the [Custom tags](https://www.newscatcherapi.com/docs/news-api/guides-and-concepts/custom-tags).
    
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
        .authorName("David Muir")
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

**publishedDatePrecision:** `Optional<String>` 
    
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

**allLinksText:** `Optional<AllLinksText>` 
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

## SearchByLink
<details><summary><code>client.searchByLink.searchByLinkGet() -> SearchResponseDto</code></summary>
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
client.searchByLink().searchByLinkGet(
    SearchByLinkGetRequest
        .builder()
        .ids("5f8d0d55b6e45e00179c6e7e")
        .links("https://nytimes.com/article1,https://bbc.com/article2")
        .from(
            From.of(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .page(2)
        .pageSize(50)
        .robotsCompliant(true)
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

**Caution**: You can use either the `links` or the `ids` parameter, but not both at the same time.
    
</dd>
</dl>

<dl>
<dd>

**links:** `Optional<String>` 

The article link or list of article links to search for. To specify multiple links, use a comma-separated string.

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

<details><summary><code>client.searchByLink.searchByLinkPost(request) -> SearchResponseDto</code></summary>
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
client.searchByLink().searchByLinkPost(
    SearchByLinkPostRequest
        .builder()
        .links(
            Links.of("https://www.reuters.com/business/energy/oil-prices-up-after-israeli-attacks-oversupply-caps-gains-2025-09-10/")
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
        .lang("en,es")
        .countries("US,CA")
        .predefinedSources("top 50 US, top 20 GB")
        .sourceName("sport,tech")
        .sourceUrl("bbc.com")
        .includeAdditionalInfo(true)
        .isNewsDomain(true)
        .newsType("General News Outlets,Tech News and Updates")
        .fromRank(100)
        .toRank(100)
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

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). 

Multiple countries with the number of top sources can be specified as a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**sourceName:** `Optional<String>` 

Word or phrase to search within the source names. To specify multiple values, use a comma-separated string.

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

**newsType:** `Optional<String>` 

Filters results based on the news type. Multiple types can be specified using a comma-separated string.

For a complete list of available news types, see [Enumerated parameters > News type](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#news-type-news-type).
    
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
            PredefinedSources.of("top 10 US")
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
<details><summary><code>client.aggregation.countGet() -> AggregationCountGetResponse</code></summary>
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
client.aggregation().countGet(
    AggregationCountGetRequest
        .builder()
        .q("\"supply chain\" AND Amazon NOT China")
        .searchIn("title_content, title_content_translated")
        .predefinedSources("top 50 US, top 20 GB")
        .sources("nytimes.com,finance.yahoo.com")
        .notSources("cnn.com,wsj.com")
        .lang("en,es")
        .notLang("fr,de")
        .countries("US,CA")
        .notCountries("UK,FR")
        .notAuthorName("John Doe, Jane Doe")
        .from(
            From.of(OffsetDateTime.parse("2024-07-01T00:00:00Z"))
        )
        .to(
            To.of(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        )
        .publishedDatePrecision("full")
        .byParseDate(true)
        .rankedOnly(true)
        .fromRank(100)
        .toRank(100)
        .isHeadline(true)
        .isOpinion(true)
        .isPaidContent(false)
        .parentUrl("wsj.com/politics,wsj.com/tech")
        .allLinks("https://aiindex.stanford.edu/report,https://www.stateof.ai")
        .allDomainLinks("who.int,nih.gov")
        .allLinksText("Nvidia,Tesla")
        .wordCountMin(300)
        .wordCountMax(1000)
        .page(2)
        .pageSize(50)
        .includeNlpData(true)
        .hasNlp(true)
        .theme("Finance,Tech")
        .notTheme("Crime,Sports")
        .orgEntityName("\"Apple Inc\" OR Microsoft")
        .perEntityName("\"Elon Musk\" OR \"Jeff Bezos\"")
        .locEntityName("\"San Francisco\" OR \"New York City\"")
        .miscEntityName("AWS OR \"Microsoft Azure\"")
        .titleSentimentMin(-0.5f)
        .titleSentimentMax(0.5f)
        .contentSentimentMin(-0.5f)
        .contentSentimentMax(0.5f)
        .iptcTags("20000199,20000209")
        .notIptcTags("20000205,20000209")
        .robotsCompliant(true)
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

**predefinedSources:** `Optional<String>` 

Predefined top news sources per country. 

Format: start with the word `top`, followed by the number of desired sources, and then the two-letter country code [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). 

Multiple countries with the number of top sources can be specified as a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**sources:** `Optional<String>` — One or more news sources to narrow down the search. The format must be a domain URL. Subdomains, such as `finance.yahoo.com`, are also acceptable.To specify multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**notSources:** `Optional<String>` — The news sources to exclude from the search. To exclude multiple sources, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**lang:** `Optional<String>` 

The language(s) of the search. The only accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To select multiple languages, use a comma-separated string.

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**notLang:** `Optional<String>` 

The language(s) to exclude from the search. The accepted format is the two-letter [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) code. To exclude multiple languages, use a comma-separated string. 

To learn more, see [Enumerated parameters > Language](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#language-lang-and-not-lang).
    
</dd>
</dl>

<dl>
<dd>

**countries:** `Optional<String>` 

The countries where the news publisher is located. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To select multiple countries, use a comma-separated string.

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notCountries:** `Optional<String>` 

The publisher location countries to exclude from the search. The accepted format is the two-letter [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code. To exclude multiple countries, use a comma-separated string. 

To learn more, see [Enumerated parameters > Country](https://www.newscatcherapi.com/docs/news-api/api-reference/enumerated-parameters#country-country-and-not-country).
    
</dd>
</dl>

<dl>
<dd>

**notAuthorName:** `Optional<String>` — The list of author names to exclude from your search. To exclude articles by specific authors, use a comma-separated string.
    
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

**publishedDatePrecision:** `Optional<String>` 
    
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

**parentUrl:** `Optional<String>` — The categorical URL(s) to filter your search. To filter your search by multiple categorical URLs, use a comma-separated string.
    
</dd>
</dl>

<dl>
<dd>

**allLinks:** `Optional<String>` 

The complete URL(s) mentioned in the article. For multiple URLs, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allDomainLinks:** `Optional<String>` 

The domain(s) mentioned in the article. For multiple domains, use a comma-separated string.

For more details, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
</dd>
</dl>

<dl>
<dd>

**allLinksText:** `Optional<String>` 

The text content of links mentioned in the article. Searches for links where the anchor text contains the specified terms. For multiple terms, use a comma-separated string.

**Note**: When this parameter is used, the response includes the `all_links_data` field with detailed link information.

To learn more, see [Search by URL](https://www.newscatcherapi.com/docs/news-api/how-to/search-by-url).
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

**iptcTags:** `Optional<String>` 

Filters articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags, use a comma-separated string of tag IDs. 

**Note**: The `iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
</dd>
</dl>

<dl>
<dd>

**notIptcTags:** `Optional<String>` 

Inverse of the `iptc_tags` parameter. Excludes articles based on International Press Telecommunications Council (IPTC) media topic tags. To specify multiple IPTC tags to exclude, use a comma-separated string of tag IDs.

**Note**: The `not_iptc_tags` parameter is only available in the `v3_nlp_iptc_tags` subscription plan.

To learn more, see [IPTC Media Topic NewsCodes](https://www.iptc.org/std/NewsCodes/treeview/mediatopic/mediatopic-en-GB.html).
    
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

<details><summary><code>client.aggregation.countPost(request) -> AggregationCountPostResponse</code></summary>
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
client.aggregation().countPost(
    AggregationCountPostRequest
        .builder()
        .q("\"supply chain\" AND Amazon NOT China")
        .aggregationBy(AggregationBy.DAY)
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

**publishedDatePrecision:** `Optional<String>` 
    
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

**allLinksText:** `Optional<AllLinksText>` 
    
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

**theme:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**notTheme:** `Optional<String>` 
    
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

