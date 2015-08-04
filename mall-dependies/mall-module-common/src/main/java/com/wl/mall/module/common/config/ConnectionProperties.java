package com.wl.mall.module.common.config;

public interface ConnectionProperties {

	public abstract String getDriverClassName();

	public abstract String getUrl();

	public abstract String getUserName();

	public abstract String getPassword();

	public abstract int getInitialPoolSize();

	public abstract int getMinPoolSize();

	public abstract int getMaxPoolSize();

	public abstract int getMaxIdleTime();

	public abstract int getAcquireIncrement();

	public abstract int getMaxStatements();

	public abstract int getIdleConnectionTextPeriod();

	public abstract int getNumHelperThreads();

}