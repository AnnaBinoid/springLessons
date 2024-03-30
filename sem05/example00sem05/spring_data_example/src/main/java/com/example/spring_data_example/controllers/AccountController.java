package com.example.spring_data_example.controllers;


import com.example.spring_data_example.dio.TransferRequest;
import com.example.spring_data_example.domain.Account;
import com.example.spring_data_example.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * AccountController контролирует запросы, геты, посты с сервлетов
 */
@AllArgsConstructor
@RestController
public class AccountController {

    private final TransferService transferService;

    /**
     * Метод-транзакция в виде объекта TransferRequest,
     * производящий списание с одного счета
     * и передающий деньги на другой счет
     * @param request
     */
    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    /**
     * Метод, реализующий выборку аккаунтов: всех, если нет доп. параметра
     * и выборки по имени, если передается имя.
     * @param name - имя пользователя
     * @return все аккаунты, имеющиеся в системе
     */

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }

}
