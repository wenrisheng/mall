package com.wl.mall.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wl.mall.entity.User;
import com.wl.mall.repository.UserRepository;
import com.wl.mall.service.UserService;


@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		logger.info("\n##########logger debug saveUser################\n");
	}

//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
