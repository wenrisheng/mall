package com.wl.mall.module.foreground.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wl.mall.Application;
import com.wl.mall.entity.User;
import com.wl.mall.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestUserService {
	@Resource(name = "userServiceImpl")
	UserService userService;

	@Test
	public void testSaveUser() {
		User user = new User("ymldev", "aaa");
		userService.saveUser(user);
		System.out.println(user.getId());
		user.setAccount("account");
		userService.saveUser(user);
		System.out.println(user.getId());
	}

	public static void main(String[] args) {
		TestUserService testUserService = new TestUserService();
		Class aclass = Tea.class;
		testUserService.printField(aclass);
	}
	
	public void printField(Class aclass) {
		Field[] selfFields = aclass.getDeclaredFields();
		for (int i = 0; i < selfFields.length; i++) {
			// 权限修饰符
			int mo = selfFields[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = selfFields[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ selfFields[i].getName() + ";");
		}
		while (null != aclass.getSuperclass()) {
			this.printField(aclass.getSuperclass());
			
		}
	}
	
	
}
