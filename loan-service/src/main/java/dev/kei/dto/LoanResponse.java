package dev.kei.dto;

import dev.kei.entity.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponse {
    private Long id;
    private String loanId;
    private Integer customerId;
    private LoanStatus loanStatus;
    private Integer amount;
    private String customerName;
}
