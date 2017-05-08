package com.lhrl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.lhrl.domain.Student;

public class JdbcTemplateImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> query() {
		String sql="select id,name,age from student";
		final List<Student>list=new ArrayList<Student>();
		jdbcTemplate.query(sql, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				list.add(s);
			}
		});
		
		return list;
	}

	public void save(Student student) {
		String sql="insert into student(name,age)values(?,?)";
		jdbcTemplate.update(sql, new Object[]{student.getName(),student.getAge()});
	}

}
