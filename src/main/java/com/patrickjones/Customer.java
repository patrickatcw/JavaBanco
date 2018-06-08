package com.patrickjones;

//https://spring.io/guides/gs/relational-data-access/

public class Customer {

    private long accountNumber;
    private double amount;

    public Customer(long accountNumber, double amount) {

        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[accountNumber='%s', amount='%s']",
                accountNumber, amount);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {

        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
