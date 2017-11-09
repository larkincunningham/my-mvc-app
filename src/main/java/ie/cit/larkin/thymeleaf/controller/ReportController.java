package ie.cit.larkin.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.larkin.thymeleaf.entity.Audit;
import ie.cit.larkin.thymeleaf.repository.ArtistRepository;
import ie.cit.larkin.thymeleaf.repository.AuditRepository;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	ArtistRepository artistRepository;

	@Autowired
	AuditRepository auditRepository;
	
	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public String dash(Model model) {
		
		long count = artistRepository.count();
		
		model.addAttribute("count", count);
		
		return "report/dashboard";
	}

	@RequestMapping(value = "/audit", method = RequestMethod.GET)
	public String audit(Model model) {
		
		Iterable<Audit> audits = auditRepository.findAll();
		
		model.addAttribute("audits", audits);
		
		return "report/audittrail";
	}
	
}
