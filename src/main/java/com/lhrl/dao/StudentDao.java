package com.lhrl.dao;


import java.util.List;
import com.lhrl.domain.Student;

/**
 * 数据库访问层
 * @author Administrator
 *
 */
public interface StudentDao {

	public List<Student>query();
	
	
	public void save(Student student);
	
}
