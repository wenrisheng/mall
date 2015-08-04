package com.wl.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wl.mall.entity.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {


}
