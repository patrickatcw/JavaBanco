package com.patrickjones.services;

//object - The principal building blocks of object-oriented programs. Each object is a programming
// unit consisting of data (instance variables) and functionality (instance methods).
//instance - An object of a particular class. In programs written in the Java(TM) programming language,
// an instance of a class is created using the new operator followed by the class name.
//instance variable - Any item of data that is associated with a particular object.
// Each instance of a class has its own copy of the instance variables defined in the class.
// Also called a field. See also class variable.
//instance method - Any method that is invoked with respect to an instance of a class.
// Also called simply a method. See also class method.

import com.patrickjones.models.BancAccount;

public class TransferManager {

    public void transfer(BancAccount accountToDebit, BancAccount accountToCredit, int amountToTransfer) {

        int accountToDebitBalance = accountToDebit.getBalance();
        System.out.println("Account to debit balance = $" + accountToDebitBalance);

       if (accountToDebitBalance < amountToTransfer){

            System.out.println("This transfer CANNOT be performed, the account balance amount of $" +
                    accountToDebitBalance + " is less than the amount to transfer, $" + amountToTransfer + ", " +
                    "putting your account below a $0.00 balance, " +
                    "resulting in a penalty of $50.00.");

            return;

        }

        int accountToDebitUpdatedBalance = accountToDebitBalance - amountToTransfer;

        accountToDebit.setBalance(accountToDebitUpdatedBalance);

        int accountToCreditBalance = accountToCredit.getBalance();
        System.out.println("Account to credit balance = $" + accountToCreditBalance);

        int accountToCreditUpdatedBalance = accountToCreditBalance + amountToTransfer;

        accountToCredit.setBalance(accountToCreditUpdatedBalance);

    }

}

