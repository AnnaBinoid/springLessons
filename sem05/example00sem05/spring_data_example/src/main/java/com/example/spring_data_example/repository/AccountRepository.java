package com.example.spring_data_example.repository;

import com.example.spring_data_example.domain.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Репозиторий для сущности Account,
 * реализующий стандартные CRUD-методы
 * и наши методы: поиска аккаунта по имени
 * и изменения суммы
 */
public interface AccountRepository extends CrudRepository<Account,Long> {
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);
}
