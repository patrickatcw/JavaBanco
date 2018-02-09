package com.patrickjones.services;

//object - The principal building blocks of object-oriented programs. Each object is a programming
// unit consisting of data (instance variables) and functionality (instance methods).
//instance - An object of a particular class. In programs written in the Java(TM) programming language,
// an instance of a class is created using the new operator followed by the class name.
//instance variable - Any item of data that is associated with a particular object.
// Each instance of a class has its own copy of the instance variables defined in the class.
// Also called a field. See also class variable.
//instance method - Any method that is invoked with respect to an instance of a class.
// Also called simply a method. See also class method.

import com.patrickjones.models.BancAccount;

public class TransferManager {


    public void transfer(BancAccount accountToDebit, BancAccount accountToCredit, int amountToTransfer) {


        // steps:


// 1. get the current balance of the accountToDebit
        int accountToDebitBalance = accountToDebit.getBalance();
        System.out.println(accountToDebitBalance);

// 2. subtract the amountToTransfer from the current balance of accountToDebit
        int accountToDebitUpdatedBalance = accountToDebitBalance - amountToTransfer;

// 3. update the balance of the accountToDebit with the new balance you calculated
// in step 2 using the setBalance method
        accountToDebit.setBalance(accountToDebitUpdatedBalance);

// 4. get the current balance of the accountToCredit
        int accountToCreditBalance = accountToCredit.getBalance();
        System.out.println(accountToCreditBalance);

// 5. increase the balance of accountToCredit by amountToTransfer
        int accountToCreditUpdatedBalance = accountToCreditBalance + amountToTransfer;

// 6. set the updated balance of accountToCredit to the value you calculated in
// step 5 by using the setBalance method
        accountToCredit.setBalance(accountToCreditUpdatedBalance);

//homework to complete this method, the logic to transfer money, addition / subtraction.
//use the transfer manager to transfer $60 from patrick to ryan

/*what do you want to do?
create a method that transfers money from one account to another
what are the problems?
- create variables and method logic
- the parameters; how to identify, the int is already there for one, but the others?
*/
    }

}

