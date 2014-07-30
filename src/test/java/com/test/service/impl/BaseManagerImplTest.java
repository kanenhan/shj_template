package com.test.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.model.Student;
import com.test.service.StudentManager;

/**
 * BaseManagerImpl 测试类
 * @author root
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//load your standard Spring configuration 
//连接开发库的配置
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//链接测试库的配置
@ContextConfiguration(locations={"file:src/test/resources/applicationContext.xml"})
//Add the listener
public class BaseManagerImplTest {

	@Autowired
	private StudentManager studentManager;
	
	@Before
	public void init(){
		System.out.println("init nothing now");
	}
	
	@Test
	public void testAdd() throws Exception{
		Student student = new Student();
//		String id = UUID.randomUUID().toString();
//		student.setId(id);
		student.setName("hanmanyi-test" + (int)(Math.random()*10000000));
		student.setAge(22);
		student.setSex("man");
		studentManager.add(student);
		Student ret = studentManager.findById(student.getId());

		Assert.assertEquals("testAdd faild ",student.getId(), ret.getId());
		Assert.assertEquals("testAdd faild ",student.getName(), ret.getName());
		Assert.assertEquals("testAdd faild ",student.getAge(), ret.getAge());
		Assert.assertEquals("testAdd faild ",student.getSex(), ret.getSex());
	}
	
}