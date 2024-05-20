package com.wk.wellnessdev.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wk.wellnessdev.development.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

	//User findByUserId(Long id);

//	User findByUserId(Long id, User existingUser);
}
