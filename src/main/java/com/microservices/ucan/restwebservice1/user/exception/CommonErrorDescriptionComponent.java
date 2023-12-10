package com.microservices.ucan.restwebservice1.user.exception;

import java.time.LocalDateTime;

public class CommonErrorDescriptionComponent{
	private LocalDateTime errorTime;
	private String errorMsg;
	private String errorDesc;
	
	public CommonErrorDescriptionComponent(LocalDateTime errorTime, String errorMsg, String errorDesc) {
		super();
		this.errorTime = errorTime;
		this.errorMsg = errorMsg;
		this.errorDesc = errorDesc;
	}

	public LocalDateTime getErrorTime() {
		return errorTime;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getErrorDesc() {
		return errorDesc;
	}
	
	
	
	

}
