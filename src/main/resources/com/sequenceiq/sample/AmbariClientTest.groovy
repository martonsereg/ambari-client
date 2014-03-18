package com.sequenceiq.sample

import static org.junit.Assert.*

import org.junit.Test

class AmbariClientTest {

    def underTest = new AmbariClient()

    @Test
    void testGetClusters() {
        def resp = underTest.getClusters()
        println resp.items[0].Clusters.cluster_name
        println resp.items[0].Clusters.version
    }

    @Test
    void testGetCluster() {
        def resp = underTest.getCluster('sandbox')
        println resp.Clusters.cluster_name
        println resp.Clusters.version
    }
}
