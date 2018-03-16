/*Add a new class called GsonPrinter with a main() method that creates a new BancAccount object
and then uses Gson to print it out as JSON.
result; {"accountName":"Ryan's Account","balance":10000,"accountNumber":2}*/
package com.patrickjones;

import com.google.gson.Gson;
import com.patrickjones.models.BancAccount;

import java.util.Collections;
import java.util.List;

public class GsonPrinter {

    public static void main(String[] args) {

        List<BancAccount> ryan = createBankAccount();
        List<BancAccount> patrick = createBankAccount();
        Gson gson = new Gson();
        Gson gson1 = new Gson();
        String json = gson.toJson(ryan);
        String json1 = gson1.toJson(patrick);
        System.out.println(json);
        System.out.println(json1);

    }

    //need to return mult. bank accounts, so a list
    /*private static BancAccount createBankAccount() {    //List<BancAcoount>

        BancAccount ryan = new BancAccount();
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        ryan.setAccountNumber(2);

        return ryan;
    }*/

    private static List<BancAccount> createBankAccount() {

        BancAccount patrick = new BancAccount();
        patrick.setAccountName("Patrick's Account");
        patrick.setBalance(1_000);
        patrick.setAccountNumber(1);

        BancAccount ryan = new BancAccount();
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        ryan.setAccountNumber(2);

        return Collections.singletonList(patrick);
        //return Collections.singletonList(ryan);
        //when the above is not comment out, getting error;
        //java:unreachable statement
    }

}

/*print result;
{"accountName":"Ryan\u0027s Account","balance":10000,"accountNumber":2}
*/

