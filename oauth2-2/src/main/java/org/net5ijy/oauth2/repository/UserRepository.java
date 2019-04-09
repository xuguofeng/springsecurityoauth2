package org.net5ijy.oauth2.repository;

import org.net5ijy.oauth2.bean.User;

public interface UserRepository {

	User findByUsername(String username);
}
