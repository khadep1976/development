package com.wk.wellnessdev.development.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wk.wellnessdev.development.model.User;
import com.wk.wellnessdev.development.repository.UserRegistrationRepository;

@Service
public class UserServiceIMPL implements UserService {
	@Autowired
	UserRegistrationRepository userRepository;//<-Field base injuction-not recognise so use constructor base injection
	
	public List<User> getAllUser() {// get All User
		return userRepository.findAll();
	}
		
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User createUser(User user ) {
		return userRepository.save(user);
	}
	
	
	public User updateUser(Long id,User user) {
		User updateUser = userRepository.findById(id).get();
		updateUser.setName(user.getName());
		updateUser.setEmail(user.getEmail());
		updateUser.setPhoneNumber(user.getPhoneNumber());
		updateUser.setRole(user.getRole());
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(user.getPassword());
		userRepository.save(updateUser);
		return updateUser;
	}
	
	public void deleteUser(Long id) {
		User deleteUser = userRepository.findById(id).get();
		userRepository.delete(deleteUser);
	}
	
//	public User updateUserPartially(Long id, Long phoneNumber) {
//		User updateUser = userRepository.findById(id).get();
//		updateUser.setPhoneNumber(phoneNumber);
//		userRepository.save(updateUser);
//		return updateUser;
//	}
	

}
