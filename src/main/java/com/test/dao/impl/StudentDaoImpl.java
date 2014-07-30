package com.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.test.dao.StudentDao;
import com.test.model.Student;
/**
 * student接口实现类
 * @author Han Manyi
 *
 */
@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	
}
