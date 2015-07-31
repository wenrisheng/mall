package com.wl.mall.module.common.config.util;

import javax.annotation.Resource;

public abstract class AbstractProductFactory<T> implements ProductFactory<T> {

	@Resource(name = "databaseConfig")
	DatabaseConfig databaseConfig;

	public DatabaseConfig getDatabaseConfig() {
		return databaseConfig;
	}

	public void setDatabaseConfig(DatabaseConfig databaseConfig) {
		this.databaseConfig = databaseConfig;
	}

}
