package com.example.spring_data_example.dio;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Класс-трансфер, который будет передаваться
 * между объектами.
 */
@Data
public class TransferRequest {

    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;

}
