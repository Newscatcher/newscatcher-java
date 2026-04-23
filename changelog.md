## 2.1.0 - 2026-04-23
* ## [2.1.0] - 2025-07-10
### Added
* **`NlpDataEntity.getQwenEmbedding()`** — new `Optional<List<Float>>` field exposing a 1024-dimensional Qwen3-Embedding-0.6B vector for articles indexed from January 1, 2026 onward (requires the `v3_nlp_embeddings` plan).
### Changed
* **`ObjectMappers`** — now registers a custom `DoubleSerializer` that writes integer-valued doubles (e.g. `24000.0`) as plain integers (`24000`) in all serialized output.
### Fixed
* **`GetAggregationCountRequest`**, **`GetAuthorsRequest`**, and **`GetSourcesRequest`** — getter methods are now annotated with `@JsonIgnore` instead of `@JsonProperty`, preventing query-parameter-only fields from being incorrectly serialized into the JSON request body.
* **`RetryInterceptor`** — `ExponentialBackoff` is now instantiated fresh per retry cycle, eliminating shared mutable state across concurrent requests.

