package dev.kei.client;

import dev.kei.entity.LoanStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class FraudDetectionClient {
    private final RestTemplate fraudServiceRestTemplate;

    public FraudDetectionClient(RestTemplate fraudServiceRestTemplate) {
        this.fraudServiceRestTemplate = fraudServiceRestTemplate;
    }

    public LoanStatus getFraudDetection(Integer customerId){
        log.info("Calling fraud server for customer id: {}", customerId);
        var response = fraudServiceRestTemplate.exchange("/api/v1/frauds/check?customerId=" + customerId,
                HttpMethod.GET, null,
                LoanStatus.class).getBody();
        log.info("Fraud server response for loan status : {}", response);
        return  response;
    }
}
