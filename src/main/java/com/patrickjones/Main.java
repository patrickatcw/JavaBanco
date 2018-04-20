package com.patrickjones;

import com.patrickjones.services.AskCustomer;

public class Main {

    public static void main(String[] args) {        //psvm then tab

        AskCustomer askCustomer = new AskCustomer();
        askCustomer.ask();

    }
}

//results
    /*What is the bank account number?
        4
        What is the amount in the bank account? $50*/

    /*What is the bank account number?
        22
        The account number 22 does not exist
        What is the bank account number?*/