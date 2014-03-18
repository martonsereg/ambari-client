package com.sequenceiq.sample

import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient

class AmbariClient {

    def ambari = new RESTClient( 'http://sandbox.hortonworks.com:8180/api/v1/' )
    def slurper = new JsonSlurper()

    AmbariClient(){
        ambari.headers['Authorization'] = 'Basic '+"admin:admin".getBytes('iso-8859-1').encodeBase64()
    }

    public Object getClusters(){
        return slurper.parseText(ambari.get( path : 'clusters' ).data.text)
    }

    public Object getCluster(String name){
        return slurper.parseText(ambari.get( path : 'clusters/' + name ).data.text)
    }
}
