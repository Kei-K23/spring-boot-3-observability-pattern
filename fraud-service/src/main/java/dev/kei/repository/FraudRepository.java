package dev.kei.repository;

import dev.kei.dto.FraudCreateRequest;
import dev.kei.dto.FraudResponse;
import dev.kei.entity.Fraud;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class FraudRepository {
    private final JdbcClient jdbcClient;

    public FraudRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public List<FraudResponse> findAllFraud() {
        var selectQuery = "SELECT * FROM fraud_records";
        return jdbcClient.sql(selectQuery).query(FraudResponse.class).list();
    } 
    
    public void save(Fraud fraud) {
        var insertQuery = "INSERT INTO fraud_records(fraudId, customerId, loanStatus) VALUES(?, ?, ?)";
        jdbcClient.sql(insertQuery)
                .param(1, UUID.randomUUID().toString())
                .param(2, fraud.getCustomerId())
                .param(3, fraud.getLoanStatus().toString())
                .update();
    }
}