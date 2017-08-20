package com.adamkorzeniak.HRS.user.service;

import com.adamkorzeniak.HRS.user.model.User;
import com.adamkorzeniak.HRS.user.model.UserDTO;

public interface UserService {

	User getUser(String username);

	User register(UserDTO userForm);

	String getPrincipal();

}