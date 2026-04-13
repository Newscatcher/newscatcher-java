## 2.0.1 - 2026-04-13
* fix: replace @JsonProperty with @JsonIgnore on request getter methods
* Request classes across multiple endpoints were incorrectly annotating
* their getter methods with @JsonProperty, which caused Jackson to attempt
* to serialize these request objects as JSON bodies. Since these fields are
* sent as query parameters (not request body fields), they should be
* excluded from JSON serialization. Replacing @JsonProperty with @JsonIgnore
* on all getters corrects this behavior across GetAggregationCountRequest,
* GetAuthorsRequest, and GetBreakingNewsRequest.
* Additionally, RefactoryInterceptor now creates a fresh ExponentialBackoff
* instance per retry chain invocation instead of sharing a single instance,
* preventing potential state leakage between concurrent requests.
* Key changes:
* Replace @JsonProperty with @JsonIgnore on all getter methods in GetAggregationCountRequest, GetAuthorsRequest, and GetBreakingNewsRequest
* Create a new ExponentialBackoff instance per retryChain() call in RetryInterceptor instead of reusing a shared instance
* 🌿 Generated with Fern

