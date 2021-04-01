package com.example.testing.users.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Double amountToBeTaken = 0.0;

    @Column(nullable = false)
    Double amountToBeGiven = 0.0;

    @Transient
    Double totalBalance = 0.0;

    public Double getAmountToBeTaken() {
        return amountToBeTaken;
    }

    public void setAmountToBeTaken(Double amountToBeTaken) {
        this.amountToBeTaken = amountToBeTaken;
    }

    public Double getAmountToBeGiven() {
        return amountToBeGiven;
    }

    public void setAmountToBeGiven(Double amountToBeGiven) {
        this.amountToBeGiven = amountToBeGiven;
    }

    public Double getTotalBalance() {
        return getAmountToBeTaken() - getAmountToBeGiven();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amountToBeTaken=" + amountToBeTaken +
                ", amountToBeGiven=" + amountToBeGiven +
                ", totalBalance=" + totalBalance +
                '}';
    }
}
