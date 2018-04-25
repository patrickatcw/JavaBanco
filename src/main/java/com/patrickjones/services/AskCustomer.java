package com.patrickjones.services;

/*
Write a program that asks the user for two things from the command line: an account number and an amount, and then use
that information to update the balance of that account in the database.

One little wrinkle I want you to handle is to actually validate that the account number is actually an account number
in the database. If it isn't, your program should tell the user that and not proceed until the user enters a valid
account number.

After you do the update, print out a message confirming that the update succeeded and what the new account balance is.
 */

import com.patrickjones.BankAccountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AskCustomer {

    public void ask() {

        Scanner userInputScanner = new Scanner(System.in);

        boolean validInput = false;
        int acctNumb = 0;
        while (!validInput) {

            System.out.println("What is the bank account number?");
            int input = Integer.parseInt(userInputScanner.nextLine());

            BankAccountDAO dao = new BankAccountDAO();

            try {
                acctNumb = Integer.parseInt(String.valueOf(input));
                validInput = dao.isValidAccountNumber(input);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (!validInput) {
                System.out.println("The account number " + acctNumb + " does not exist");
            }

            System.out.print("What is the amount you would like to deposit? $");
            double input$ = Double.parseDouble(userInputScanner.nextLine());

       /* }
    }

        public void update(){*/

            Connection connect = null;
            Statement statement = null;

            try {

                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                        "true&useSSL=false", "gweedo", "gweedopw");

                statement = connect.createStatement();

                String sql = "update javabanco.bank_account "
                        + " set balance = " + input$
                        + " where account_number = " + acctNumb;

                statement.execute(sql);

                System.out.println("The amount of $" + input$ + " has been deposited to account " + acctNumb);

            } catch (Exception exc) {
                exc.printStackTrace();
            }

        }

    }
}






