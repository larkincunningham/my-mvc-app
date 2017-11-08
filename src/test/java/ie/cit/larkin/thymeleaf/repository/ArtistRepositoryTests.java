package ie.cit.larkin.thymeleaf.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class ArtistRepositoryTests {

	@Autowired
	ArtistRepository repo;
	
	@Test
	public void countByGender() {
		assertEquals(3, repo.countByGender("female"));
		assertEquals(3, repo.countByGender("male"));
	}

}
