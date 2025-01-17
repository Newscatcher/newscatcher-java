/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api;

import com.newscatcher.api.core.ClientOptions;
import com.newscatcher.api.core.Suppliers;
import com.newscatcher.api.resources.aggregation.AggregationClient;
import com.newscatcher.api.resources.authors.AuthorsClient;
import com.newscatcher.api.resources.latestheadlines.LatestheadlinesClient;
import com.newscatcher.api.resources.search.SearchClient;
import com.newscatcher.api.resources.searchlink.SearchLinkClient;
import com.newscatcher.api.resources.searchsimilar.SearchsimilarClient;
import com.newscatcher.api.resources.sources.SourcesClient;
import com.newscatcher.api.resources.subscription.SubscriptionClient;
import java.util.function.Supplier;

public class NewscatcherApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<SearchClient> searchClient;

    protected final Supplier<LatestheadlinesClient> latestheadlinesClient;

    protected final Supplier<AuthorsClient> authorsClient;

    protected final Supplier<SearchLinkClient> searchLinkClient;

    protected final Supplier<SearchsimilarClient> searchsimilarClient;

    protected final Supplier<SourcesClient> sourcesClient;

    protected final Supplier<AggregationClient> aggregationClient;

    protected final Supplier<SubscriptionClient> subscriptionClient;

    public NewscatcherApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.searchClient = Suppliers.memoize(() -> new SearchClient(clientOptions));
        this.latestheadlinesClient = Suppliers.memoize(() -> new LatestheadlinesClient(clientOptions));
        this.authorsClient = Suppliers.memoize(() -> new AuthorsClient(clientOptions));
        this.searchLinkClient = Suppliers.memoize(() -> new SearchLinkClient(clientOptions));
        this.searchsimilarClient = Suppliers.memoize(() -> new SearchsimilarClient(clientOptions));
        this.sourcesClient = Suppliers.memoize(() -> new SourcesClient(clientOptions));
        this.aggregationClient = Suppliers.memoize(() -> new AggregationClient(clientOptions));
        this.subscriptionClient = Suppliers.memoize(() -> new SubscriptionClient(clientOptions));
    }

    public SearchClient search() {
        return this.searchClient.get();
    }

    public LatestheadlinesClient latestheadlines() {
        return this.latestheadlinesClient.get();
    }

    public AuthorsClient authors() {
        return this.authorsClient.get();
    }

    public SearchLinkClient searchLink() {
        return this.searchLinkClient.get();
    }

    public SearchsimilarClient searchsimilar() {
        return this.searchsimilarClient.get();
    }

    public SourcesClient sources() {
        return this.sourcesClient.get();
    }

    public AggregationClient aggregation() {
        return this.aggregationClient.get();
    }

    public SubscriptionClient subscription() {
        return this.subscriptionClient.get();
    }

    public static NewscatcherApiClientBuilder builder() {
        return new NewscatcherApiClientBuilder();
    }
}
