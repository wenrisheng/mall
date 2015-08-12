package com.wl.mall.module.common.config.database;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.wl.mall.module.common.config.ConnectionProperties;
import com.wl.mall.module.common.config.factory.AbstractProductFactory;
@Configuration
public class ConnectionPropertiesProductFactory extends
		AbstractProductFactory<ConnectionProperties> {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionPropertiesProductFactory.class);

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
			logger.info("\n####################### 配置连接属性ConnectionProperties ########################\n");
		}
			break;

		default:
			break;
		}
		return connectionProperties;
	}

}
