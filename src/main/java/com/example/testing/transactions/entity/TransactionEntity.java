package com.example.testing.transactions.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name= "transaction")
public class TransactionEntity {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    @Column(nullable = false, name = "transaction_from")
    String transactionFrom;

    @Column(nullable = false, name = "transaction_to")
    String transactionTo;

    @Column(nullable = false)
    Double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionFrom() {
        return transactionFrom;
    }

    public void setTransactionFrom(String transactionFrom) {
        this.transactionFrom = transactionFrom;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionEntity(String transactionFrom, String transactionTo, Double amount) {
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
        this.amount = amount;
    }

    public TransactionEntity() {

    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id='" + id + '\'' +
                ", transactionFrom='" + transactionFrom + '\'' +
                ", transactionTo='" + transactionTo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
