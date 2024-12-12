package com.oreilly.demo.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oreilly.demo.services.AstroInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder, @Value("${astro.baseUrl}") String baseUrl){
        return builder.rootUri(baseUrl).build();
    }

    @Bean
    public AstroInterface astroInterface(@Value("${astro.baseUrl}") String baseUrl){
        WebClient webClient = WebClient.create(baseUrl);
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(AstroInterface.class);
    }
}
