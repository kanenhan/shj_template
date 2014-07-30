package com.test.service.impl;

import org.springframework.stereotype.Service;

import com.test.model.Student;
import com.test.service.StudentManager;

/**
 * @author Han Manyi
 **/
@Service("studentManager")
public class StudentManagerImpl extends BaseManagerImpl<Student> implements StudentManager {

}
