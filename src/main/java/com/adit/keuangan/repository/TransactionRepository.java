package com.adit.keuangan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adit.keuangan.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
