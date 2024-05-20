package com.kevinicky.springbootcrudfile.transaction.api.controller;


import com.kevinicky.springbootcrudfile.transaction.model.service.TransactionDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionDeleteController {

    @Autowired
    private TransactionDeleteService service;

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public ResponseEntity<Boolean> deleteTransaction(@PathVariable Integer id) {
        Boolean isFound = service.delete(id);

        return new ResponseEntity<>(isFound, HttpStatus.OK);
    }

}
