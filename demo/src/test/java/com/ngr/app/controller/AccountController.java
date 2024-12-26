package com.ngr.app.controller;

import com.ngr.app.dto.UserAccountDTO;
import com.ngr.app.entity.Account;
import com.ngr.app.entity.Group;
import com.ngr.app.entity.User;
import com.ngr.app.services.AccountService;
import com.ngr.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
    private final AccountService accountService;
	
	@Autowired
	private UserService userService;

    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping("/loging")
    public ResponseEntity<String> login(@RequestBody Account acc) {
    	String s="hello";
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);
    }
   
    @PostMapping("/register")
    public ResponseEntity<Account> createAccount(@RequestBody UserAccountDTO userAccount) {
    	User User=userService.createUser(userAccount.getUser());
        Account createdAccount = userAccount.getAccount();
        createdAccount.setUser(User);
        createdAccount=accountService.createAccount(createdAccount);
        // Ensure service returns Account
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

 
    
    
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer accountId) {
        Account account = accountService.getAccount(accountId); // Use correct service method
        if (account != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(account);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts(); // Ensure service has this method
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @GetMapping("/{accountId}/groups")
    public ResponseEntity<List<Group>> getGroupsForAccount(@PathVariable Integer accountId) {
        List<Group> groups = accountService.getGroupsForAccount(accountId); // Implement in service layer
        if (groups != null && !groups.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(groups);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
