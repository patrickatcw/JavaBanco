package com.patrickjones.services;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.patrickjones.models.BancAccount;

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
		Assert.fail("Patrick has to complete me");
	}

}