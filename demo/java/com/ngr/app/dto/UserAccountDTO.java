package com.ngr.app.dto;

import com.ngr.app.entity.Account;
import com.ngr.app.entity.User;

public class UserAccountDTO {
    private User user;
    private Account account;

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
