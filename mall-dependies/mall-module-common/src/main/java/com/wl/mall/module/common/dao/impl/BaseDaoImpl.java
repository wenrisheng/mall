package com.wl.mall.module.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.wl.mall.module.common.dao.BaseDao;
import com.wl.mall.module.common.dao.GenericsUtils;

@Component("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>  {
	 
	//@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#save(java.lang.Object)
	 */
	@Override
	public Serializable save(Object o) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().save(o);
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(o);
	}
	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(o);
		}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(o);
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#find(java.lang.String)
	 */
	@Override
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery(hql).list();
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#find(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<T> find(String hql, Object[] param) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#find(java.lang.String, java.util.List)
	 */
	@Override
	public List<T> find(String hql, List param) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#find(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		q.setFirstResult((page - 1) * rows);
		q.setMaxResults(rows);
		return q.list();
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#find(java.lang.String, java.util.List, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List find(String hql, List param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);

			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#get(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public T get(Class c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#get(java.lang.String, java.lang.Object[])
	 */
	@Override
	public T get(String hql, Object[] param) {
		// TODO Auto-generated method stub
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	
	/* (non-Javadoc)
	 * @see com.wl.mall.module.common.dao.impl.BaseDao#get(java.lang.String, java.util.List)
	 */
	@Override
	public T get(String hql, List<?> param) {
		// TODO Auto-generated method stub
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	
//	/* (non-Javadoc)
//	 * @see com.wl.mall.module.common.dao.impl.BaseDao#count(java.lang.String)
//	 */
//	@Override
//	public Long count(String hql) {
//		// TODO Auto-generated method stub
//		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see com.wl.mall.module.common.dao.impl.BaseDao#count(java.lang.String, java.lang.Object[])
//	 */
//	@Override
//	public Long count(String hql, Object[] param) {
//		// TODO Auto-generated method stub
//		Query q = this.getCurrentSession().createQuery(hql);
//		if (param != null && param.length > 0) {
//			for (int i = 0; i < param.length; i++) {
//				q.setParameter(i, param[i]);
//			}
//		}
//		return (Long) q.uniqueResult();
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see com.wl.mall.module.common.dao.impl.BaseDao#count(java.lang.String, java.util.List)
//	 */
//	@Override
//	public Long count(String hql, List<?> param) {
//		// TODO Auto-generated method stub
//		Query q = this.getCurrentSession().createQuery(hql);
//		if (param != null && param.size() > 0) {
//			for (int i = 0; i < param.size(); i++) {
//				q.setParameter(i, param.get(i));
//			}
//		}
//		return (Long) q.uniqueResult();
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see com.wl.mall.module.common.dao.impl.BaseDao#executeHql(java.lang.String)
//	 */
//	@Override
//	public Integer executeHql(String hql) {
//		// TODO Auto-generated method stub
//		return this.getCurrentSession().createQuery(hql).executeUpdate();
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see com.wl.mall.module.common.dao.impl.BaseDao#executeHql(java.lang.String, java.lang.Object[])
//	 */
//	@Override
//	public Integer executeHql(String hql, Object[] param) {
//		// TODO Auto-generated method stub
//		Query q = this.getCurrentSession().createQuery(hql);
//		if (param != null && param.length > 0) {
//			for (int i = 0; i < param.length; i++) {
//				q.setParameter(i, param[i]);
//			}
//		}
//		return q.executeUpdate();
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see com.wl.mall.module.common.dao.impl.BaseDao#executeHql(java.lang.String, java.util.List)
//	 */
//	@Override
//	public Integer executeHql(String hql, List param) {
//		// TODO Auto-generated method stub
//		Query q = this.getCurrentSession().createQuery(hql);
//		if (param != null && param.size() > 0) {
//			for (int i = 0; i < param.size(); i++) {
//				q.setParameter(i, param.get(i));
//			}
//		}
//		return q.executeUpdate();
//	}
}
