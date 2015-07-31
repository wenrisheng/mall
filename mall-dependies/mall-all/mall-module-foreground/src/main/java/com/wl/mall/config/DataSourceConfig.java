package com.wl.mall.config;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//@Configuration
//@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {

	@Resource
	private Environment env;


//	@Bean(name = "dataSource")
//	@Primary
	public DataSource dataSource() throws PropertyVetoException {

		String driverClass = env
				.getRequiredProperty("hibernate.connection.driver_class");
		String url = env.getRequiredProperty("hibernate.connection.url");
		String user = env.getRequiredProperty("hibernate.connection.username");
		String password = env
				.getRequiredProperty("hibernate.connection.password");
		String acquireIncrement = env
				.getRequiredProperty("c3p0.acquireIncrement");
		String initialPoolSize = env
				.getRequiredProperty("c3p0.initialPoolSize");
		String minPoolSize = env.getRequiredProperty("c3p0.minPoolSize");
		String numHelperThreads = env
				.getRequiredProperty("c3p0.numHelperThreads");
		String maxPoolSize = env.getRequiredProperty("c3p0.maxPoolSize");
		String maxStatements = env.getRequiredProperty("c3p0.maxStatements");
		String maxIdleTime = env.getRequiredProperty("c3p0.maxIdleTime");
		String idleConnectionTextPeriod = env.getRequiredProperty("c3p0.idleConnectionTextPeriod");
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setAcquireIncrement(Integer.valueOf(acquireIncrement));
		dataSource.setInitialPoolSize(Integer.valueOf(initialPoolSize));
		dataSource.setMinPoolSize(Integer.valueOf(minPoolSize));
		dataSource.setMaxPoolSize(Integer.valueOf(maxPoolSize));
		dataSource.setNumHelperThreads(Integer.valueOf(numHelperThreads));
		dataSource.setMaxStatements(Integer.valueOf(maxStatements));
		dataSource.setMaxIdleTime(Integer.valueOf(maxIdleTime));
		dataSource.setIdleConnectionTestPeriod(Integer.valueOf(idleConnectionTextPeriod));
	
		return dataSource;
	}

	// @Bean(name = "mysqlDS")
	// @Primary //默认数据源
	// @ConfigurationProperties(prefix = "datasource.mysql")
	// public DataSource mysqlDataSource() {
	// return DataSourceBuilder.create().build();
	// }
	//
	// @Bean(name = "oracleDS")
	// @ConfigurationProperties(prefix = "datasource.oracle")
	// public DataSource oracleDataSource() {
	// return DataSourceBuilder.create().build();
	// }
}
