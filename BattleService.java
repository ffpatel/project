package com.gameOfThrones.got;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BattleService {

	@Autowired
	SaveDataRepo saveDataRepo;

	@Autowired
	BattleDataRepo battleDataRepo;

	@Autowired
	PlaceDataRepo placeDataRepo;

	// TO UPLOAD DATA IN MYSQL DB
	public void save(MultipartFile file) {
		try {
			List<DataEntity> listData = CSVHelper.csvToDataBase(file.getInputStream());
			saveDataRepo.saveAll(listData);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	// TO GET DATA OF PLACES,REGION AND COUNT OF TOTAL RECORDS
	public BattlePlacesResponse getBattleData() {
		BattlePlacesResponse bpr = new BattlePlacesResponse();
		List<DataEntity> listData = placeDataRepo.findAll();
		Map<String, List<String>> mapObj = new HashMap<>();
		
		if (null != listData && !listData.isEmpty()) {
			for (DataEntity data : listData) {
				if (null == mapObj.get(data.getRegion())) {
					List<String> loc1 = new ArrayList<>();
					loc1.add(data.getLocation());
					mapObj.put(data.getRegion(), loc1);

				} else {
					List<String> loc2 = mapObj.get(data.getRegion());
					loc2.add(data.getLocation());
					mapObj.put(data.getRegion(), loc2);
				}
			}
		}
		Integer count = listData.size();
		bpr.setTotalRecordsCount(count);
		bpr.setRegionAndLocation(mapObj);
		return bpr;
	}

	// TO GET DATA BY BATTLENUMBER
	public DataEntity getBattleResponseByBattleNumber(String battleNumber) throws Exception {
		try {
			DataEntity	d = battleDataRepo.findById(battleNumber).get();
			return d;

		} catch (Exception e) {
			throw new Exception("BattleNumber Not Found : " + battleNumber);
		}

	}

}