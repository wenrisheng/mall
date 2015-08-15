package com.wl.mall.module.foreground.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.wl.mall.module.test.BaseViewTest;
import com.wl.mall.orm.entity.User;
import com.wl.mall.service.UserService;

public class TestUserService extends BaseViewTest{
	@Resource
	UserService userService;

	@Test
	public void testSaveUser() {
		User user = new User("ymldev", "aaa");
		userService.saveUser(user);
		System.out.println(user.getId());
		user.setAccount("101010");
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
