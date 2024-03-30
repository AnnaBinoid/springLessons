package com.example.spring_data_example.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

/**
 * Класс аккаунты с id, именем пользователя и суммой на счете
 */
@Data
public class Account {

    @Id
    private long id;

    private String name;
    private BigDecimal amount;

}
