/*Add a new class called GsonPrinter with a main() method that creates a new BancAccount object
and then uses Gson to print it out as JSON.
result; {"accountName":"Ryan's Account","balance":10000,"accountNumber":2}*/
package com.patrickjones;

import com.google.gson.Gson;
import com.patrickjones.models.BancAccount;

public class GsonPrinter {

    public static void main(String[] args) {

        BancAccount ryan = Object();
        Gson gson = new Gson();
        String json = gson.toJson(ryan);
        System.out.println(json);

    }

    private static BancAccount Object() {

        BancAccount ryan = new BancAccount();
        ryan.setAccountName("Ryan's Account");
        ryan.setBalance(10_000);
        ryan.setAccountNumber(2);

        return ryan;

    }

}

/*print result;
{"accountName":"Ryan\u0027s Account","balance":10000,"accountNumber":2}
*/

