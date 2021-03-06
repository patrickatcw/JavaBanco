/*Add a new class called GsonPrinter with a main() method that creates a new BancAccount object
and then uses Gson to print it out as JSON.
result; {"accountName":"Ryan's Account","balance":10000,"accountNumber":2}*/
package com.patrickjones;

import com.google.gson.Gson;
import com.patrickjones.models.BancAccount;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class GsonPrinter {

    public static void main(String[] args) throws IOException {

        List<BancAccount> patrick = createBankAccount();
        Gson gson = new Gson();
        String json = gson.toJson(patrick);
        System.out.println(json);

        try {

            String filename = "accountsFile.json";
            String workingDirectory = System.getProperty("user.dir");

            File file = new File(workingDirectory, filename);

            System.out.println("Final filepath : " + file.getAbsolutePath());
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //byte[] jsonBytes = new byte[0];
        //Files.write(Paths.get("accountsFile.json"), jsonBytes);

        String filename = "accountsFile.json";
        String workingDirectory = System.getProperty("user.dir");

        Path path = Paths.get(workingDirectory + "/" + filename);

        byte[] jsonBytes = json.getBytes();

        Files.write(path, jsonBytes);
        System.out.println(path);
    }

    private static List<BancAccount> createBankAccount() {

        List<BancAccount> accountList = new ArrayList<>();

        BancAccount patrick = new BancAccount("Patrick's Account", "Ryan's Account");
        patrick.setAccountName("Patrick's Account");
        patrick.setBalance(1_000);
        patrick.setAccountNumber(1);

        BancAccount ryan = new BancAccount("Patrick's Account", "Ryan's Account");
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        ryan.setAccountNumber(2);

        accountList.add(patrick);
        accountList.add(ryan);

        return accountList;
    }

}


/*
There’s a `Files.write(Path path, byte[] data)` method that you can use to write the file.
To get a `Path` object, you need to use the `Paths.get(String path)` method to get a path
to the file, so you’ll need to combine `workingDirectory` and `filename`, then you’ll
have everything you need to write to the file (remember you an convert
a `String` to a `byte []` by using the `getBytes()` method.
*/







