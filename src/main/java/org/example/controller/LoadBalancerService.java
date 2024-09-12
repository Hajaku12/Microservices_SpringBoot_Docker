package org.example.controller;

import org.example.model.LogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LoadBalancerService {

    private static final Logger logger = LoggerFactory.getLogger(LoadBalancerService.class);

    private final List<String> logServiceUrls = List.of(
            "http://logservice1/logservice/submit",
            "http://logservice2/logservice/submit",
            "http://logservice3/logservice/submit"
    );

    private final AtomicInteger counter = new AtomicInteger(0);

    public String getNextLogServiceUrl() {
        int index = counter.getAndIncrement() % logServiceUrls.size();
        return logServiceUrls.get(index);
    }

    public List<LogEntry> sendMessageToLogService(String message) {
        RestTemplate restTemplate = new RestTemplate();
        String url = getNextLogServiceUrl();
        logger.info("Sending message to URL: {}", url);
        try {
            return restTemplate.postForObject(url, message, List.class);
        } catch (Exception e) {
            logger.error("Error sending message to URL: {}", url, e);
            throw e;
        }
    }
}