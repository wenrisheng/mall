package com.wl.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wl.mall.entity.User;
import com.wl.mall.repository.UserRepository;
import com.wl.mall.service.UserService;


@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
