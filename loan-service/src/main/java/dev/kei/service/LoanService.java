package dev.kei.service;

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

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<LoanResponse> findAllLoan() {
        return loanRepository.findAllLoan();
    }

    public String save(LoanCreateRequest loanCreateRequest) {
        try {
            LoanStatus loanStatus = LoanStatus.valueOf(loanCreateRequest.getLoanStatus());
            Loan loan = Loan.builder()
                    .customerName(loanCreateRequest.getCustomerName())
                    .customerId(loanCreateRequest.getCustomerId())
                    .amount(loanCreateRequest.getAmount())
                    .loanStatus(loanStatus)
                    .build();
            loanRepository.save(loan);
            return  "Loan created successfully";
        } catch (Exception e) {
            System.out.println(e);
            return  "Something went wrong when saving the loan";
        }
    }
}
