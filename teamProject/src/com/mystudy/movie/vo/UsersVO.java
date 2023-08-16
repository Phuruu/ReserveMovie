package com.mystudy.movie.vo;

public class UsersVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String joindate;
	
	public UsersVO(String id, String password, String name, int age, String joindate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.joindate = joindate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public void printAll() {
		System.out.println(id+ "\t"+ password+ "\t" + name+ "\t"+age+ "\t" + joindate );
	}
}
