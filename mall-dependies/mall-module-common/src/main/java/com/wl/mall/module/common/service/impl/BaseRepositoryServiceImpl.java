package com.wl.mall.module.common.service.impl;

import java.io.Serializable;
import java.util.List;

import com.wl.mall.module.common.dao.BaseRepository;
import com.wl.mall.module.common.service.BaseService;

public class BaseRepositoryServiceImpl<T, ID extends Serializable> implements
		BaseService<T, ID> {
	private BaseRepository<T, ID> baseRepository;
	

	public BaseRepository<T, ID> getBaseRepository() {
		return baseRepository;
	}

	public void setBaseRepository(BaseRepository<T, ID> baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		baseRepository.save(entity);
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		baseRepository.delete(id);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		baseRepository.delete(entity);
	}

	@Override
	public void get(ID id) {
		// TODO Auto-generated method stub
		baseRepository.getOne(id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}

	
}
