package com.odcode.eureka.controller;


import com.odcode.client.FraudCheckResponse;
import com.odcode.eureka.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudCheckHistoryController {
    private FraudCheckService fraudCheckService;

    public FraudCheckHistoryController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable  Integer customerId){
        boolean isFraudster = fraudCheckService.isFraudster(customerId);
        log.info("Fraud check for customer {}",customerId);
        return new FraudCheckResponse(isFraudster);
    }
}
