package com.kevinicky.springbootcrudfile.transaction.api.controller;


import com.kevinicky.springbootcrudfile.transaction.model.dto.request.TransactionUpdateRequest;
import com.kevinicky.springbootcrudfile.transaction.model.dto.response.TransactionResponse;
import com.kevinicky.springbootcrudfile.transaction.model.service.TransactionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionUpdateController {

    @Autowired
    private TransactionUpdateService service;

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransactionResponse> updateTransaction(@RequestBody TransactionUpdateRequest request, @PathVariable Integer id) {
        request.setId(id);

        TransactionResponse response = service.update(request);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
