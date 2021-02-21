package com.account.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;


public class Account {
    String accountNumber;
    String type;
    double balance;
    LocalDateTime lastUpdateTimeStamp;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getLastUpdateTimeStamp(LocalDateTime now) {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(LocalDateTime lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", lastUpdateTimeStamp=" + lastUpdateTimeStamp +
                '}';
    }
}
