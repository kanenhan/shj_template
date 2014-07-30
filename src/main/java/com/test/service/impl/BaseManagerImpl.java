package com.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.BaseDao;
import com.test.service.BaseManager;

/**
 * @author Han Manyi
 **/
public class BaseManagerImpl<T> implements BaseManager<T> {
	@Autowired
	private BaseDao<T> baseDao;
	@Override
	public void add(T t) throws Exception {
		baseDao.add(t);
	}

	@Override
	public void update(T t) throws Exception {
		baseDao.update(t);
	}

	@Override
	public void deleteById(Serializable id) throws Exception {
		baseDao.deleteById(id);
	}

	@Override
	public T findById(Serializable id) throws Exception {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findAll() throws Exception {
		return baseDao.findAll();
	}

}
