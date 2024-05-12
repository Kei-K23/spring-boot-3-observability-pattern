CREATE TABLE fraud_records
(
    id            BIGINT      NOT NULL AUTO_INCREMENT,
    fraudId VARCHAR(36) NOT NULL,
    customerId    INT         NOT NULL,
    loanStatus VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
