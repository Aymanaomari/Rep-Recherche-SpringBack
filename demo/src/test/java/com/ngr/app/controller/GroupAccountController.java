package com.ngr.app.controller;

import com.ngr.app.entity.GroupAccount;
import com.ngr.app.services.GroupAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groupAccount")
public class GroupAccountController {

	@Autowired
    private final GroupAccountService groupAccountService;

    public GroupAccountController(GroupAccountService groupAccountService) {
        this.groupAccountService = groupAccountService;
    }

    @PostMapping
    public ResponseEntity<String> addAccountToGroupWithRole(@RequestBody GroupAccount groupAccount) {
        String response = groupAccountService.addAccountToGroupWithRole(groupAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{accountId}/{groupId}")
    public ResponseEntity<String> removeAccountFromGroup(@PathVariable Integer accountId, @PathVariable Integer groupId) {
        String response = groupAccountService.removeAccountFromGroup(accountId, groupId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @GetMapping("/{accountId}/{groupId}")
    public ResponseEntity<GroupAccount> getRoleForAccountInGroup(@PathVariable Integer accountId, @PathVariable Integer groupId) {
        GroupAccount groupAccount = groupAccountService.getRoleForAccountInGroup(accountId, groupId);
        if (groupAccount != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(groupAccount);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
  

    @PostMapping("/{groupId}/accounts/{accountId}")
    public void assignAccountToGroupWithRole(
        @PathVariable("accountId") Integer accountId,
        @PathVariable("groupId") Integer groupId,
        @PathVariable("roleId") Integer roleId
    ) {
        groupAccountService.assignAccountToGroupWithRole(accountId, groupId);
    }
}
