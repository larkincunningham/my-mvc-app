package ie.cit.larkin.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.larkin.thymeleaf.entity.Artist;
import ie.cit.larkin.thymeleaf.repository.ArtistRepository;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	ArtistRepository artistRepository;

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public String dash(Model model) {
		
		long count = artistRepository.count();
		
		model.addAttribute("count", count);
		
		return "report/dashboard";
	}
	
}
