package com.patrickjones;

import com.patrickjones.models.BancAccount;
import com.patrickjones.services.TransferManager;

public class Main {

    public static void main(String[] args) {        //psvm then tab

        BancAccount patrick = new BancAccount("Patrick's Account", "Ryan's Account");    //new object, creating an instance of the class BancAccount
        patrick.setAccountName("Patrick's Account");
        patrick.setBalance(1_000);
        int patrickAccountId = 1;
        patrick.setAccountNumber(patrickAccountId);

        BancAccount ryan = new BancAccount("Patrick's Account", "Ryan's Account");
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        int ryanAccountId = 2;
        ryan.setAccountNumber(ryanAccountId);

        System.out.println(patrick);
        System.out.println(ryan);


        //use the transfer manager to transfer $60 from patrick to ryan

        // steps:

        // 1. Create a new instance of the TransferManager class

       // TransferManager myTransferManager = new TransferManager( );//this creates a new object myTransferManager
        //myTransferManager.transfer(patrick, ryan, 60);//new object.calling trransfer method on
        // mytransferManager variable
        //mytransfermanager is an instance of the transfer manager class

        //System.out.println(patrick);
        //System.out.println(ryan);

        // 2. call the `transfer` method of the instance you created in step 1,
        // passing in your variables patricksAccount, ryansAccount
        // and the amount you want to transfer

        TransferManager mytransferManagerTest = new TransferManager();
        mytransferManagerTest.transfer(patrick, ryan, 1001);

        //TransferManager myTransferManager = new TransferManager( );//this creates a new object myTransferManager
        //myTransferManager.transfer(patrick, ryan, 1001);//new object.calling transfer method on

        System.out.println(patrick);
        System.out.println(ryan);

        System.out.println("----------------------------------------");

        SQLConnect dao = new SQLConnect();
        dao.readDataBase();

    }
}


