package com.jian.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients //使用Feign去访问其他的微服务
@EnableEurekaClient
@EnableHystrix //可以使用熔断器
@EnableCircuitBreaker//可以使用熔断器
@EnableDiscoveryClient
@EnableHystrixDashboard//开启Hystrix的监控
@SpringBootApplication//应用程序启动的注解
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }

    @Bean
    @LoadBalanced//springcloud的注解，能够开启负载均衡的能力。
    RestTemplate restTemplate(){

        return  new RestTemplate();
    }
}
