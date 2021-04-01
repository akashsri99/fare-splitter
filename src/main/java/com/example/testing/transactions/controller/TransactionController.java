package com.example.testing.transactions.controller;

import com.example.testing.transactions.dto.TransactionDTO;
import com.example.testing.transactions.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transaction/")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public void doTransaction(@RequestBody TransactionDTO transaction){
        transactionService.doTransaction(transaction);
        return;
    }
}
