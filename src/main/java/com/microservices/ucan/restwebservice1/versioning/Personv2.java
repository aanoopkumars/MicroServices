package com.microservices.ucan.restwebservice1.versioning;

public class Personv2 {
	
	private Name name;
	private int age;
	private String occupation;
	
	public Name getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getOccupation() {
		return occupation;
	}
	public Personv2(Name name, int age, String occupation) {
		super();
		this.name = name;
		this.age = age;
		this.occupation = occupation;
	}
	@Override
	public String toString() {
		return "Personv2 [name=" + name + ", age=" + age + ", occupation=" + occupation + "]";
	}
	
	
	
	

}
