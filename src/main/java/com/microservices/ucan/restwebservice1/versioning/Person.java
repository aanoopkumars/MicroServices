package com.microservices.ucan.restwebservice1.versioning;

public class Person {
	
	private String name;
	private int age;
	private String occupation;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getOccupation() {
		return occupation;
	}
	
	public Person(String name, int age, String occupation) {
		super();
		this.name = name;
		this.age = age;
		this.occupation = occupation;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", occupation=" + occupation + "]";
	}
	
	
	

}
