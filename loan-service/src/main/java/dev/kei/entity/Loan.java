package dev.kei.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {
    private Long id;
    private String loanId;
    private Integer customerId;
    private LoanStatus loanStatus;
    private Integer amount;
    private String customerName;
}
