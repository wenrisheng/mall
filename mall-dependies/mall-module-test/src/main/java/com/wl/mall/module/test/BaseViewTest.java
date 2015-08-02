package com.wl.mall.module.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wl.mall.ApplicationViewTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationViewTest.class)
@WebAppConfiguration
public class BaseViewTest extends BaseRepositoryTest{
	@Test
	public void test() {
		System.out.print("/*********************************** Test View  ***********************************/");
	}
}
