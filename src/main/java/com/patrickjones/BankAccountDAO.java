package com.patrickjones;

import com.patrickjones.models.BancAccount;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BankAccountDAO {

    public boolean isValidAccountNumber(int accountNumber) {

        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                    "true&useSSL=false", "gweedo", "gweedopw");

            statement = connect.createStatement();

            resultSet = statement
                    .executeQuery("select count(*) as num_accounts from bank_account where account_number = \"" + accountNumber + "\"");

            int count = 0;
            while (resultSet.next()) {
                count = resultSet.getInt("num_accounts");
            }

            return count > 0;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void readDataBase() {

        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                    "true&useSSL=false", "gweedo", "gweedopw");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from javabanco.bank_account");
            writeResultSet(resultSet);

            resultSet = statement
                    .executeQuery("select * from javabanco.bank_account");
            writeMetaData(resultSet);

        } catch (Exception e) {
            //trying from ryan viewing this
            throw new RuntimeException("Problem querying database", e);
        } finally {
            // close();
        }

    }

    private static void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));

        }
    }

    private static void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        BancAccount account = new BancAccount(null, null);
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1, e.g. resultSet.getString(2);

            String bankAccountName = resultSet.getString("account_name");
            System.out.println("Account Name: " + bankAccountName);
            account.setAccountName(bankAccountName);

            //added for askcustomer
            int accountNumber = resultSet.getInt("account_number");
            account.setAccountNumber(accountNumber);
            System.out.println("Account Number: " + accountNumber);

        }
    }

    //both obtained from accountUpdateForm object from accountUpdateForm controller that stays there,
    // don't pass to either of the 2 new methods
    //step 1) method to retrieve balance int account number
    public Integer retrieveAccountBalance(int accountNumber)

            throws SQLException {
        System.out.println(accountNumber);

        Connection connect = null;
        Statement statement = null;

        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                    "true&useSSL=false", "gweedo", "gweedopw");

            statement = connect.createStatement();

            //select balance from bank account where account number = account number that is being passed as arg.
            String sql = "select balance from bank_account "

                    + " where account_number = " + accountNumber;

            ResultSet rs = statement.executeQuery(sql);

            Integer currentBalance = null;
            while (rs.next()) {
                currentBalance = rs.getInt(1);
            }

            return currentBalance;

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        return null;

    }

    //step 2) method to update balance int new balance is argument and account number
    public void updateDBBalance(int accountNumber, int amount)
            throws SQLException {
        System.out.println(accountNumber);
        System.out.println(amount);

        Connection connect = null;
        Statement statement = null;

        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                    "true&useSSL=false", "gweedo", "gweedopw");

            statement = connect.createStatement();

            //select balance from bank account where account number = account number that is being passed as arg.
            String sql = "update bank_account set balance = " + amount + " where account_number = '"
                    + accountNumber + "'";

            boolean updateSucceeded = statement.execute(sql);

            if (!updateSucceeded) {
                System.out.println("Update failed");
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }

    //step 6 method here
    public BancAccount returnBankAccount(String accountNumber) {
        System.out.println(accountNumber);

        Connection connect = null;
        Statement statement = null;

        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                    "true&useSSL=false", "gweedo", "gweedopw");

            statement = connect.createStatement();

            //select balance from bank account where account number = account number that is being passed as arg.
            String sql = "select * from bank_account "

                    + " where account_number = '" + accountNumber +
                    "'";

            ResultSet rs = statement.executeQuery(sql);

            BancAccount bancAccount = new BancAccount(null, null);

            while (rs.next()) {

                accountNumber = rs.getString("account_number");
                System.out.println("Account Number: " + accountNumber);
                //accountNumber.setAccountNumber(bankAccountName);
                bancAccount.setAccountNumber(Integer.parseInt(accountNumber));

                String accountName = rs.getString("account_name");
                bancAccount.setAccountName(accountName);

                Integer acctBalance = rs.getInt("balance");
                bancAccount.setBalance(acctBalance);

            }

            return bancAccount;

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        return null;


    }

}

