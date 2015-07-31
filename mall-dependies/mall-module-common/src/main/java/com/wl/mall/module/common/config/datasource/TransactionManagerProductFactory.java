package com.wl.mall.module.common.config.datasource;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import com.wl.mall.module.common.config.util.AbstractProductFactory;

@Configuration
public class TransactionManagerProductFactory extends AbstractProductFactory<PlatformTransactionManager> {

	@Resource
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager product() {
		// TODO Auto-generated method stub
		PlatformTransactionManager transactionManager = null;
		try {
		switch (this.getDatabaseConfig().getTransactionType()) {
		case 0:
		{
			transactionManager = this.jpaTransactionManager();
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

	public PlatformTransactionManager jpaTransactionManager() throws PropertyVetoException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
}
