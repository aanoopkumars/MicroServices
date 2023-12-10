package com.microservices.ucan.restwebservice1.helloworld;

public class HelloWorldBean {
	private String memberName;

	public HelloWorldBean(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [memberName=" + memberName + "]";
	}
	
	
	
	
}
