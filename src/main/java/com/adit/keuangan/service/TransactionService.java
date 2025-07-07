package com.adit.keuangan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adit.keuangan.model.Transaction;
import com.adit.keuangan.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Transaction t) {
        repository.save(t);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public double getBalance() {
        return repository.findAll().stream()
            .mapToDouble(t -> "income".equalsIgnoreCase(t.getType()) ? t.getAmount() : -t.getAmount())
            .sum();
    }
}
