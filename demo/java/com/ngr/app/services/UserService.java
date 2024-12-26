package com.ngr.app.services;

import com.ngr.app.dto.*; 
import java.util.List;

import com.ngr.app.entity.User;

public interface UserService {

public User createUser(User user);
public String updateUser(User user);
public User getUser(String userId);
public String deleteUser(String userId);
public List<User> getAllUsers();
}
