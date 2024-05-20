package com.wk.wellnessdev.development.service;

import java.util.List;

import com.wk.wellnessdev.development.model.User;

public interface UserService {
	public List<User> getAllUser();
	public User getUser(Long userId);
	public User createUser(User user);
	public User updateUser(Long userId,User user);
	public void deleteUser(Long userId);
	
//	public User updateUserPartially(Long id,Long phoneNumber);
	

}
