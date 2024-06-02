package com.pageturnerslibrary.api.repository;

import com.pageturnerslibrary.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
