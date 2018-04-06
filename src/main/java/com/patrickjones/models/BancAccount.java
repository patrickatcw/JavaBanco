package com.patrickjones.models;


public class BancAccount {

    //instance variables, every instance of bancaccount
    private String accountName;
    private int balance;
    private int accountNumber;

    //default constructor automatically added by the compiler if you do not make yourself
    public BancAccount(String s, String s1) { //no return type type means constructor

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {           //method
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;  //this means patrick or ryan
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BancAccount{" +
                "accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
