package com.wl.mall.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.wl.mall.domain.User;
import com.wl.mall.repository.UserRepository;
import com.wl.mall.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}



}
