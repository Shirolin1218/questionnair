package com.example.questionnair.constants;

public enum RtnCode {

	SUCCESSFUL("200", "successful!!"), //
	CANNOT_EMPTY("400", "can't empty!!"), //
	NOT_FOUND("404", "not found!!"), //
	FAILD("400", "faild!"), //
	
	;

	private String code;
	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
