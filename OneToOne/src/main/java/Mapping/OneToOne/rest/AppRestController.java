package Mapping.OneToOne.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Mapping.OneToOne.entity.InstructorDetail;
import Mapping.OneToOne.service.AppService;

@RestController
@RequestMapping("/oto")
public class AppRestController {
	
	
	private final AppService appService;
	
	@Autowired
	public AppRestController(AppService appService) {
		
		this.appService=appService;
	}
	
	@PostMapping("/instructordetail")
	public ResponseEntity<InstructorDetail> addInstructorDetail(@RequestBody InstructorDetail instructorDetail, @RequestHeader(value="Client_Trusted_Call")String clientTrustCall) {
		
		
		if ("True".equals(clientTrustCall)) {
			
			InstructorDetail addedInstructorDetails= appService.add(instructorDetail);
			return ResponseEntity.status(HttpStatus.CREATED).body(addedInstructorDetails);
		}
		else
			
		{
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
			
		
	}
	
	@PutMapping("/instructordetail/{id}")
	public ResponseEntity<InstructorDetail> updateInstructorDetail (@RequestBody InstructorDetail instructorDetail,@PathVariable Long id) {
		
		InstructorDetail existingInstructorDetail = appService.get(id);
		
		if (existingInstructorDetail == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		
		else 
			
		{
			existingInstructorDetail.setHobby(instructorDetail.getHobby());
			existingInstructorDetail.setYoutubeChannel(instructorDetail.getYoutubeChannel());
			
		
		    
			InstructorDetail updatedData = appService.add(existingInstructorDetail);
			
			System.out.println(updatedData.toString());
			
			return ResponseEntity.ok(updatedData);
		}
		}
		
		
		

}
