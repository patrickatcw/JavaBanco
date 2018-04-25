package com.patrickjones;

import com.patrickjones.services.AskCustomer;

public class Main {

    public static void main(String[] args) {        //psvm then tab

        AskCustomer askCustomer = new AskCustomer();
        askCustomer.ask();

    }
}

//results
    /*
    What is the bank account number?
    4
    What is the amount you would like to deposit? $589.16
    The amount of $589.16 has been deposited to account 4
    */