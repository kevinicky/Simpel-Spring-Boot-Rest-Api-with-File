package com.kevinicky.springbootcrudfile.transaction.model.service;

import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.entity.Transaction;
import com.kevinicky.springbootcrudfile.transaction.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionListService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionResponse> list() {
        List<Transaction> transactions = transactionRepository.findAll();

        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for (Transaction transaction : transactions) {
            TransactionResponse response = new TransactionResponse();

            response.setId(transaction.getId());
            response.setPrice(transaction.getPrice());
            response.setQuantity(transaction.getQuantity());
            response.setItemName(transaction.getItemName());

            transactionResponses.add(response);
        }

        return transactionResponses;
    }

}
