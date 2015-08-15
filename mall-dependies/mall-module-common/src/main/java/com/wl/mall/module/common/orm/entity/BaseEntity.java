package com.wl.mall.module.common.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.groups.Default;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wl.mall.module.common.orm.listener.EntityListener;


/**
 * Entity 基类
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
@EntityListeners({EntityListener.class})
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 856229867161644729L;

	public static final String ID_FIELD_NAME = "I_ID";					// 主键字段名
	public static final String CREATE_DATE_FIELD_NAME = "D_CREATE_DATE";	// 创建时间字段名
	public static final String MODIFY_DATE_FIELD_NAME = "D_MODIFY_DATE";	// 修改时间字段名
	
	/**
	 * 保存验证组

	 *
	 */
	public abstract interface Save extends Default {}

	/**
	 * 更新验证组

	 *
	 */
	public abstract interface Update extends Default {}
	
	private Long id;
	private Date createDate;
	private Date modifyDate;
	
	@JsonProperty
//	@DocumentId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "I_ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty
//	@Field(store = Store.YES, index = Index.YES)
//	@DateBridge(resolution = Resolution.SECOND)
	@Column(name = "D_CREATE_DATE", nullable = false, updatable = false)
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@JsonProperty
//	@Field(store = Store.YES, index = Index.YES)
//	@DateBridge(resolution = Resolution.SECOND)
	@Column(name = "D_MODIFY_DATE", nullable = false)
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	/*
	 * =------------------------------------------------------------=
	 * Generate equals & hashCode methods
	 * =------------------------------------------------------------=
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity entity = (BaseEntity) obj;
		return getId() != null ? getId().equals(entity.getId()) : false;
	}

	public int hashCode() {
		int i = 17;
		i += (getId() == null ? 0 : getId().hashCode() * 31);
		return i;
	}
	
}
