package com.wl.mall.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wl.mall.module.common.dao.BaseDao;
import com.wl.mall.module.common.dao.impl.BaseDaoImpl;

//@Configuration
////启用注解事务管理，使用CGLib代理
//@EnableTransactionManagement(proxyTargetClass = true)
public class HibernateConfig {
	
	private static final Logger logger = Logger.getLogger(HibernateConfig.class);

	@Resource(name="dataSource")
	private DataSource dataSource;
	
	@Bean(name = "sessionFactory")
	public SessionFactory localSessionFactory() {
		logger.info("sessionFactory");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		String[] packagesToScan = new String[] { "web.function.**.model.oracle" };
		sessionFactory.setPackagesToScan(packagesToScan);

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "");
		hibernateProperties.setProperty("hibernate.show_sql",
				"");
		hibernateProperties.setProperty(
				"hibernate.current_session_context_class",
				"org.springframework.orm.hibernate4.SpringSessionContext");
		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory.getObject();

	}
	
//	@Bean(name = "hibernateDAO")
//	public BaseDao<T> hibernate4Dao() {
//		logger.info("hibernateDAO");
//		BaseDaoImpl<T> dao = new CP_Hibernate4DAOImpl();
//		dao.setSessionFactory(localSessionFactoryBean().getObject());
//		return dao;
//	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager hibernateTransactionManager() {
		logger.info("transactionManager");
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(localSessionFactory());
		return hibernateTransactionManager;
	}

}
