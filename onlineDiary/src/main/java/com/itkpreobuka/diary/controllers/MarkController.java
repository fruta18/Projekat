package com.itkpreobuka.diary.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itkpreobuka.diary.controllers.util.RestError;
import com.itkpreobuka.diary.entities.MarkEntity;
import com.itkpreobuka.diary.entities.StudentEntity;
import com.itkpreobuka.diary.entities.dto.MarkDto;
import com.itkpreobuka.diary.entities.dto.StudentDto;
import com.itkpreobuka.diary.services.MarkService;

@RestController
@RequestMapping(path="/api/v1/mark")
public class MarkController {
	
	@Autowired
	private MarkService markService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> writeMark(@RequestBody MarkDto markDto) {
		try {
			MarkEntity m = new MarkEntity(markDto);
			MarkDto newMark = new MarkDto(markService.saveMark(m));
			if (m != null) {
				return new ResponseEntity<>(newMark, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creating failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MarkDto>> getAll() {

		List<MarkEntity> marks = markService.getAll();
		List<MarkDto> mdto = new ArrayList<>();
		for (MarkEntity m : marks) {
			mdto.add(new MarkDto(m));
		}
		return new ResponseEntity<>(mdto, HttpStatus.OK);

	}
@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteMark(@PathVariable Long id) {
		try {
			if(markService.removeMark(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Mark not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that mark"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
