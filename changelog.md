## 2.0.1 - 2026-04-13
* fix: replace @JsonProperty with @JsonIgnore on request getter methods
* Request objects across multiple endpoints used @JsonProperty annotations
* on getter methods, which caused Jackson to inadvertently serialize request
* fields into the JSON body when these objects were used in contexts that
* triggered serialization. Replacing with @JsonIgnore ensures these request
* POJOs are not accidentally serialized as JSON bodies — parameters are
* instead passed as query/path parameters via the HTTP layer.
* Additionally, refactors RetryInterceptor to instantiate a fresh
* ExponentialBackoff per retry cycle rather than reusing a shared instance,
* preventing potential state leakage across concurrent or sequential requests.
* Key changes:
* Replace @JsonProperty with @JsonIgnore on all getter methods in GetAggregationCountRequest, GetAuthorsRequest, and GetBreakingNewsRequest
* Refactor RetryInterceptor to create a new ExponentialBackoff instance per retryChain() invocation instead of holding a shared instance
* 🌿 Generated with Fern

