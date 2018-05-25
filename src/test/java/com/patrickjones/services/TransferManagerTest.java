package com.patrickjones.services;

import com.patrickjones.models.BancAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TransferManagerTest {

   @Test
    public void testDebitsAccountToDebitByTransferAmount() {
       BancAccount acctToDebit = new BancAccount("Patrick's Account", "Ryan's Account");
        acctToDebit.setBalance(1000);

       BancAccount acctToCredit = new BancAccount("Patrick's Account", "Ryan's Account");
        acctToCredit.setBalance(700);

        TransferManager transferManager = new TransferManager();
        transferManager.transfer(acctToDebit, acctToCredit, 100);

        String failureMessage = "The account to debit's balance should be reduced by the amount to transfer";
       assertEquals(failureMessage, 909, acctToDebit.getBalance());
    }

    @Test
    public void testCreditsAccountToCreditByTransferAmount() {
        //Assert.fail("Patrick has to complete me");   test error to complete

        BancAccount acctToDebit = new BancAccount("Patrick's Account", "Ryan's Account");
        acctToDebit.setBalance(1000);

        BancAccount acctToCredit = new BancAccount("Patrick's Account", "Ryan's Account");
        acctToCredit.setBalance(700);

        TransferManager transferManager = new TransferManager();
        transferManager.transfer(acctToDebit, acctToCredit, 100);

        String failureMessage = "The account to credit's balance should be increased by the amount to transfer";
        assertEquals(failureMessage, 800, acctToCredit.getBalance());

    }

    @Test
    public void testAccountToDebitBalance() {

        BancAccount acctToDebitBalance = new BancAccount("Patrick's Account", "Ryan's Account");
        acctToDebitBalance.setBalance(1000);

        BancAccount acctToCreditBalance = new BancAccount("Patrick's Account", "Ryan's Account");
        acctToCreditBalance.setBalance(700);

        TransferManager transferManager = new TransferManager();
        transferManager.transfer(acctToDebitBalance, acctToCreditBalance, 1001);

        String failureMessage = "Transfer should not take place if account to debit does not have enuff funds";
        assertEquals(failureMessage, 1000, acctToDebitBalance.getBalance()); //result after transfer

    }

}

