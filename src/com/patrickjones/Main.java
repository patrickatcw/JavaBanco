package com.patrickjones;

import com.patrickjones.models.BancAccount;

public class Main {

    public static void main(String[] args) {        //psvm then tab

        BancAccount patrick = new BancAccount();        //new object, creating an instance of the class BancAccount
        patrick.setAccountName("Patrick's Account");
        patrick.setBalance(1_000);
        int patrickAccountId = 1;
        patrick.setAccountNumber(patrickAccountId);

        BancAccount ryan = new BancAccount();
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        int ryanAccountId = 2;
        ryan.setAccountNumber(ryanAccountId);

        System.out.println(patrick);
        System.out.println(ryan);

    //use the transfer manager to transfer $50 from patrick to ryan
        System.out.println(patrick);
        System.out.println(ryan);

    }
}
