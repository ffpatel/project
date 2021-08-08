package com.gameOfThrones.got;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BattlePlacesResponse {

	public Integer totalRecordsCount;
	private Map<String, List<String>> regionAndLocation;

	public BattlePlacesResponse() {
		super();
	}

	public BattlePlacesResponse(Map<String, List<String>> locAndRegion, Integer count) {
		super();
		this.regionAndLocation = locAndRegion;
		this.totalRecordsCount = count;
	}

}
