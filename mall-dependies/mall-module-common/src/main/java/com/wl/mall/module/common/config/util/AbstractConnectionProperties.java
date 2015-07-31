package com.wl.mall.module.common.config.util;

import org.hibernate.validator.constraints.NotBlank;

public abstract class AbstractConnectionProperties implements ConnectionProperties {
	// 驱动class名
	@NotBlank
	private String driverClassName;
	// 数据库连接url
	@NotBlank
	private String url;
	// 用户名
	@NotBlank
	private String userName;
	// 密码
	@NotBlank
	private String password;
	
	// 初始化连接池的连接数量
	private int initialPoolSize;
	// 连接池保留的最小连接数
	private int minPoolSize;
	// 连接池保留的最大连接数
	private int maxPoolSize;
	// 最大空闲时间，超过这个时间未使用则连接被丢弃
	private int maxIdleTime;
	// 连接池的连接耗尽时一次产生的连接数量
	private int acquireIncrement;
	// 连接池内单个连接所拥有的最大缓存statements数
	private int maxStatements;
	// 连接池检查空闲连接数的间隔时间
	private int idleConnectionTextPeriod;

	private int numHelperThreads;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}

	public int getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	public int getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public int getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}

	public int getIdleConnectionTextPeriod() {
		return idleConnectionTextPeriod;
	}

	public void setIdleConnectionTextPeriod(int idleConnectionTextPeriod) {
		this.idleConnectionTextPeriod = idleConnectionTextPeriod;
	}

	public int getNumHelperThreads() {
		return numHelperThreads;
	}

	public void setNumHelperThreads(int numHelperThreads) {
		this.numHelperThreads = numHelperThreads;
	}

}
