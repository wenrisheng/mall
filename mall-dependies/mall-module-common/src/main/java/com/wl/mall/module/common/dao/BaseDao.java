package com.wl.mall.module.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	public abstract Serializable save(Object o);

	public abstract void delete(Object o);

	public abstract void update(Object o);

	public abstract void saveOrUpdate(Object o);

	public abstract List<T> find(String hql);

	public abstract List<T> find(String hql, Object[] param);

	public abstract List<T> find(String hql, List<?> param);

	public abstract List<T> find(String hql, Object[] param, Integer page,
			Integer rows);

	public abstract List<T> find(String hql, List<Object> param, Integer page, Integer rows);

	public abstract T get(Class<?> c, Serializable id);

	public abstract T get(String hql, Object[] param);

	public abstract T get(String hql, List<?> param);

//	public abstract Long count(String hql);
//
//	public abstract Long count(String hql, Object[] param);
//
//	public abstract Long count(String hql, List<?> param);
//
//	public abstract Integer executeHql(String hql);
//
//	public abstract Integer executeHql(String hql, Object[] param);
//
//	public abstract Integer executeHql(String hql, List<?> param);

}