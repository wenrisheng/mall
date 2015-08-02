package com.wl.mall.module.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wl.mall.ApplicationTest;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationTest.class)
public class BaseRepositoryTest {
	@Test
	public void test() {
		System.out.print("/*********************************** Test Repository ***********************************/");
	}
}
