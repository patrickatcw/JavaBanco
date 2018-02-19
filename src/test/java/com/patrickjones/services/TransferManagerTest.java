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

}

/* Test Results
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.patrickjones.services.TransferManagerTest
1000
700
1000
700
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.093 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.799 s
[INFO] Finished at: 2018-02-19T14:53:06-05:00
[INFO] Final Memory: 13M/43M
[INFO] ------------------------------------------------------------------------

*/