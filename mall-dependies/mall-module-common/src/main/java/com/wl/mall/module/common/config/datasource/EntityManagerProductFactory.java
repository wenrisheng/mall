package com.wl.mall.module.common.config.datasource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import com.wl.mall.module.common.config.util.AbstractProductFactory;
import com.wl.mall.util.io.PropertiesUtil;

@Configuration
@PropertySource("classpath:scan_entity.properties")
public class EntityManagerProductFactory extends
AbstractProductFactory<EntityManagerFactory> {

	@Resource
	DataSource dataSource;
	@Value("${scan.entity_path}")
	private String entity_path;
	
	@Override
	@Bean(name = "entityManagerFactory")
	@Primary
	public EntityManagerFactory product() {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory  = null;
		try {
		switch (this.getDatabaseConfig().getFactoryType()) {
		case 0:
		{	
		 entityManagerFactory = this.jpaEntityManagerFactory();
		}
			break;

		default:
			break;
		}
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entityManagerFactory;
	}
	
	private EntityManagerFactory jpaEntityManagerFactory()
			throws PropertyVetoException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean
				.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(entity_path);
		entityManagerFactoryBean.afterPropertiesSet();
		entityManagerFactoryBean.setJpaProperties(getHibernteProperties());
		EntityManagerFactory entityManagerFactory = entityManagerFactoryBean
				.getObject();
		return entityManagerFactory;
	}

	private Properties getHibernteProperties() {
		Properties properties = null;
		try {
			PropertiesUtil.loadProperties("classpath:hibernate.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
		// String[] keys = {
		// "hibernate.show_sql",
		// "hibernate.autoReconnect",
		// "hibernate.hbm2ddl.auto",
		// "current_session_context_class",
		// "hibernate.connection.release_mode",
		// "hibernate.cglib.use_reflection_optimizer",
		// "hibernate.format_sql"
		// };
		// for (String key : keys) {
		// properties.put(key, env.getRequiredProperty(key));
		// }
		//
		// return properties;
	}
}
