package com.gameOfThrones.got;

public class SaveDataResponse {
	private String message;

	public SaveDataResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}