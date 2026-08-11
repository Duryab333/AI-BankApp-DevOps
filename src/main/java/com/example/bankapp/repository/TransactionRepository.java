package com.example.bankapp.repository;

import com.example.bankapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//    List<Transaction> findByAccountIdOrderByTimestampDesc(Long accountId);
//}

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.account.id = :accountId ORDER BY t.timestamp DESC")
    List<Transaction> findByAccountIdOrderByTimestampDesc(@Param("accountId") Long accountId);
}