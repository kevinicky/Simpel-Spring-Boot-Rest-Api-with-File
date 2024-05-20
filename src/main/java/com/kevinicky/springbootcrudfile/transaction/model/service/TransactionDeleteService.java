package com.kevinicky.springbootcrudfile.transaction.model.service;

import com.kevinicky.springbootcrudfile.transaction.model.entity.Transaction;
import com.kevinicky.springbootcrudfile.transaction.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDeleteService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Boolean delete(Integer id) {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction> updatedTransactions = new ArrayList<>();

        boolean isFound = Boolean.FALSE;

        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                isFound = Boolean.TRUE;
                continue;
            }

            updatedTransactions.add(transaction);
        }

        transactionRepository.emptyFile();
        transactionRepository.delete(updatedTransactions);

        return isFound;

    }

}
