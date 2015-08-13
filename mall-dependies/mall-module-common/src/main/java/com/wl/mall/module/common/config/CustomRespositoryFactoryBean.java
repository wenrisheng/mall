package com.wl.mall.module.common.config;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Component;

import com.wl.mall.module.common.dao.BaseRepository;
import com.wl.mall.module.common.dao.impl.BaseRepositoryImpl;

//@Component
//@Primary
public class CustomRespositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
		return new CustomRespositoryFactory(em);
	}

	private static class CustomRespositoryFactory<T, I extends Serializable>
			extends JpaRepositoryFactory {

		private final EntityManager em;

		public CustomRespositoryFactory(EntityManager em) {

			super(em);
			this.em = em;
		}

		protected Object getTargetRepository(RepositoryMetadata metadata) {
			metadata.getDomainType();
			return new BaseRepositoryImpl<T, I>(
					(Class<T>) metadata.getDomainType(), em);
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return BaseRepository.class;
		}
	}
}
