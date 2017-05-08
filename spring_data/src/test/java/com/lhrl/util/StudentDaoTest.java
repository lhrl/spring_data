package com.lhrl.util;

import java.util.List;

import org.junit.Test;

import com.lhrl.dao.StudentDao;
import com.lhrl.dao.StudentDaoImpl;
import com.lhrl.domain.Student;

public class StudentDaoTest {

	@Test
	public void query(){
		StudentDao studentDao=new StudentDaoImpl();
		List<Student>list=studentDao.query();
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
	
	//@Test
	public void save(){
		StudentDao studentDao=new StudentDaoImpl();
		Student student=new Student();
		student.setName("admin");
		student.setAge(30);
		studentDao.save(student);
	}
}
