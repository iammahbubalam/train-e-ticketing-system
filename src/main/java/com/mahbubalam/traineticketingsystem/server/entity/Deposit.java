package com.mahbubalam.traineticketingsystem.server.entity;

public class Deposit {
    private  int userId;
    private  float balance;

    public Deposit(float balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "userId=" + userId +
                ", balance=" + balance +
                '}';
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}