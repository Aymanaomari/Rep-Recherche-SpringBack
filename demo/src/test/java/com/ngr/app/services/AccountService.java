package com.ngr.app.services;

import com.ngr.app.dto.AuthentificationDTO;
import com.ngr.app.entity.Account;
import com.ngr.app.entity.Group;
import java.util.List;

public interface AccountService {

    Account createAccount(Account account); // Updated to return Account

    String updateAccount(Account account);

    Account getAccount(Integer accountId); // Consistent naming

    String deleteAccount(Integer accountId);

    List<Account> getAccountsByUserId(Integer userId);

    List<Account> getAllAccounts(); // Added for completeness

    List<Group> getGroupsForAccount(Integer accountId); // Added to fetch groups

	String verify(Account acc);
}
