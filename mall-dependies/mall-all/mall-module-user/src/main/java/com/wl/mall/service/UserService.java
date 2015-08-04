package com.wl.mall.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wl.mall.entity.User;

public interface UserService extends UserDetailsService{

public abstract void saveUser(User user);
}
