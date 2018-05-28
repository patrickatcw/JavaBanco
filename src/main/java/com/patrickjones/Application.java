package com.patrickjones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "account_number VARCHAR(255), amount VARCHAR(255))");

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(account_number, amount) VALUES (?,?)");

        log.info("Querying for customer records where account_number = '33':");

        jdbcTemplate.query(
                "SELECT account_number, amount FROM customers WHERE account_number = ?", new Object[]{"33"},
                (rs, rowNum) -> new Customer(rs.getLong("account_number"), rs.getDouble("amount"))
        ).forEach(customer -> log.info(customer.toString()));
    }
}
