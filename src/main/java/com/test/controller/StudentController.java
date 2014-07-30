package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.Student;
import com.test.service.StudentManager;

/**
 * @author Han Manyi
 **/
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentManager studentManager;
	/**
	 * 按照id删除
	 * @author FengJianBo
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * 2014年3月25日 下午1:37:16
	 */
	@RequestMapping(value="/deleteById.do")
	public String deleteById(HttpServletRequest request, HttpServletResponse response){
		try{
			String id = request.getParameter("id");
			if(StringUtils.isNotEmpty(id)){
				studentManager.deleteById(id);
			}
		} catch(Exception e){
		}
			
		return "redirect:../../"+request.getContextPath();
	}
	/**
	 * 表单提交
	 * @author FengJianBo
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * 2014年3月25日 下午1:37:16
	 */
	@RequestMapping(value="/submit.do")
	public String submit(Student student,HttpServletRequest request, HttpServletResponse response){
		try{
			if(student != null){
				if(StringUtils.isNotEmpty(student.getId())){
					this.studentManager.update(student);
				} else {
					this.studentManager.add(student);
				}
			}
		} catch(Exception e){
		}
			
		return "redirect:../../"+request.getContextPath()+"/student/showAll.do";
	}
	/**
	 * 显示详细信息
	 * @author FengJianBo
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * 2014年3月25日 下午1:37:16
	 */
	@RequestMapping(value="/showInfo.do")
	public String showInfo(HttpServletRequest request, HttpServletResponse response){
		Student student = null;
		try{
			String id = request.getParameter("id");
			if(StringUtils.isNotEmpty(id)){
				student = studentManager.findById(id);
			}
			if(student == null){
				student = new Student();
			}
		} catch(Exception e){
		}
		request.setAttribute("student", student);
		return "student/add";
	}
	/**
	 * 表单提交
	 * @author FengJianBo
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * 2014年3月25日 下午1:37:16
	 */
	@RequestMapping(value="/showAll.do")
	public String showAll(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setAttribute("students", studentManager.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "student/showAll";
	}
	public static void main(String[] args) {
		System.out.println("ddd");
	}
}
