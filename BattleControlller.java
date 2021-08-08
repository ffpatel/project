package com.gameOfThrones.got;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/battle")
public class BattleControlller {

	@Autowired
	BattleService battleService;

	// TO UPLOAD DATA IN MYSQL DB
	@PostMapping("/upload")
	public ResponseEntity<SaveDataResponse> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				battleService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new SaveDataResponse(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new SaveDataResponse(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SaveDataResponse(message));
	}

	// TO GET DATA OF PLACES,REGION AND COUNT OF TOTAL RECORDS
	@GetMapping(value = "/place-data")
	public BattlePlacesResponse getBattlePlaces() {
		BattlePlacesResponse data = battleService.getBattleData();
		return data;
	}

	// TO GET DATA BY BATTLENUMBER
	@GetMapping("/{battleNumber}")
	private DataEntity getBattleData(@PathVariable("battleNumber") String battleNumber) {
		String message = "";
		try {
			return battleService.getBattleResponseByBattleNumber(battleNumber);
		} catch (Exception e) {
			message = "Entered Battle Number Not Found";
			return DataEntity.body(message);
		}
	}
}
