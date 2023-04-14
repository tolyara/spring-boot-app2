package com.springboot.app2.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.client.erhlc.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories("com.springboot.app2.dao.elasticsearch")
public class ElasticSearchConfig /*extends AbstractElasticsearchConfiguration*/ {

//    @Value("${elasticsearch.url}")
//    public String elasticSearchUrl;

    @Value("${elasticsearch.host:localhost}")
    private String host;

    @Value("${elasticsearch.port:9200}")
    private int port;

    @Value("${elasticsearch.protocol:http}")
    private String protocol;

    @Bean
//    @Override
    public RestHighLevelClient client() {
//        final ClientConfiguration config = ClientConfiguration.builder()
//                .connectedTo(elasticSearchUrl).build();
//        return RestClients.create(config).rest();

//        return new RestHighLevelClient(RestClient.builder(new HttpHost(elasticSearchUrl)));

        return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, protocol)));
    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(elasticsearchClient());
//    }

}
