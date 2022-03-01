package com.test.microservice.currencyconversionservice;

import com.test.microservice.currencyconversionservice.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange") //if url is removed then feign will do load balance from
                                         // the registered services with eureka
public interface CurrnecyExchangeProxy {


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to);

    }
