package com.kevinicky.springbootcrudfile.transaction.model.service;

import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.entity.Transaction;
import com.kevinicky.springbootcrudfile.transaction.model.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransactionDetailService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionResponse detail(Integer id) {
        List<Transaction> transactions = transactionRepository.findAll();

        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                 TransactionResponse response = new TransactionResponse();
                 response.setId(transaction.getId());
                 response.setPrice(transaction.getPrice());
                 response.setQuantity(transaction.getQuantity());
                 response.setItemName(transaction.getItemName());

                 return response;
            }
        }

        log.info("transaction {} not found", id);

        return null;
    }

}
