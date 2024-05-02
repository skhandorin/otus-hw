package com.skhandorin.otus.hw2.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@Slf4j
@RestController
public class HealthController {

    public static final String HEALTH = "/health";
    public static final String HEALTH2 = "/health/";

    @GetMapping({HEALTH, HEALTH2})
    <T> String getHealth(HttpEntity<T> request) {
        log.info("Called HEALTH. Headers: {}", request.getHeaders());
        return "{\"status\": \"OK\"}\n";
    }

    @SneakyThrows
    @GetMapping({"", "/"})
    <T> String getRoot(HttpEntity<T> request) {
        String hostname = InetAddress.getLocalHost().getHostName();
        String address = InetAddress.getLocalHost().getHostAddress();
        log.info("Called ROOT. {} [{}]", hostname, address);
        return "Hello from " + hostname + " [" + address + "]\n";
    }

}
