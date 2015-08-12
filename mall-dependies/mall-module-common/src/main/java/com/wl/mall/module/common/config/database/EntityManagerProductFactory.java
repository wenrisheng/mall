package com.wl.mall.module.common.config.database;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.wl.mall.module.common.config.factory.AbstractProductFactory;


@Configuration
@PropertySource("classpath:scan_entity.properties")
public class EntityManagerProductFactory extends
AbstractProductFactory<Object> {
	private static final Logger logger = LoggerFactory.getLogger(EntityManagerProductFactory.class);
	@Resource
	DataSource dataSource;
	@Value("${scan.entity_path}")
	private String entity_path;
	
	@Override
	@Bean(name = "entityManagerFactory")
	//@Primary
	public Object product() {
		Object obj  = null;
		try {
		switch (this.getDatabaseConfig().getFactoryType()) {
		case 0:
		{	
			obj = this.jpaEntityManagerFactory();
		}
			break;
		case 1:
		{	
			obj = this.localSessionFactoryBean();
		}
			break;
		default:
			break;
		}
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * jpa 实体管理类
	 * 自定义一个名字为entityManagerFactory的EntityManagerFactory后，spring boot 会关闭它本身的EntityManagerFactory
	 * 
	 * @return
	 * @throws PropertyVetoException
	 */
	private EntityManagerFactory jpaEntityManagerFactory()
			throws PropertyVetoException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(false);
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
		logger.info("\n####################### 配置实体管理类工厂EntityManagerFactory ########################\n");
		return entityManagerFactory;
	}

	/**
	 * hibernate sessionFactory
	 * @return
	 */
	public SessionFactory localSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(entity_path);
		sessionFactoryBean.setHibernateProperties(getHibernteProperties());
		SessionFactory sessionFactory = sessionFactoryBean.getObject();
		logger.info("\n####################### 配置实体Hibernate SessionFactory ########################\n");

		return sessionFactory;

	}
	
	private Properties getHibernteProperties() {
		Properties properties = new Properties();
		try {
			ClassPathResource classPathResource = new ClassPathResource("hibernate.properties");
			InputStream inputStream = classPathResource.getInputStream();
			properties.load(inputStream);
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
