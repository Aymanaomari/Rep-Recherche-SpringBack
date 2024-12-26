package com.ngr.app.services.implement;

import com.ngr.app.entity.Group;
import com.ngr.app.entity.Account;
import com.ngr.app.repostories.GroupRepository;
import com.ngr.app.repostories.AccountRepository;
import com.ngr.app.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImplement implements GroupService {

    private final GroupRepository groupRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public GroupServiceImplement(GroupRepository groupRepository, AccountRepository accountRepository) {
        this.groupRepository = groupRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Integer groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        return group.orElse(null);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public List<Account> getAccountsForGroup(Integer groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        return group != null ? group.getAccounts() : null;
    }
}
