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
public class LoanCreateRequest {
    private Integer customerId;
    private String customerName;
    private Integer amount;
}
