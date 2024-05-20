package com.kevinicky.springbootcrudfile.transaction.model.service;

import com.kevinicky.springbootcrudfile.transaction.model.dto.request.TransactionCreateRequest;
import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.entity.Transaction;
import com.kevinicky.springbootcrudfile.transaction.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TransactionCreateService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionResponse create(TransactionCreateRequest req) {
        Transaction transaction = new Transaction();

        transaction.setId(getId());
        transaction.setPrice(req.getPrice());
        transaction.setQuantity(req.getQuantity());
        transaction.setItemName(req.getItemName());

        Transaction transactionCreateRes = transactionRepository.create(transaction);

        TransactionResponse response = new TransactionResponse();
        response.setId(transactionCreateRes.getId());
        response.setPrice(transactionCreateRes.getPrice());
        response.setQuantity(transactionCreateRes.getQuantity());
        response.setItemName(transactionCreateRes.getItemName());

        return response;
    }

    private Integer getId() {
        Random random = new Random();

        return random.nextInt(100) + 1;
    }

}
