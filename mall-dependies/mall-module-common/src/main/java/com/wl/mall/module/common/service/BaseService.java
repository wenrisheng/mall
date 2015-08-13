package com.wl.mall.module.common.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {
	public abstract void save(T entity);

	public abstract void delete(ID id);
	
	public abstract void delete(T entity);

	public abstract void get(ID id);
	
	public abstract void update(T entity);

	public abstract void saveOrUpdate(T entity);


}
