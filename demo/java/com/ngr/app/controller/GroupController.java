package com.ngr.app.controller;

import com.ngr.app.entity.Group;
import com.ngr.app.entity.Account;
import com.ngr.app.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    // Endpoint to create a new group
    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    // Endpoint to retrieve all groups
    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    // Endpoint to retrieve a specific group by its ID
    @GetMapping("/{groupId}")
    public Group getGroupById(@PathVariable Integer groupId) {
        return groupService.getGroupById(groupId);
    }

    // Endpoint to retrieve accounts for a specific group
    @GetMapping("/{groupId}/accounts")
    public List<Account> getAccountsForGroup(@PathVariable Integer groupId) {
        return groupService.getAccountsForGroup(groupId);
    }
}
