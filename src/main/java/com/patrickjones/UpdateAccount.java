package com.patrickjones;

import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class UpdateAccount {


    public void updateBalance(int accountNumber, int amount)
            throws SQLException {
        System.out.println(accountNumber);
        System.out.println(amount);

        Connection connect = null;
        Statement statement = null;

        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabanco?autoReconnect=" +
                    "true&useSSL=false", "gweedo", "gweedopw");

            statement = connect.createStatement();

            String sql = "select balance from bank_account "

                    + " where account_number = " + accountNumber;

            ResultSet rs = statement.executeQuery(sql);

            Double currentBalance = rs.getDouble(0);

            //System.out.println("The amount of $" + input$ + " has been deposited to account " + acctNumb);

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }

}
