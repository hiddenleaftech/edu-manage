package com.hiddenleaf.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "com.hiddenleaf.searchjpa")
public class ElasticsearchConfiguration {

	@Bean
	public Client client() throws Exception {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
