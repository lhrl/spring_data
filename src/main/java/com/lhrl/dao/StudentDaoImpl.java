package com.lhrl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lhrl.domain.Student;
import com.lhrl.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao{

	public List<Student> query() {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		String sql="select id,name,age from student";
		List<Student>list=new ArrayList<Student>();
		try {
			connection=JDBCUtil.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.freed(rs, preparedStatement, connection);
		}
		return list;
	}

	public void save(Student student) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		String sql="insert into student(name,age)values(?,?)";
		try {
			connection=JDBCUtil.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.freed(rs, preparedStatement, connection);
		}
	}

}
