package com.vistra.netflix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    class ServiceInstanceRestController {

        @Autowired
        private Environment environment;

        @RequestMapping("/test/")
        public List<String> serviceInstancesByApplicationName() {

            final String port = environment.getProperty("local.server.port");
            final String id = environment.getProperty("eureka.instance.instance-id");


            return Arrays.asList("I am on", port, "my instance id is", id);
        }
    }

}
