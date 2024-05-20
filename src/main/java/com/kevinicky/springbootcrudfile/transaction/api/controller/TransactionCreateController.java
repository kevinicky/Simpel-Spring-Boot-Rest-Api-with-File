package com.kevinicky.springbootcrudfile.transaction.api.controller;


import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.dto.request.TransactionCreateRequest;
import com.kevinicky.springbootcrudfile.transaction.model.service.TransactionCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionCreateController {

    @Autowired
    private TransactionCreateService service;

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionCreateRequest request) {
        TransactionResponse response = service.create(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
