package com.test.microservice.currencyexchangeservice;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CircuitBreakerController {

    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/simple-api")
    //@Retry(name = "default", fallbackMethod = "hardcodeResponse")
    @RateLimiter(name = "defualt")
    public String simpleApi(){
        logger.info("sample api call recieved");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-api", String.class);
        return forEntity.getBody();

    }

    public String hardcodeResponse(Exception ex){
        return "Hard code response";
    }
}
