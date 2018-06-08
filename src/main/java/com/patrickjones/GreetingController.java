package com.patrickjones;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


@Controller
public class GreetingController {

    @Resource
    private UpdateAccount accountUpdater;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name",
            required = false, defaultValue = "World") String name, Model model, @ModelAttribute Greeting greeting) {
        model.addAttribute("name", name);
        return "greeting";

    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, HttpServletRequest req) throws SQLException {

        accountUpdater.updateBalance(greeting.getAccountNumber(), greeting.getAmount());

        // 1 - load the account with account_number == greeting.getAccountNumber()
        // 2 - get the current account balance
        // 3 - increment account balance by the amount in greeting.getAmount()
        // 4 - write new balance back to database
        // 5 - redirect to result() method

        return "redirect:/bank-accounts/" + greeting.getAccountNumber() + "/balance";

    }

    @GetMapping("/bank-accounts/{accountNumber}/balance")
    public String result(@PathVariable String acccountNumber) {

        // 6 - reload bank account
        // 7 - add bankAccoutn to model
        // 8 return "result"

        return "result";

    }

}



