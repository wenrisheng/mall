package com.wl.mall.module.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("databaseConfig")
@ConfigurationProperties(locations = {"classpath:database_config.properties"}, prefix="database")
public class DatabaseConfig {
	// 数据库类型
	private int databaseType;
	// 数据源类型
    private int datasourceType;
    // 实体工厂管理类型
    private int factoryType;
    // 事务管理类型
    private int transactionType;
    
	public int getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(int databaseType) {
		this.databaseType = databaseType;
	}
	public int getDatasourceType() {
		return datasourceType;
	}
	public void setDatasourceType(int datasourceType) {
		this.datasourceType = datasourceType;
	}
	public int getFactoryType() {
		return factoryType;
	}
	public void setFactoryType(int factoryType) {
		this.factoryType = factoryType;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	
}
