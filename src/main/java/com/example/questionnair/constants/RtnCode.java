package com.example.questionnair.constants;

public enum RtnCode {

	SUCCESSFUL("200", "successful!!"), //
	CANNOT_EMPTY("400", "can't empty!!"), //
	NOT_FOUND("404", "not found!!"), //
	FAILD("400", "faild!"), //
	BAD_REQUEST("400", "can't get the request!!"), //
	BAD_VALUE("400", "bad or empty value!!"), //
	REPEAT_TITLE("400", "title can't be repeated!!"), //
	NO_DATA_UPDATED("400", "no data updated!!"),//
	CANNOT_FIND_QUESTIONNAIRE("400", "can't find the questionnaire!!"),//
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
