package com.wk.wellnessdev.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.wk.wellnessdev.development.model.User;
@EnableJpaRepositories
@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long> {

}