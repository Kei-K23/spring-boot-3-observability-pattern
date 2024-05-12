package dev.kei.entity;

public record FraudRecord(String id, String fraudRecordId, String customerId, LoanStatus loanStatus) {
}
