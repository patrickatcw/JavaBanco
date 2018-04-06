package com.patrickjones;

//use gson logic to read accountsfile.json and printout balance
// from each account to varify working

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.patrickjones.models.BancAccount;
import com.patrickjones.services.TransferManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonFileReader {

    public static void main(String[] args)
            throws FileNotFoundException {

        Type accountListType = new TypeToken<List<BancAccount>>() {
        }.getType();

        Gson gson = new Gson();

        String filename = "accountsFile.json";
        String workingDirectory = System.getProperty("user.dir");
        File accountsFile = new File(workingDirectory, filename); //declared and initialized

        JsonReader reader = new JsonReader(new FileReader(accountsFile));
        List<BancAccount> accounts = gson.fromJson(reader, accountListType); //control p or control and click
        System.out.println(accounts);


        //example
        BancAccount patrick = null;  //declared
        BancAccount ryan = null;
        for (BancAccount account : accounts) {
            boolean isPatricksAccount = account.getAccountNumber()==1;
            if (isPatricksAccount) {
                patrick = account;  //setting to reference that are initialized
            } else {
                ryan = account;
            }
        }
        TransferManager transferManager = new TransferManager();
        transferManager.transfer(ryan, patrick, 100);
        System.out.println(ryan);
        System.out.println(patrick);

    }

}
