# Newscatcher Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=https%3A%2F%2Fgithub.com%2FNewscatcher%2Fnewscatcher-java)
[![Maven Central](https://img.shields.io/maven-central/v/com.newscatcherapi/newscatcher-sdk)](https://central.sonatype.com/artifact/com.newscatcherapi/newscatcher-sdk)

The Newscatcher Java library provides convenient access to the Newscatcher APIs from Java.

## Table of Contents

- [Documentation](#documentation)
- [Requirements](#requirements)
- [Installation](#installation)
- [Reference](#reference)
- [Usage](#usage)
- [Error Handling](#error-handling)
- [Advanced Features](#advanced-features)
- [Example Requests](#example-requests)
- [Environments](#environments)
- [Base Url](#base-url)
- [Exception Handling](#exception-handling)
- [Advanced](#advanced)
  - [Custom Client](#custom-client)
  - [Retries](#retries)
  - [Timeouts](#timeouts)
  - [Custom Headers](#custom-headers)
  - [Access Raw Response Data](#access-raw-response-data)
- [Contributing](#contributing)
- [Release Notes](#release-notes)

## Documentation

API reference documentation is available [here](https://www.newscatcherapi.com/docs/news-api/api-reference/overview).

## Requirements

This library requires Java 8 or above.

## Installation

### Gradle

Add the dependency in your `build.gradle` file:

```groovy
dependencies {
  implementation 'com.newscatcherapi:newscatcher-sdk'
}
```

### Maven

Add the dependency in your `pom.xml` file:

```xml
<dependency>
  <groupId>com.newscatcherapi</groupId>
  <artifactId>newscatcher-sdk</artifactId>
  <version>2.1.0</version>
</dependency>
```

## Reference

A full reference for this library is available [here](https://github.com/Newscatcher/newscatcher-java/blob/HEAD/./reference.md).

## Usage

Instantiate and use the client with the following:

```java
package com.example.usage;

import com.newscatcher.api.NewscatcherApiClient;
import com.newscatcher.api.resources.search.requests.PostSearchRequest;

public class Example {
    public static void main(String[] args) {
        NewscatcherApiClient client = NewscatcherApiClient
            .builder()
            .apiKey("<value>")
            .build();

        client.search().post(
            PostSearchRequest
                .builder()
                .q("\"supply chain\" AND Amazon NOT China")
                .pageSize(1)
                .build()
        );
    }
}
```

## Error Handling

When the API responds with a non-success status code, the SDK throws an exception.

```java
import com.newscatcher.api.core.NewscatcherApiApiException;

try {
    client.search().post(...);
} catch (NewscatcherApiApiException e) {
    System.out.println(e.getMessage());
    System.out.println(e.statusCode());
    System.out.println(e.body());
}
```

The SDK provides specific error types for different cases:

```java
import com.newscatcher.api.errors.BadRequestError;
import com.newscatcher.api.errors.UnauthorizedError;
import com.newscatcher.api.errors.ForbiddenError;
import com.newscatcher.api.errors.UnprocessableEntityError;
import com.newscatcher.api.errors.RequestTimeoutError;
import com.newscatcher.api.errors.TooManyRequestsError;
import com.newscatcher.api.errors.InternalServerError;

try {
    client.search().post(...);
} catch (BadRequestError e) {
    // Handle 400 error - Bad request
    Error errorBody = e.body();
} catch (UnauthorizedError e) {
    // Handle 401 error - Authentication failed
} catch (ForbiddenError e) {
    // Handle 403 error - Server refuses action
} catch (UnprocessableEntityError e) {
    // Handle 422 error - Validation error
} catch (RequestTimeoutError e) {
    // Handle 408 error - Request timeout
} catch (TooManyRequestsError e) {
    // Handle 429 error - Rate limit exceeded
} catch (InternalServerError e) {
    // Handle 500 error - Internal server error
}
```

## Advanced Features

### Retries

The SDK automatically retries failed requests with exponential backoff. When a request fails with any of these status codes, the SDK retries up to 2 times:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

### Client Configuration

Configure the client using the builder pattern:

```java
NewscatcherApiClient client = NewscatcherApiClient.builder()
 .apiKey("YOUR_API_KEY")          // Required
 .timeout(60)                      // Optional: timeout in seconds
 .url("https://custom-url.com")    // Optional: override API URL
 .environment(Environment.DEFAULT) // Optional: use predefined environment
 .build();
```

Available configurations include:

- `apiKey(String)`: Sets authentication key (required).
- `timeout(int)`: Sets request timeout in seconds.
- `url(String)`: Overrides API base URL with a custom URL
- `environment(Environment)`: Uses a predefined environment configuration.

> **Note**: You must provide an API key when building the client. Otherwise, a RuntimeException will be thrown.

## Example Requests

### Latest Headlines

```java
import com.newscatcher.api.resources.latestheadlines.requests.LatestHeadlinesPostRequest;

client.latestHeadlines().post(LatestHeadlinesPostRequest.builder()
    .when("7d")
    .lang(Arrays.asList("en"))
    .build());
```

### Search by Author

```java
import com.newscatcher.api.resources.authors.requests.AuthorsPostRequest;

client.authors().post(AuthorsPostRequest.builder()
    .authorName("Jane Smith")
    .build());
```

## Environments

This SDK allows you to configure different environments for API requests.

```java
import com.newscatcher.api.NewscatcherApiClient;
import com.newscatcher.api.core.Environment;

NewscatcherApiClient client = NewscatcherApiClient
    .builder()
    .environment(Environment.Default)
    .build();
```

## Base Url

You can set a custom base URL when constructing the client.

```java
import com.newscatcher.api.NewscatcherApiClient;

NewscatcherApiClient client = NewscatcherApiClient
    .builder()
    .url("https://example.com")
    .build();
```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), an API exception will be thrown.

```java
import com.newscatcher.api.core.NewscatcherApiApiException;

try{
    client.search().post(...);
} catch (NewscatcherApiApiException e){
    // Do something with the API exception...
}
```

## Advanced

### Custom Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one.
However, you can pass your own client like so:

```java
import com.newscatcher.api.NewscatcherApiClient;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ...;

NewscatcherApiClient client = NewscatcherApiClient
    .builder()
    .httpClient(customClient)
    .build();
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retryable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2). Before defaulting to exponential backoff, the SDK will first attempt to respect
the `Retry-After` header (as either in seconds or as an HTTP date), and then the `X-RateLimit-Reset` header
(as a Unix timestamp in epoch seconds); failing both of those, it will fall back to exponential backoff.

A request is deemed retryable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` client option to configure this behavior.

```java
import com.newscatcher.api.NewscatcherApiClient;

NewscatcherApiClient client = NewscatcherApiClient
    .builder()
    .maxRetries(1)
    .build();
```

### Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout option at the client or request level.
```java
import com.newscatcher.api.NewscatcherApiClient;
import com.newscatcher.api.core.RequestOptions;

// Client level
NewscatcherApiClient client = NewscatcherApiClient
    .builder()
    .timeout(60)
    .build();

// Request level
client.search().post(
    ...,
    RequestOptions
        .builder()
        .timeout(60)
        .build()
);
```

### Custom Headers

The SDK allows you to add custom headers to requests. You can configure headers at the client level or at the request level.

```java
import com.newscatcher.api.NewscatcherApiClient;
import com.newscatcher.api.core.RequestOptions;

// Client level
NewscatcherApiClient client = NewscatcherApiClient
    .builder()
    .addHeader("X-Custom-Header", "custom-value")
    .addHeader("X-Request-Id", "abc-123")
    .build();
;

// Request level
client.search().post(
    ...,
    RequestOptions
        .builder()
        .addHeader("X-Request-Header", "request-value")
        .build()
);
```

### Access Raw Response Data

The SDK provides access to raw response data, including headers, through the `withRawResponse()` method.
The `withRawResponse()` method returns a raw client that wraps all responses with `body()` and `headers()` methods.
(A normal client's `response` is identical to a raw client's `response.body()`.)

```java
NewscatcherApiHttpResponse response = client.search().withRawResponse().post(...);

System.out.println(response.body());
System.out.println(response.headers().get("X-My-Header"));
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
## Release Notes

For release notes and changelog, visit our [GitHub releases page](https://github.com/Newscatcher/newscatcher-java/releases).


