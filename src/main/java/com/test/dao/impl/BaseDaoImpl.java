package com.test.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.test.dao.BaseDao;

/**
 * 父接口实现类
 * @author Han Manyi
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired  
    @Qualifier("sessionFactory")  
    private SessionFactory sessionFactory;
	
	/**
	 * 得到泛型中的实体类型
	 * @author FengJianBo
	 * @return
	 * 2014年3月18日 下午2:32:35
	 */
	protected Class<T> getEntityClass(){
		@SuppressWarnings("unchecked")
		Class<T> entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return entityClass;
	}
	/**
	 * 获取主键名
	 * @author FengJianBo
	 * @return
	 * 2014年3月21日 下午2:42:49
	 */
	public String getPkColunmName(){
		ClassMetadata meta = sessionFactory.getCurrentSession().getSessionFactory().getClassMetadata(getEntityClass());
		return meta.getIdentifierPropertyName();
	}
	
	
	/**
	 * 获取实体类型名
	 * @author FengJianBo
	 * @return
	 * 2014年3月18日 下午2:33:01
	 */
	protected String getEntityClassName() {
		ClassMetadata meta = sessionFactory.getCurrentSession().getSessionFactory().getClassMetadata(getEntityClass());
		return meta.getEntityName();
	}
	
	@Override
	public void add(T t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(T t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void deleteById(Serializable id) throws Exception {
		String hql = "delete " + getEntityClassName() + " where "+getPkColunmName()+"=?";
		executeUpdate(hql,id);
	}

	@Override
	public T findById(Serializable id) throws Exception {
		return (T)sessionFactory.getCurrentSession().get(getEntityClass(), id);
	}

	@Override
	public List<T> findAll() throws Exception {
		String hql = "from " + getEntityClassName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	/**
	 * 执行查询以外的操作
	 * @author FengJianBo
	 * @param hql
	 * @param objs
	 * 2014年3月21日 上午11:42:19
	 */
	protected void executeUpdate(final String hql, final Object ... objects)  throws Exception{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}
}
