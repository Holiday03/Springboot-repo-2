package Mapping.OneToOne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Mapping.OneToOne.entity.InstructorDetail;
import Mapping.OneToOne.repo.AppRepository;

@Service
public class AppService {
    
	
	private AppRepository appRepo;
	
	@Autowired
	public AppService(AppRepository appRepo) {
		this.appRepo=appRepo;
	}
	
	@Transactional
	public InstructorDetail add(InstructorDetail theInstructorDetail) {
		
		return appRepo.save(theInstructorDetail);
		
		
	}
	
	public InstructorDetail get(Long id) {
		
		
		return appRepo.findById(id).orElse(null);
	}
	
}
