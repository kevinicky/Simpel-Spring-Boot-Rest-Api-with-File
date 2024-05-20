package com.kevinicky.springbootcrudfile.transaction.model.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinicky.springbootcrudfile.transaction.model.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class TransactionRepository {

    public void emptyFile() {
        try (FileWriter fileWriter = new FileWriter("transaction.txt")) {

            fileWriter.write("");
        } catch (IOException e) {
            log.info("failed to empty transaction file: {}", e.getMessage());
        }
    }

    public void update(List<Transaction> transactions) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter fileWriter = new FileWriter("transaction.txt", true)) {
            for (Transaction transaction : transactions) {
                String body = objectMapper.writeValueAsString(transaction);
                fileWriter.write(body + "\n");
            }
        } catch (Exception e) {
            log.info("failed to write transactions to file: {}", e.getMessage());
        }
    }

    public void delete(List<Transaction> transactions) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter fileWriter = new FileWriter("transaction.txt", true)) {
            for (Transaction transaction : transactions) {
                String body = objectMapper.writeValueAsString(transaction);
                fileWriter.write(body + "\n");
            }
        } catch (Exception e) {
            log.info("failed to write transactions to file: {}", e.getMessage());
        }
    }


    public Transaction create(Transaction transaction) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (FileWriter fileWriter = new FileWriter("transaction.txt", true)) {
            String body = objectMapper.writeValueAsString(transaction);

            fileWriter.write(body + "\n");
        } catch (IOException e) {
            log.info("failed to write transactions to file: {}", e.getMessage());

            return null;
        }

        return transaction;
    }

    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (FileReader fileReader = new FileReader("transaction.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                Transaction transaction = objectMapper.readValue(line, Transaction.class);

                transactions.add(transaction);
            }
        } catch (Exception e) {
            log.info("failed to read transactions to file: {}", e.getMessage());
        }

        return transactions;
    }

}
