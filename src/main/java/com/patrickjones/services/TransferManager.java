package com.patrickjones.services;

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

