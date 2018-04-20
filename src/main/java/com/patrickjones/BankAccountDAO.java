package com.patrickjones;

import java.sql.*;

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
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1, e.g. resultSet.getString(2);

            String comment = resultSet.getString("account_name");
            System.out.println("Account Name: " + comment);

            //added for askcustomer
            String comment2 = resultSet.getString("account_number");
            System.out.println("Account Number: " + comment2);

        }
    }

//    // You need to close the resultSet
//    private void close() {
//        try {
//            if (resultSet!=null) {
//                resultSet.close();
//            }
//
//            if (statement!=null) {
//                statement.close();
//            }
//
//            if (connect!=null) {
//                connect.close();
//            }
//        } catch (Exception e) {
//
//        }
//    }


}

