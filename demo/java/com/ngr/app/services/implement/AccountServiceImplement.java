package com.ngr.app.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ngr.app.dto.AuthentificationDTO;
import com.ngr.app.entity.Account;
import com.ngr.app.entity.Group;
import com.ngr.app.entity.Role;
import com.ngr.app.entity.Roles;
import com.ngr.app.repostories.AccountRepository;
import com.ngr.app.repostories.RoleRepository;
import com.ngr.app.services.AccountService;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authManager;
    
    @Autowired 
    JWTService JwtService;
    
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
    
    public AccountServiceImplement(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
    	account.setPassword(encoder.encode(account.getPassword()));
    	Account account_2= accountRepository.save(account);
    	this.setRoleForAccount(account_2.getId(),Roles.REGISTRED_USER);
        return account_2;// Return saved account
    }

    @Override
    public String updateAccount(Account account) {
        accountRepository.save(account);
        return "Account updated successfully";
    }

    @Override
    public Account getAccount(Integer accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public String deleteAccount(Integer accountId) {
        accountRepository.deleteById(accountId);
        return "Account deleted successfully";
    }

    @Override
    public List<Account> getAccountsByUserId(Integer userId) {
        return accountRepository.findAll(); // Add filtering logic if needed
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(); // Retrieve all accounts
    }

    @Override
    public List<Group> getGroupsForAccount(Integer accountId) {
        Account account = accountRepository.findById(accountId).orElse(null);
        return account != null ? account.getGroups() : null; // Assuming Account has a `getGroups()` method
    }

    // New method to set a role for an account
    public String setRoleForAccount(Integer accountId, Roles roleEnum) {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) {
            return "Account not found";
        }

        // Find the role by its enum value
        Role role = roleRepository.findByRole(roleEnum)
                                   .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        // Assign the role to the account
        account.setRole(role);

        // Save the updated account
        accountRepository.save(account);
        return "Role assigned successfully";
    }

	@Override
	public String verify(Account acc) {
		Authentication auth=authManager.authenticate(new UsernamePasswordAuthenticationToken(acc.getEmail(),acc.getPassword()));
		if(auth.isAuthenticated()) return JwtService.GenerateToken(acc.getEmail()) ;
		return "not registred";
	}
}
