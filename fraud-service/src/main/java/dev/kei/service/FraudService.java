package dev.kei.service;

import dev.kei.dto.FraudCreateRequest;
import dev.kei.dto.FraudResponse;
import dev.kei.entity.Fraud;
import dev.kei.entity.LoanStatus;
import dev.kei.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudService {
    private final FraudRepository fraudRepository;

    public FraudService(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    public List<FraudResponse> findAllFraud() {
        return fraudRepository.findAllFraud();
    }

    public String save(FraudCreateRequest fraudCreateRequest) {
        try {
            Fraud fraud = Fraud.builder()
                    .customerId(fraudCreateRequest.getCustomerId())
                    .build();
            fraudRepository.save(fraud);
            return "Fraud created successfully";
        } catch (Exception e) {
            return  "Something went wrong when saving fraud";
        }
    }

    public LoanStatus checkFraudByCustomerId(Integer customerId) {
        return fraudRepository.checkFraudByCustomerId(customerId) ? LoanStatus.REJECTED : LoanStatus.APPROVED;
    }
}
