package com.wl.mall.module.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wl.mall.ApplicationViewTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationViewTest.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class BaseViewTest extends BaseRepositoryTest{
	@Autowired
    EmbeddedWebApplicationContext server;

	 private MockMvc mockMvc;
	
    @Value("${local.server.port}")
    int port;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.server).build();
        System.out.print("/*********************************** Test View  ***********************************/");
    }

	public EmbeddedWebApplicationContext getServer() {
		return server;
	}

	public void setServer(EmbeddedWebApplicationContext server) {
		this.server = server;
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
    
    

}
