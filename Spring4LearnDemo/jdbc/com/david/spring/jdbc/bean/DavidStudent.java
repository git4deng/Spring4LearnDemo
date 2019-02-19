package com.david.spring.jdbc.bean;

/**
 * @描述：
 * 
 * @className:DavidStudent.java @作者： David
 * @日期 2019-02-19 22:25:46
 */
public class DavidStudent {
	private Integer id;
	private String name;
	private Integer age;
	private String grade;
	private Integer height;
	private Integer sex;
	private DavidClass dc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public DavidClass getDc() {
		return dc;
	}

	public void setDc(DavidClass dc) {
		this.dc = dc;
	}

	@Override
	public String toString() {
		return "DavidStudent [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", height=" + height
				+ ", sex=" + sex + ", dc=" + dc + "]";
	}

}
