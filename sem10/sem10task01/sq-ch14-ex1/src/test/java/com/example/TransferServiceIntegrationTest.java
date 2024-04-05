package com.example;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Полное интеграционное тестирование.
 * Изменено отношение бинов.
 * Идет взаимодействие с БД, происходят все действия с ней.
 */
// аннотация @SpringBootTest подключает возможность задействования
// всех бинов из контейнера IOC.
@SpringBootTest
public class TransferServiceIntegrationTest {

    // создает полноценную копию объекта, которой будет управлять Мокито
    @MockBean
    public AccountRepository accountRepository;
    // и подключаем автозаполнение
    @Autowired
    public TransferService transferService;

    @Test
    public void moneyTransferGoodTest(){
        // pre (предпосылки)
        Account account1 = new Account();
        account1.setId(1);
        account1.setAmount(new BigDecimal(1000));
        Account account2 = new Account();
        account2.setId(2);
        account2.setAmount(new BigDecimal(1000));


        given(accountRepository.findById(account1.getId()))
                .willReturn(Optional.of(account1));
        given(accountRepository.findById(account2.getId()))
                .willReturn(Optional.of(account2));

        // action (вызов метода)
        transferService.transferMoney(1, 2, new BigDecimal(100));

        // test (проверка)
        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }
}
