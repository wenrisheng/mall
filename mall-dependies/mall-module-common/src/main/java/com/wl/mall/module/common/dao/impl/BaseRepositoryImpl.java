package com.wl.mall.module.common.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.wl.mall.module.common.dao.BaseRepository;


public class BaseRepositoryImpl <T, ID extends Serializable>
extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{
	
	private final EntityManager entityManager;
	private final Class<T> domainClass;
	
	
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
		this.domainClass = domainClass;
	}
	@Override
	public List<T> getByJql(String jql) {
		Query query = entityManager.createQuery(jql);

		return query.getResultList();
	}
	@Override
	public List<T> find(Map<Object, Object> fieldParams, Integer type) {
		List<T>  results = this.findAll(new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				 List<Predicate> predicates = new ArrayList<>();
				// 创建firstName的查询条件，使用静态元模型  
				for(Entry<Object, Object> tempEntry : fieldParams.entrySet()){ 
					Object value = tempEntry.getValue();
					if (null != value) {
						String key = (String)tempEntry.getKey();
						Predicate predicate = cb.like(root.get(key), "%"+ value +"%");
					    predicates.add(predicate);
					} 
				}   
				Predicate[] pre = new Predicate[predicates.size()];
			
                return query.where(predicates.toArray(pre)).getRestriction();
			}
		});

		return results;
		
	}

}
