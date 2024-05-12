package dev.kei.dto;

import dev.kei.entity.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudResponse {
    private Long id;
    private String fraudId;
    private  Integer customerId;
}
