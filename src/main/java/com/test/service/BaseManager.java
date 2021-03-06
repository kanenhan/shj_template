package com.test.service;

import java.io.Serializable;
import java.util.List;

/**
 * 业务层父接口
 * @author Han Manyi
 **/
public interface BaseManager<T> {
	/**
	 * 根据对象添加
	 * @param t
	 * @throws Exception
	 */
	public void add(T t) throws Exception;
	/**
	 * 根据对象修改
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception;
	/**
	 * 按照id删除对象
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(Serializable id) throws Exception;
	/**
	 * 按照id查询对象
	 * @param id
	 * @throws Exception
	 */
	public T findById(Serializable id) throws Exception;
	/**
	 * 查询全部
	 * @throws Exception
	 */
	public List<T> findAll() throws Exception;
}
