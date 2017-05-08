package com.lhrl.domain;

/**
 * 实体类
 * @author Administrator
 *
 */
public class Student {

	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
