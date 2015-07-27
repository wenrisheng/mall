package com.wl.mall.module.common.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
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

}
