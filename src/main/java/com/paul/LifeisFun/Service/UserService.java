package com.paul.LifeisFun.Service;

import java.util.Optional;

import com.paul.LifeisFun.Entity.User;

public interface UserService {
	public Optional<User> findUserByUserName(String userName);
	public void saveUser(User user);
}
