/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.types;

import java.util.List;

public interface IClusteredArticlesDto {
    int getClustersCount();

    List<ClusterEntity> getClusters();
}
