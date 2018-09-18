package com.agil8.refactoring.z;

public class ResponseMsg {
	private String message;
	private AccountOpenApp.ErrorCode errorCode;
	private int id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AccountOpenApp.ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(AccountOpenApp.ErrorCode code) {
		this.errorCode = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
