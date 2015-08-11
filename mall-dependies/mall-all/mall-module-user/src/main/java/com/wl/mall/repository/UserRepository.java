package com.wl.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wl.mall.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByAccount(String account);
}
