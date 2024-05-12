package dev.kei.repository;

import dev.kei.dto.FraudResponse;
import dev.kei.entity.Fraud;
import org.springframework.jdbc.core.simple.JdbcClient;
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
        var insertQuery = "INSERT INTO fraud_records(fraudId, customerId) VALUES(?, ?)";
        jdbcClient.sql(insertQuery)
                .param(1, UUID.randomUUID().toString())
                .param(2, fraud.getCustomerId())
                .update();
    }

    public boolean checkFraudByCustomerId(Integer customerId) {
        var selectQuery = """
                SELECT COUNT(*) AS fraud__record_exists
                FROM fraud_records
                WHERE customerId = :customerId;
                """;
        return jdbcClient.sql(selectQuery)
               .param("customerId", customerId)
               .query(Integer.class)
               .single() > 0;
    }
}
