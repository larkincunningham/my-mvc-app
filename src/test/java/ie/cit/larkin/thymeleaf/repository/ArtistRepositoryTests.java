package ie.cit.larkin.thymeleaf.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.cit.larkin.thymeleaf.ThymeleafApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ThymeleafApplication.class)
//@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class ArtistRepositoryTests {

	@Autowired
	ArtistRepository repo;
	
	@Test
	public void countByGender() {
		assertEquals(2, repo.countByGender("female"));
		assertEquals(3, repo.countByGender("male"));
	}

}
