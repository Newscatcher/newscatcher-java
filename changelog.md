## 2.1.1 - 2026-04-30
* fix: use field-presence checks in union deserializers to prevent misclassification
* Previously, all union response deserializers attempted blind `convertValue`
* calls in sequence, catching `RuntimeException` to fall through to the next
* candidate type. This approach could silently misclassify a response payload
* as the wrong union variant when Jackson's lenient conversion succeeded on an
* incompatible type.
* The deserializers now inspect the raw `Map` keys first, requiring the
* presence of discriminating fields before attempting conversion. This makes
* variant selection deterministic and prevents incorrect deserialization of
* ambiguous payloads.
* Key changes:
* `GetAggregationCountResponse` and `PostAggregationCountResponse` deserializers now gate on `status`, `total_hits`, `page`, `total_pages`, and `page_size` keys before attempting conversion to `AggregationCountResponseDto` or `FailedAggregationCountResponseDto`
* `GetAuthorsResponse` and `PostAuthorsResponse` deserializers apply the same pagination-field guard before converting to `SearchResponseDto` or `FailedAuthorsResponseDto`
* `GetLatestHeadlinesResponse`, `PostLatestHeadlinesResponse`, `GetSearchResponse`, and `PostSearchResponse` deserializers additionally require `clusters_count` and `clusters` keys before attempting `ClusteredSearchResponseDto` conversion
* `AggregationCountResponseDtoAggregations` deserializer gates on `aggregation_count` key before attempting `AggregationItem` conversion
* `SourcesResponseDtoSourcesItem` deserializer gates on `domain_url` key before attempting `SourceInfo` conversion
* 🌿 Generated with Fern

## 2.1.0 - 2026-04-23
* ## [2.1.0] - 2025-07-10
### Added
* **`NlpDataEntity.getQwenEmbedding()`** — new `Optional<List<Float>>` field exposing a 1024-dimensional Qwen3-Embedding-0.6B vector for articles indexed from January 1, 2026 onward (requires the `v3_nlp_embeddings` plan).
### Changed
* **`ObjectMappers`** — now registers a custom `DoubleSerializer` that writes integer-valued doubles (e.g. `24000.0`) as plain integers (`24000`) in all serialized output.
### Fixed
* **`GetAggregationCountRequest`**, **`GetAuthorsRequest`**, and **`GetSourcesRequest`** — getter methods are now annotated with `@JsonIgnore` instead of `@JsonProperty`, preventing query-parameter-only fields from being incorrectly serialized into the JSON request body.
* **`RetryInterceptor`** — `ExponentialBackoff` is now instantiated fresh per retry cycle, eliminating shared mutable state across concurrent requests.

