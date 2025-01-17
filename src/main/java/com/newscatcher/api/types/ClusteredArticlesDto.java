/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newscatcher.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ClusteredArticlesDto.Builder.class)
public final class ClusteredArticlesDto implements IClusteredArticlesDto {
    private final int clustersCount;

    private final List<ClusterEntity> clusters;

    private final Map<String, Object> additionalProperties;

    private ClusteredArticlesDto(
            int clustersCount, List<ClusterEntity> clusters, Map<String, Object> additionalProperties) {
        this.clustersCount = clustersCount;
        this.clusters = clusters;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The number of clusters in the search results.
     */
    @JsonProperty("clusters_count")
    @java.lang.Override
    public int getClustersCount() {
        return clustersCount;
    }

    /**
     * @return A list of clusters found in the search results.
     */
    @JsonProperty("clusters")
    @java.lang.Override
    public List<ClusterEntity> getClusters() {
        return clusters;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClusteredArticlesDto && equalTo((ClusteredArticlesDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ClusteredArticlesDto other) {
        return clustersCount == other.clustersCount && clusters.equals(other.clusters);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.clustersCount, this.clusters);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ClustersCountStage builder() {
        return new Builder();
    }

    public interface ClustersCountStage {
        _FinalStage clustersCount(int clustersCount);

        Builder from(ClusteredArticlesDto other);
    }

    public interface _FinalStage {
        ClusteredArticlesDto build();

        _FinalStage clusters(List<ClusterEntity> clusters);

        _FinalStage addClusters(ClusterEntity clusters);

        _FinalStage addAllClusters(List<ClusterEntity> clusters);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ClustersCountStage, _FinalStage {
        private int clustersCount;

        private List<ClusterEntity> clusters = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ClusteredArticlesDto other) {
            clustersCount(other.getClustersCount());
            clusters(other.getClusters());
            return this;
        }

        /**
         * <p>The number of clusters in the search results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("clusters_count")
        public _FinalStage clustersCount(int clustersCount) {
            this.clustersCount = clustersCount;
            return this;
        }

        /**
         * <p>A list of clusters found in the search results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllClusters(List<ClusterEntity> clusters) {
            this.clusters.addAll(clusters);
            return this;
        }

        /**
         * <p>A list of clusters found in the search results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addClusters(ClusterEntity clusters) {
            this.clusters.add(clusters);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "clusters", nulls = Nulls.SKIP)
        public _FinalStage clusters(List<ClusterEntity> clusters) {
            this.clusters.clear();
            this.clusters.addAll(clusters);
            return this;
        }

        @java.lang.Override
        public ClusteredArticlesDto build() {
            return new ClusteredArticlesDto(clustersCount, clusters, additionalProperties);
        }
    }
}