package com.patrickjones;

import com.patrickjones.models.BancAccount;
import com.patrickjones.services.TransferManager;



public class Main {

    public static void main(String[] args) {        //psvm then tab

        BancAccount patrick = new BancAccount();    //new object, creating an instance of the class BancAccount
        patrick.setAccountName("Patrick's Account");
        patrick.setBalance(1_000);
        int patrickAccountId = 1;
        patrick.setAccountNumber(patrickAccountId);

        BancAccount ryan = new BancAccount();
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        int ryanAccountId = 2;
        ryan.setAccountNumber(ryanAccountId);

        //use the transfer manager to transfer $50 from patrick to ryan

        // steps:

        // 1. Create a new instance of the TransferManager class

        // 2. call the `transfer` method of the instance you created in step 1,
        // passing in your variables patricksAccount, ryansAccount
        // and the amount you want to transfer

        System.out.println(patrick);
        System.out.println(ryan);


        TransferManager myTransferManager = new TransferManager( );//this creates a new object myTransferManager
            myTransferManager.transfer(60);
            myTransferManager.getTransfer();
            System.out.println();

    }
}


