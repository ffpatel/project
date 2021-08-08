package com.gameOfThrones.got;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultEntity {
	String dataEntity;
	String message;
	public ResultEntity(String dataEntity, String message) {
		super();
		this.dataEntity = dataEntity;
		this.message = message;
	}
	public ResultEntity() {
		
	}

}
