package com.sages.bank.services;

import com.sages.bank.entity.Account;
import com.sages.bank.entity.Transaction;
import com.sages.bank.enums.TransactionType;
import com.sages.bank.exceptions.SageBankTransactionException;

import java.math.BigDecimal;

public class TransactionServiceImpl implements TransactionService{
    public BigDecimal addTransaction(Account account, Transaction tx) throws SageBankTransactionException{
        if (tx.getType().equals(TransactionType.CREDIT)
        && tx.getAmount().compareTo(BigDecimal.ZERO) < BigDecimal.ZERO.intValue())
            throw  new  SageBankTransactionException("You deposited a negative amount");
        BigDecimal newBalance = null;
        if(tx.getType().equals(TransactionType.CREDIT)){
            newBalance = account.getBalance().add(tx.getAmount());
            account.setBalance(newBalance);
        }
        return newBalance;
    }
}
