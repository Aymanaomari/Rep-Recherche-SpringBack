package com.ngr.app.services;

import com.ngr.app.entity.Group;
import com.ngr.app.entity.Account;

import java.util.List;

public interface GroupService {

    Group createGroup(Group group);

    Group getGroupById(Integer groupId);

    List<Group> getAllGroups();

    List<Account> getAccountsForGroup(Integer groupId);
}
