package org.net5ijy.oauth2.repository;

import java.util.List;

import org.net5ijy.oauth2.bean.User;

public interface UserRepository {

	User findByUsername(String username);

	List<User> findUsers();
}
