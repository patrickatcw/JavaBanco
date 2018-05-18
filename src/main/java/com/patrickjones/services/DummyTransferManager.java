package com.patrickjones.services;

import com.patrickjones.models.BancAccount;

public class DummyTransferManager extends TransferManager {

    @Override
    public void transfer(BancAccount accountToDebit, BancAccount accountToCredit, int amountToTransfer) {
        System.out.println("Dummy Transfer Manager Called");
    }
}
