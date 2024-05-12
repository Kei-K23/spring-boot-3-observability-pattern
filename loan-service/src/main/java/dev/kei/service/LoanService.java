package dev.kei.service;

import dev.kei.client.FraudDetectionClient;
import dev.kei.dto.LoanCreateRequest;
import dev.kei.dto.LoanResponse;
import dev.kei.entity.Loan;
import dev.kei.entity.LoanStatus;
import dev.kei.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final FraudDetectionClient fraudDetectionClient;

    public LoanService(LoanRepository loanRepository, FraudDetectionClient fraudDetectionClient) {
        this.loanRepository = loanRepository;
        this.fraudDetectionClient = fraudDetectionClient;
    }

    public List<LoanResponse> findAllLoan() {
        return loanRepository.findAllLoan();
    }

    public String save(LoanCreateRequest loanCreateRequest) {
        try {
            LoanStatus loanStatus = fraudDetectionClient.getFraudDetection(loanCreateRequest.getCustomerId());
            if(loanStatus.equals(LoanStatus.APPROVED)) {
                Loan loan = Loan.builder()
                        .customerName(loanCreateRequest.getCustomerName())
                        .customerId(loanCreateRequest.getCustomerId())
                        .amount(loanCreateRequest.getAmount())
                        .loanStatus(loanStatus)
                        .build();
                loanRepository.save(loan);
                return  "Loan created successfully";
            } else {
                return  "Loan cannot created because user account is rejected";
            }
        } catch (Exception e) {
            return  "Something went wrong when saving the loan";
        }
    }
}
