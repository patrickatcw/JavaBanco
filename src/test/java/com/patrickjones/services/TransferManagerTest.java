package com.patrickjones.services;

import com.patrickjones.models.BancAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferManagerTest {

    @Test
    public void testDebitsAccountToDebitByTransferAmount() {
        BancAccount acctToDebit = new BancAccount();
        acctToDebit.setBalance(1000);

        BancAccount acctToCredit = new BancAccount();
        acctToCredit.setBalance(700);

        TransferManager transferManager = new TransferManager();
        transferManager.transfer(acctToDebit, acctToCredit, 100);

        String failureMessage = "The account to debit's balance should be reduced by the amount to transfer";
        assertEquals(failureMessage, 900, acctToDebit.getBalance());
    }

    @Test
    public void testCreditsAccountToCreditByTransferAmount() {
        //Assert.fail("Patrick has to complete me");   test error to complete

        BancAccount acctToDebit = new BancAccount();
        acctToDebit.setBalance(1000);

        BancAccount acctToCredit = new BancAccount();
        acctToCredit.setBalance(700);

        TransferManager transferManager = new TransferManager();
        transferManager.transfer(acctToDebit, acctToCredit, 100);

        String failureMessage = "The account to credit's balance should be increased by the amount to transfer";
        assertEquals(failureMessage, 800, acctToCredit.getBalance());

    }

    @Test
    public void testAccountToDebitBalance() {

        BancAccount acctToDebitBalance = new BancAccount();
        acctToDebitBalance.setBalance(1000);

        BancAccount acctToCreditBalance = new BancAccount();
        acctToCreditBalance.setBalance(700);

        BancAccount amountToTransfer = new BancAccount();
        amountToTransfer.setBalance(1001);

        TransferManager transferManager = new TransferManager();
        transferManager.transfer(acctToDebitBalance, acctToCreditBalance, 1001);

        String failureMessage = "The account to debit's balance does not have enough funds to complete this transfer";
        assertEquals(failureMessage, -1, amountToTransfer.getBalance());

    }

}

