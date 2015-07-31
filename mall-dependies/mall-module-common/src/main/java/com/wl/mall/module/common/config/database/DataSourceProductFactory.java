package com.wl.mall.module.common.config.database;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wl.mall.module.common.config.util.AbstractProductFactory;
import com.wl.mall.module.common.config.util.ConnectionProperties;

@Configuration
public class DataSourceProductFactory extends AbstractProductFactory<DataSource> {

	@Resource
	private ConnectionProperties connectionProperties;
	
	@Override
	@Bean(name = "dataSource")
	@Primary
	public DataSource product() {
		// TODO Auto-generated method stub
		DataSource dataSource = null;
		try {
			switch (this.getDatabaseConfig().getDatasourceType()) {
			case 0: {

				dataSource = this.comboPooledDataSource();

			}
				break;
			case 1: {
				dataSource = this.druidDataSource();
			}
			break;
			case 2: {
				dataSource = this.basicDataSource();
			}
			break;
			default:
				break;
			}
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}

	private DataSource comboPooledDataSource() throws PropertyVetoException {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(connectionProperties.getDriverClassName());
		dataSource.setJdbcUrl(connectionProperties.getUrl());
		dataSource.setUser(connectionProperties.getUserName());
		dataSource.setPassword(connectionProperties.getPassword());
		dataSource.setAcquireIncrement(connectionProperties.getAcquireIncrement());
		dataSource.setInitialPoolSize(connectionProperties.getInitialPoolSize());
		dataSource.setMinPoolSize(connectionProperties.getMinPoolSize());
		dataSource.setMaxPoolSize(connectionProperties.getMaxPoolSize());
		dataSource.setNumHelperThreads(connectionProperties.getNumHelperThreads());
		dataSource.setMaxStatements(connectionProperties.getMaxStatements());
		dataSource.setMaxIdleTime(connectionProperties.getMaxIdleTime());
		dataSource.setIdleConnectionTestPeriod(connectionProperties
				.getIdleConnectionTextPeriod());

		return dataSource;
	}

	/**
	 * druidDataSource数据源
	 * 
	 * @return
	 */
	private DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(connectionProperties.getDriverClassName());
		dataSource.setUrl(connectionProperties.getUrl());
		dataSource.setUsername(connectionProperties.getUserName());
		dataSource.setPassword(connectionProperties.getPassword());
		dataSource.setInitialSize(connectionProperties.getInitialPoolSize());
		dataSource.setMaxActive(connectionProperties.getMaxPoolSize());
		dataSource.setMinEvictableIdleTimeMillis(connectionProperties
				.getMaxIdleTime());
		dataSource.setMaxOpenPreparedStatements(connectionProperties
				.getMaxStatements());

		return dataSource;
	}

	/**
	 * spring jdbc
	 * 
	 * @return
	 */
	private DataSource driverManagerDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(connectionProperties.getUrl());
		dataSource.setUsername(connectionProperties.getUserName());
		dataSource.setPassword(connectionProperties.getPassword());
		dataSource.setDriverClassName(connectionProperties.getDriverClassName());

		return dataSource;
	}

	/**
	 * JDBC apache
	 * 
	 * @return
	 */
	private DataSource basicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(connectionProperties.getUrl());
		dataSource.setDriverClassName(connectionProperties.getDriverClassName());
		dataSource.setUsername(connectionProperties.getUserName());
		dataSource.setPassword(connectionProperties.getPassword());
		dataSource.setInitialSize(connectionProperties.getInitialPoolSize());
		dataSource.setMaxIdle(connectionProperties.getMaxIdleTime());
		dataSource.setMaxActive(connectionProperties.getMaxPoolSize());
		dataSource.setMaxOpenPreparedStatements(connectionProperties
				.getMaxStatements());
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
