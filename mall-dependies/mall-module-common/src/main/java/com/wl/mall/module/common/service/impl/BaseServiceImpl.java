package com.wl.mall.module.common.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.wl.mall.module.common.dao.BaseDao;
import com.wl.mall.module.common.dao.GenericsUtils;
import com.wl.mall.module.common.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Resource
	protected
	BaseDao<T> baseDao;
	
	@Override
	@Transactional
	public Serializable save(Object o) {
		// TODO Auto-generated method stub
		return baseDao.save(o);
	}

	@Override
	@Transactional
	public void delete(Object o) {
		// TODO Auto-generated method stub
	
		baseDao.delete(o);
	}

	@Override
	@Transactional
	public void update(Object o) {
		// TODO Auto-generated method stub
		baseDao.update(o);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdate(o);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return baseDao.find(hql);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, param);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(String hql, List<?> param) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, param);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, param, page, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, param, page, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(Class<?> c, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(c, id);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return baseDao.get(hql, param);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(String hql, List<?> param) {
		// TODO Auto-generated method stub
		return baseDao.get(hql, param);
	}

}
