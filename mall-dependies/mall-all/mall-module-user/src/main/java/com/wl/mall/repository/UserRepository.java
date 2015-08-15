package com.wl.mall.repository;


import org.springframework.stereotype.Repository;

import com.wl.mall.module.common.dao.BaseRepository;
import com.wl.mall.orm.entity.User;

public interface UserRepository extends BaseRepository<User, Integer> {
	public User findByAccount(String account);
}
