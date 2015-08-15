package com.wl.mall.module.common.orm.listener;


import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.wl.mall.module.common.orm.entity.BaseEntity;

/**
 * 实体创建日期、修改日期处理
 */
public class EntityListener {

	/**
	 * 保存前处理
	 * @param entity
	 */
	@PrePersist
	public void prePersist(BaseEntity entity) {
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
	}

	/**
	 * 更新前处理
	 * @param entity
	 */
	@PreUpdate
	public void preUpdate(BaseEntity entity) {
		entity.setModifyDate(new Date());
	}
}
