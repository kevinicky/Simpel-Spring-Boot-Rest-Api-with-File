package com.kevinicky.springbootcrudfile.transaction.api.controller;


import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService service;

    @GetMapping(
            value = "/detail/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransactionResponse> detailTransaction(@PathVariable Integer id) {
        TransactionResponse response = service.detail(id);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
