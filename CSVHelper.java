package com.gameOfThrones.got;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "name", "year", "battle_number", "attacker_king", "defender_king", "attacker_1",
			"attacker_2", "attacker_3", "attacker_4", "defender_1", "defender_2", "defender_3", "defender_4",
			"attacker_outcome", "battle_type", "major_death", "major_capture", "attacker_size", "defender_size",
			"attacker_commander", "defender_commander", "summer", "location", "region", "note" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<DataEntity> csvToDataBase(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<DataEntity> dataList = new ArrayList<DataEntity>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				DataEntity data = new DataEntity(csvRecord.get("name"), csvRecord.get("year"), csvRecord.get("battle_number"),
						csvRecord.get("attacker_king"), csvRecord.get("defender_king"),csvRecord.get("attacker_1"),
						csvRecord.get("attacker_2"), csvRecord.get("attacker_3"), csvRecord.get("attacker_4"),
						csvRecord.get("defender_1"), csvRecord.get("defender_2"), csvRecord.get("defender_3"),
						csvRecord.get("defender_4"), csvRecord.get("attacker_outcome"), csvRecord.get("battle_type"),
						csvRecord.get("major_death"), csvRecord.get("major_capture"), csvRecord.get("attacker_size"),
						csvRecord.get("defender_size"), csvRecord.get("attacker_commander"),
						csvRecord.get("defender_commander"), csvRecord.get("summer"), csvRecord.get("location"),
						csvRecord.get("region"), csvRecord.get("note"));

				
				
				dataList.add(data);
			}

			return dataList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
