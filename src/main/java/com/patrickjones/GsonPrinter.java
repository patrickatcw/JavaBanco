/*Add a new class called GsonPrinter with a main() method that creates a new BancAccount object
and then uses Gson to print it out as JSON.
result; {"accountName":"Ryan's Account","balance":10000,"accountNumber":2}*/
package com.patrickjones;

import com.google.gson.Gson;
import com.patrickjones.models.BancAccount;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GsonPrinter {

    public static void main(String[] args) {

        List<BancAccount> patrick = createBankAccount();
        Gson gson = new Gson();
        String json = gson.toJson(patrick);
        System.out.println(json);

        try {

            String filename = "accountsFile.txt";
            String workingDirectory = System.getProperty("user.dir");

            File file = new File(workingDirectory, filename);

            System.out.println("Final filepath : " + file.getAbsolutePath());
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File is already existed!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<BancAccount> createBankAccount() {

        List<BancAccount> accountList = new ArrayList<>();

        BancAccount patrick = new BancAccount();
        patrick.setAccountName("Patrick's Account");
        patrick.setBalance(1_000);
        patrick.setAccountNumber(1);

        BancAccount ryan = new BancAccount();
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        ryan.setAccountNumber(2);

        accountList.add(patrick);
        accountList.add(ryan);

        return accountList;

    }


}






