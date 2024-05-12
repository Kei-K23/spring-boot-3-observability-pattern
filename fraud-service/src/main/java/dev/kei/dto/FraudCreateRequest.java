package dev.kei.dto;

import dev.kei.entity.LoanStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FraudCreateRequest{
    private Integer customerId;
    private String loanStatus;
}
