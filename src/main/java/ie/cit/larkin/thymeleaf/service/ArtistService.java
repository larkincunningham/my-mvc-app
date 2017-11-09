package ie.cit.larkin.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.larkin.thymeleaf.annotation.LogExecutionTime;
import ie.cit.larkin.thymeleaf.entity.Artist;
import ie.cit.larkin.thymeleaf.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	ArtistRepository repo;
	
	@LogExecutionTime
	public Iterable<Artist> findAllMales() {
		return repo.findByGender("male");
	}

	public Iterable<Artist> findAllFemales() {
		return repo.findByGender("female");
	}

	public Iterable<Artist> findAll() {
		return repo.findAll();
	}
	
	public Artist findById(int id) {
		return repo.findOne(id);
	}

	public void save(Artist artist) {
		repo.save(artist);
	}
	
}
