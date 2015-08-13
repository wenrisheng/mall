package com.wl.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wl.mall.entity.User;
import com.wl.mall.module.common.dao.BaseRepository;

public interface UserRepository extends BaseRepository<User, Integer> {
	public User findByAccount(String account);
}
