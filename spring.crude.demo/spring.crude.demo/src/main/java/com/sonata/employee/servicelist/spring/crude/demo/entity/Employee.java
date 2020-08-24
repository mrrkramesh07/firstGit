package com.sonata.employee.servicelist.spring.crude.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee_info")
public class Employee {
	
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="firstname")
private String firstname;
@Column(name="age")
private int age;


public  Employee() {
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", firstname=" + firstname + ", age=" + age + "]";
}

}
