package org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancerController {
    private static final Logger logger = LoggerFactory.getLogger(LoadBalancerController.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final String[] instances = {"http://logservice1:6000/log", "http://logservice2:6000/log", "http://logservice3:6000/log"};
    private int currentInstance = 0;

    @PostMapping("/submit")
    public String sendToLogService(@RequestBody String message) {
        String targetUrl = instances[currentInstance];
        logger.info("Sending message to URL: {}", targetUrl);
        try {
            String response = restTemplate.postForObject(targetUrl, message, String.class);
            currentInstance = (currentInstance + 1) % instances.length;
            return response;
        } catch (Exception e) {
            logger.error("Error sending message to URL: {}", targetUrl, e);
            throw e;
        }
    }
}