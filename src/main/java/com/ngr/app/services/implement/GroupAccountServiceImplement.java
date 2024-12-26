package com.ngr.app.services.implement;

import com.ngr.app.entity.Account;
import com.ngr.app.entity.Group;
import com.ngr.app.entity.GroupAccount;
import com.ngr.app.entity.Role;
import com.ngr.app.repostories.AccountRepository;
import com.ngr.app.repostories.GroupAccountRepository;
import com.ngr.app.repostories.GroupRepository;
import com.ngr.app.repostories.RoleRepository;
import com.ngr.app.services.GroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupAccountServiceImplement implements GroupAccountService {

	
    private final GroupAccountRepository groupAccountRepository;

    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    
    @Autowired
    public GroupAccountServiceImplement(GroupAccountRepository groupAccountRepository) {
        this.groupAccountRepository = groupAccountRepository;
    }

    @Override
    public String addAccountToGroupWithRole(GroupAccount groupAccount) {
        groupAccountRepository.save(groupAccount);
        return "Account added to group with role successfully!";
    }

    @Override
    public String removeAccountFromGroup(Integer accountId, Integer groupId) {
    	groupAccountRepository.deleteByAccountIdAndGroupId(accountId, groupId);
    	
    	return "Account removed from group successfully!";
    }

    @Override
    public GroupAccount getRoleForAccountInGroup(Integer accountId, Integer groupId) {
        return groupAccountRepository.findById(accountId).orElse(null);
    }

	@Override
    public void assignAccountToGroupWithRole(Integer accountId,Integer groupId) {
        // Fetch the Account, Group, and Role
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        // Create the GroupAccount and assign Account, Role, and Group
        GroupAccount groupAccount = new GroupAccount();
        groupAccount.setAccount(account);
        groupAccount.setGroup(group);

        // Save the GroupAccount to the repository
        groupAccountRepository.save(groupAccount);
    }
   

}
