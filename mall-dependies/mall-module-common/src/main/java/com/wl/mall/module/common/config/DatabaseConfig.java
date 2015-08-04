package com.wl.mall.module.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("databaseConfig")
@ConfigurationProperties(locations = {"classpath:database_config.properties"}, prefix="database")
public class DatabaseConfig {
	private int databaseType;
    private int datasourceType;
    private int factoryType;
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
