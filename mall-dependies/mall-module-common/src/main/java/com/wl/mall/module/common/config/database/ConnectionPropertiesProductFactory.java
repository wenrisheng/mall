package com.wl.mall.module.common.config.database;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.wl.mall.module.common.config.util.AbstractProductFactory;
import com.wl.mall.module.common.config.util.ConnectionProperties;
@Configuration
public class ConnectionPropertiesProductFactory extends
		AbstractProductFactory<ConnectionProperties> {
	@Resource
	ConnectionProperties mySqlConnectionProperties;
	
	@Override
	@Bean(name = "connectionProperties")
	@Primary
	public ConnectionProperties product() {
		// TODO Auto-generated method stub
		ConnectionProperties connectionProperties = null;
		switch (this.getDatabaseConfig().getDatabaseType()) {
		case 0:
		{
			connectionProperties = mySqlConnectionProperties;
		}
			break;

		default:
			break;
		}
		return connectionProperties;
	}

}
