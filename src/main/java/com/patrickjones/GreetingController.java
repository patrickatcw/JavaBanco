package com.patrickjones;

import com.patrickjones.models.BancAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class GreetingController {

    //spring is making new updateaccount object here
    @Resource
    private UpdateAccount accountUpdater;

    //spring is making new bankAccountDAO object here
    @Resource
    private BankAccountDAO bankAccountDAO;

    @GetMapping("/accountUpdateForm")
    public String greeting(@RequestParam(name = "name",
            required = false, defaultValue = "World") String name, Model model, @ModelAttribute AccountUpdateForm accountUpdateForm) {
        model.addAttribute("name", name);
        return "greeting";

    }

    @PostMapping("/accountUpdateForm")
    public String greetingSubmit(@ModelAttribute AccountUpdateForm accountUpdateForm, HttpServletRequest req)
            throws SQLException {

        accountUpdater.updateBalance(accountUpdateForm.getAccountNumber(), accountUpdateForm.getAmount());
        // 1 - load the account with account_number is the same as accountUpdateForm.getAccountNumber() in the database
        // 2 - get the current account balance
        Integer currentBalance = bankAccountDAO.retrieveAccountBalance(accountUpdateForm.getAccountNumber()); //method logic and connection logic in bankaccountdoa
        // 3 - increment account balance by the amount in accountUpdateForm.getAmount()
        Integer newUpdatedBalance = currentBalance + accountUpdateForm.getAmount();
        // 4 - write new balance back to database
        //update dbbalance, passing new balance total and account number in method
        bankAccountDAO.updateDBBalance(accountUpdateForm.getAccountNumber(), newUpdatedBalance);

        //examples of what can be done with bankAccountDAO.updateDBBalance
        /*bankAccountDAO.updateDBBalance(7, 5000);
        bankAccountDAO.updateDBBalance(accountUpdateForm.getAccountNumber(), 9000);
        bankAccountDAO.updateDBBalance(accountUpdateForm.getAccountNumber(), updatedDBBalance);
        bankAccountDAO.updateDBBalance(9, accountUpdateForm.getAmount());*/

        // 5 - redirect to result() method, done below
        return "redirect:/bank-accounts/" + accountUpdateForm.getAccountNumber() + "/balance";

    }

    @GetMapping("/bank-accounts/{accountNumber}/balance")
    public String result(@PathVariable String accountNumber, Model model) {
        //example like writeresult set
        // 6 - reload bank account
        //make new method, return type is BankAccount(new object i make), select* from
        // bank_account where account_number is the number
        //that is passed to it, which is accountNumber, loop over with while loop

        BancAccount bancAccount = bankAccountDAO.returnBankAccount(accountNumber);
        // 7 - add bankAccount to model
        //model.addAttribute, where first arg is bankAccount

        model.addAttribute("bankAccount", bancAccount);

        // 8 return "result"
        return "result";

    }

}



