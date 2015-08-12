package com.wl.mall.module.common.config.database;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wl.mall.module.common.config.factory.AbstractProductFactory;

@Configuration
//启用注解式事务管理 <tx:annotation-driven />
@EnableTransactionManagement
public class TransactionManagerProductFactory extends AbstractProductFactory<PlatformTransactionManager> {
	private static final Logger logger = LoggerFactory.getLogger(TransactionManagerProductFactory.class);
	@Resource(name = "entityManagerFactory")
	private Object managerFactory;
	
	@Override
	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager product() {
		PlatformTransactionManager transactionManager = null;
		try {
		switch (this.getDatabaseConfig().getTransactionType()) {
		case 0:
		{
			transactionManager = this.jpaTransactionManager();
		}
			break;
		case 1:
		{
			transactionManager = this.hibernateTransactionManager();
		}
			break;
		default:
			break;
		}
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionManager;
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws PropertyVetoException
	 */
	public PlatformTransactionManager jpaTransactionManager() throws PropertyVetoException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) managerFactory;
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		logger.info("\n####################### 配置事务管理类JpaTransactionManager ########################\n");
		return transactionManager;
	}
	
	public PlatformTransactionManager hibernateTransactionManager() {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		SessionFactory sessionFactory = (SessionFactory)managerFactory;
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		logger.info("\n####################### 配置事务管理类HibernateTransactionManager ########################\n");

		return hibernateTransactionManager;
	}
}
