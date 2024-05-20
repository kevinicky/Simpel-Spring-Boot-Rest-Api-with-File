package com.kevinicky.springbootcrudfile.transaction.model.service;

import com.kevinicky.springbootcrudfile.transaction.model.dto.request.TransactionUpdateRequest;
import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.entity.Transaction;
import com.kevinicky.springbootcrudfile.transaction.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionUpdateService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionResponse update(TransactionUpdateRequest request) {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction> updatedTransactions = new ArrayList<>();

        Transaction updatedEntity = new Transaction();

        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(request.getId())) {
                updatedEntity = transaction;

                transaction.setPrice(request.getPrice());
                transaction.setQuantity(request.getQuantity());
                transaction.setItemName(request.getItemName());
            }

            updatedTransactions.add(transaction);
        }

        transactionRepository.emptyFile();
        transactionRepository.update(updatedTransactions);

        TransactionResponse response = new TransactionResponse();

        response.setId(updatedEntity.getId());
        response.setPrice(updatedEntity.getPrice());
        response.setQuantity(updatedEntity.getQuantity());
        response.setItemName(updatedEntity.getItemName());

        return response;

    }

}
