package org.net5ijy.oauth2.service;

import java.util.List;

import org.net5ijy.oauth2.bean.User;

public interface UserService {

	User getUser(String username);

	List<User> getUsers();
}
