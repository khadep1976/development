package com.wk.wellnessdev.development.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.wk.wellnessdev.development.model.User;
import com.wk.wellnessdev.development.service.UserService;

@RestController
public class UserCRUDController {
	
	@Autowired	// injects an instance of UserService into the controller
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> getAllUser() {//fetch all users.
		return userService.getAllUser();
	}
	
//	@GetMapping("/user?userId={userId}")	//query parameter  =  /user?userId={1}
//	public User getUser(@RequestParam Long userId) {

	@GetMapping("/user/{userId}")			////path variables = 	/user/123   /user/update?userId=1
	public User getUser(@PathVariable Long userId) {
		return userService.getUser(userId);

	}
	
	@PostMapping("/user/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createUser(@RequestBody User user ) {
		System.out.println("User created successfully");
		userService.createUser(user);
	}
	
	
	//@PutMapping("/user/update?userId=userId")	//query parameter  =  /user/update?userId=1
	//public User updateUser(@RequestParam Long userId,@RequestBody User user) {

	@PutMapping("/user/update/{userId}")		//path variables = 	/user/update/123   /user/update?userId=1
	public User updateUser(@PathVariable Long userId,@RequestBody User user) {
		System.out.println("User updated successfully");
		return userService.updateUser(userId,user);
	}
	
	
	@DeleteMapping("/user/delete/{userId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long userId) {
		System.out.println("User deleted successfully");
		userService.deleteUser(userId);
	}
	
//	@PatchMapping(value = "/user/updatep/{userId}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE} )
//	public User updateUserPartially(@PathVariable Long userId,@RequestBody Long phoneNumber) {
//		System.out.println("Phone number is : "+phoneNumber);
//		//Long phoneNum = (Long) phoneNumber.get("phoneNumber");
////		System.out.println("Phone number is : "+phoneNumber);
//		return userService.updateUserPartially(id,phoneNumber);
//	}
}
