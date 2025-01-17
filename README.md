# Newscatcher Java Library

[![Maven Central](https://img.shields.io/maven-central/v/com.newscatcherapi/newscatcher-sdk)](https://central.sonatype.com/artifact/com.newscatcherapi/newscatcher-sdk)
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The Newscatcher Java SDK lets you access the Newscatcher API from Java or Kotlin applications.

## Documentation

Find the complete API reference [here](https://www.newscatcherapi.com/docs/v3/api-reference).

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
import com.newscatcherapi.api.NewscatcherApiClient;
import com.newscatcherapi.api.resources.search.requests.SearchPostRequest;

NewscatcherApiClient client = NewscatcherApiClient.builder()
 .apiKey("YOUR_API_KEY")
 .build();

client.search().post(SearchPostRequest.builder()
 .q("renewable energy")
 .predefinedSources(Arrays.asList("top 50 US"))
 .lang(Arrays.asList("en"))
 .from(new Date("2024-01-01T00:00:00.000Z"))
 .to(new Date("2024-06-30T00:00:00.000Z"))
 .additionalDomainInfo(true)
 .isNewsDomain(true)
 .build());
```

## Exception Handling

The SDK throws a subclass of `NewscatcherApiApiException` when the API returns a non-success status code:

```java
import com.newscatcherapi.api.core.NewscatcherApiApiException;

try {
    client.search().post(...);
} catch (NewscatcherApiApiException e) {
    System.out.println(e.getMessage());
    System.out.println(e.statusCode());
    System.out.println(e.body());
}
```

Handle specific error cases using these exception types:

```java
import com.newscatcherapi.api.errors.BadRequestError;
import com.newscatcherapi.api.errors.UnauthorizedError;
import com.newscatcherapi.api.errors.ForbiddenError;
import com.newscatcherapi.api.errors.RequestTimeoutError;
import com.newscatcherapi.api.errors.TooManyRequestsError;
import com.newscatcherapi.api.errors.InternalServerError;

try {
    client.search().post(...);
} catch (BadRequestError e) {
    // Handle 400 error
} catch (UnauthorizedError e) {
    // Handle 401 error
} catch (ForbiddenError e) {
    // Handle 403 error
} catch (TooManyRequestsError e) {
    // Handle 429 error
} catch (InternalServerError e) {
    // Handle 500 error
}
```

## Advanced Features

### Retries

The SDK automatically retries failed requests with exponential backoff. When a request fails with any of these status codes, the SDK retries up to 2 times:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

### Timeout Configuration

Set a custom timeout when building the client:

```java
NewscatcherApiClient client = NewscatcherApiClient.builder()
 .apiKey("YOUR_API_KEY")
 .timeout(60) // timeout in seconds
 .build();
```

## Contributing

We generate this SDK programmatically, so we can't accept direct code contributions. Instead:

1. Open an issue to discuss your ideas with us first
2. If you want to show an implementation, create a PR as a proof of concept
3. We'll work with you to implement the changes in our generator

> **Note:** We always welcome contributions to this README!