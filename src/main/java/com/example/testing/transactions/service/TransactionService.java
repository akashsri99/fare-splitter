package com.example.testing.transactions.service;

import com.example.testing.users.entity.UserEntity;
import com.example.testing.users.service.UserService;
import com.example.testing.transactions.dto.TransactionDTO;
import com.example.testing.transactions.entity.TransactionEntity;
import com.example.testing.transactions.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    UserService userService;

    @Autowired
    TransactionRepository transactionRepository;

    public  void doTransaction(TransactionDTO transaction){
        String toUser  =  transaction.getUserTo();
        String fromUser = transaction.getUserFrom();
        Double amount = transaction.getAmount();

        // vaidate users
        Optional<UserEntity> toUserData = userService.getUserById(toUser);
        if(toUserData.isEmpty()){
            throw new IllegalArgumentException("toUserID is incorrect ");
        }


        Optional<UserEntity> fromUserData = userService.getUserById(fromUser);
        if(fromUserData.isEmpty()){
            throw new IllegalArgumentException("fromUserData is incorrect ");
        }

        proceedTransaction(transaction);
    }

    private void proceedTransaction(TransactionDTO transaction){
        try {
            userService.addBalance(transaction.getUserTo(), transaction.getAmount());
            userService.deductBalance(transaction.getUserFrom(), transaction.getAmount());
            TransactionEntity transactionEntity = new TransactionEntity(transaction.getUserFrom(), transaction.getUserTo(), transaction.getAmount());
            transactionRepository.save(transactionEntity);
        }catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
