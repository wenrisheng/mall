package com.wl.mall.module.common.config.database;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wl.mall.module.common.config.ConnectionProperties;
import com.wl.mall.module.common.config.factory.AbstractProductFactory;

@Configuration
public class DataSourceProductFactory extends AbstractProductFactory<DataSource> {
	 private static final Logger logger = Logger  
	            .getLogger(DataSourceProductFactory.class); 
	@Resource
	private ConnectionProperties connectionProperties;
	
	/**
	 * 定义了DataSource类型的@Bean 会覆盖默认设置
	 * 
	 */
	@Override
	@Bean(name = "dataSource")
	//@Primary
	public DataSource product() {
		logger.info("\n###############################################\n");
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
		logger.info("\n####################数据库url: "+ connectionProperties.getUrl() +"###########################\n");

		logger.info("\n###############################################\n");
		return dataSource;
	}

	/**
	 * c3po 
	 * 
	 * @return
	 * @throws PropertyVetoException
	 */
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
		logger.info("\n####################### 配置c3po数据源 ########################\n");
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
		logger.info("\n####################### 配置druidDataSource数据源 ########################\n");

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
		logger.info("\n####################### 配置spring jdbc 数据源########################\n");

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
		logger.info("\n####################### 配置JDBC apache数据源 ########################\n");

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
