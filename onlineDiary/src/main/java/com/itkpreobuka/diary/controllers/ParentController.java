package com.itkpreobuka.diary.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.itkpreobuka.diary.controllers.util.RestError;
import com.itkpreobuka.diary.entities.ParentEntity;
import com.itkpreobuka.diary.entities.TeacherEntity;
import com.itkpreobuka.diary.entities.UserEntity;
import com.itkpreobuka.diary.entities.dto.ParentDto;
import com.itkpreobuka.diary.entities.dto.TeacherDto;
import com.itkpreobuka.diary.entities.dto.UserDto;
import com.itkpreobuka.diary.services.ParentService;

@RestController
@RequestMapping(path = "/api/v1/parent")
public class ParentController {

	@Autowired
	private ParentService parentService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")

	public ResponseEntity<?> getParentByID(@PathVariable Long id) {
		try {
			List<ParentEntity> parents = parentService.getAll();
			for (ParentEntity parentEntity : parents) {
				if (parentEntity.getId().equals(id)) {
					return new ResponseEntity<ParentEntity>(parentEntity, HttpStatus.OK);
				}
			}
			return new ResponseEntity<RestError>(new RestError(1, "Parent not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}


	@RequestMapping(method = RequestMethod.GET)

	public ResponseEntity<List<ParentDto>> getAllParents() {

		List<ParentEntity> parents = parentService.getAll();
		List<ParentDto> parentsDto = new ArrayList<>();

		for (ParentEntity p : parents) {
			parentsDto.add(new ParentDto(p));
		}
		return new ResponseEntity<>(parentsDto, HttpStatus.OK);

	}


	/*public ResponseEntity<?> createParent(@RequestBody ParentEntity newParent) {

		try {
			ParentEntity parent = parentService.save(newParent);
			if (parent != null) {
				return new ResponseEntity<ParentEntity>(parent, HttpStatus.OK);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creating failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteParent(@PathVariable Long id) {
		try {
			if(parentService.removeParent(id)) {
				
				return new ResponseEntity<RestError>(new RestError(1, "Delete successfully!"), HttpStatus.OK);}
			else {
				return new ResponseEntity<RestError>(new RestError(2, "Department not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(3, "Can't delete that department"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(method = RequestMethod.PUT , value = "/{id}") 
	public ResponseEntity<?> updateParent(@PathVariable Long id,  @RequestBody ParentDto updateParent) { 
		
		try {
			ParentEntity parent = new ParentEntity(updateParent);
			ParentDto newParent = new ParentDto (parentService.update(parent, id));
			if(parent != null) {
				
			return new ResponseEntity<>(newParent, HttpStatus.OK);
				
			}
			return new ResponseEntity<RestError>(new RestError(1,"Parent not found"), HttpStatus.NOT_FOUND);
		}catch (Exception e) { 
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		}

	@RequestMapping(method = RequestMethod.GET, value = "/firstName/{firstName}")

	ResponseEntity<?> findParentByFirstName(@PathVariable String firstName){
		try {
			Optional<ParentEntity> parents= parentService.findParentByFirstName(firstName);
			
			if(parents!=null) {
				return new ResponseEntity<ParentDto>(new ParentDto(parents.get()),HttpStatus.OK);
			
			
			}
			return new ResponseEntity<RestError>(new RestError(1, "Parent not found"), HttpStatus.NOT_FOUND);
			
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}


	@RequestMapping(method = RequestMethod.GET, value = "/lastName/{lastName}")

	ResponseEntity<?> findParentByLastName(@PathVariable String lastName){
		try {
			Optional<ParentEntity> parents= parentService.findParentByLastName(lastName);
			
			if(parents!=null) {
				return new ResponseEntity<ParentDto>(new ParentDto(parents.get()),HttpStatus.OK);
			
			
			}
			return new ResponseEntity<RestError>(new RestError(1, "Parent not found"), HttpStatus.NOT_FOUND);
			
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

	@RequestMapping(method = RequestMethod.GET, value = "/address/{address}")

	ResponseEntity<?> findParentByAdress(@PathVariable String address){
		try {
			Optional<ParentEntity> parents= parentService.findParentByAddress(address);
			
			if(parents!=null) {
				return new ResponseEntity<ParentDto>(new ParentDto(parents.get()),HttpStatus.OK);
			
			
			}
			return new ResponseEntity<RestError>(new RestError(1, "Parent not found"), HttpStatus.NOT_FOUND);
			
		}catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createParent(@RequestBody ParentDto parentDto) {
		try {
			ParentEntity p = new ParentEntity(parentDto);
			ParentDto newParent = new ParentDto(parentService.save(p));
			if (p != null) {
				return new ResponseEntity<>(newParent, HttpStatus.CREATED);
			}
			return new ResponseEntity<RestError>(new RestError(1, "Creation failed"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<RestError>(new RestError(2, "Exception occured :" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
