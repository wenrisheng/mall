package com.wl.mall.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:hibernate.properties")
public class TransactionManagerConfig {
	
	@Resource
	private Environment env;
	
	@Resource
    private DataSource dataSource;
	
	@Bean()
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("com.wrs.spring.boot.domain");
//		entityManagerFactoryBean
//				.setPackagesToScan(env
//						.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

		entityManagerFactoryBean.setJpaProperties(hibProperties());
		// entityManagerFactoryBean.setPackagesToScan("com.wrs.spring.boot.domain");
		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		String[] keys = {
				"hibernate.show_sql", 
				"hibernate.autoReconnect", 
				"hibernate.hbm2ddl.auto", 
				"current_session_context_class", 
				"hibernate.connection.release_mode", 
				"hibernate.cglib.use_reflection_optimizer", 
				"hibernate.format_sql"
				};
		for (String key : keys) {
			properties.put(key, env.getRequiredProperty(key));
		}
		
		return properties;
	}

	@Bean
	@Primary
	public JpaTransactionManager transactionManager() throws PropertyVetoException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		return transactionManager;
	}
}
