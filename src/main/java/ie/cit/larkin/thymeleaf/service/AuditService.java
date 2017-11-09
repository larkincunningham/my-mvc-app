package ie.cit.larkin.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.larkin.thymeleaf.entity.Audit;
import ie.cit.larkin.thymeleaf.repository.AuditRepository;

@Service
public class AuditService {

	@Autowired
	AuditRepository repo;
	
	public void add(Audit a) {
		repo.save(a);		
	}

}
