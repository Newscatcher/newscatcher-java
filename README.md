# Newscatcher Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern) [![Maven Central](https://img.shields.io/maven-central/v/com.newscatcherapi/newscatcher-sdk)](https://central.sonatype.com/artifact/com.newscatcherapi/newscatcher-sdk)

The Newscatcher Java library lets you access the Newscatcher API from Java or Kotlin.

## Documentation

Find the complete API reference [here](https://www.newscatcherapi.com/docs/v3/api-reference).

## Requirements

This library requires Java 8 or above.

## Installation

### Gradle

Add this dependency to your `build.gradle`:

```groovy
dependencies {
    implementation 'com.newscatcherapi:newscatcher-sdk:1.1.0'
}
```

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.newscatcherapi</groupId>
    <artifactId>newscatcher-sdk</artifactId>
    <version>1.1.0</version>
</dependency>
```

## Usage

Build and use the client like this:

```java
import com.newscatcher.api.NewscatcherApiClient;
import com.newscatcher.api.resources.search.requests.SearchPostRequest;
import java.util.Arrays;

NewscatcherApiClient client = NewscatcherApiClient.builder()
    .apiKey("YOUR_API_KEY")
    .build();

client.search().post(SearchPostRequest.builder()
    .q("renewable energy")
    .lang(Arrays.asList("en"))
    .build());
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

## Contributing

We generate this SDK programmatically, so we can't accept direct code contributions. Instead:

1. [Open an issue](https://github.com/Newscatcher/newscatcher-java/issues) to discuss your ideas with us first.
2. If you want to show an implementation, create a PR as a proof of concept.
3. We'll work with you to implement the changes in our generator.

On the other hand, contributions to the README are always very welcome!

## Release Notes

For release notes and changelog, visit our [GitHub releases page](https://github.com/Newscatcher/newscatcher-java/releases).
