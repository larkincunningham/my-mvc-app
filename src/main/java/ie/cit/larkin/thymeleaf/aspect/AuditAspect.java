package ie.cit.larkin.thymeleaf.aspect;

import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ie.cit.larkin.thymeleaf.annotation.LogExecutionTime;
import ie.cit.larkin.thymeleaf.entity.Artist;
import ie.cit.larkin.thymeleaf.entity.Audit;
import ie.cit.larkin.thymeleaf.service.AuditService;

@Aspect
@Component
public class AuditAspect {

	@Autowired
	AuditService auditService;

	@After("execution(* *.view(..))")
	public void view() {
		System.out.println("In the more liberal view advice!");
	}
	
	@Before("execution(* ie.cit.larkin.thymeleaf.controller.ArtistController.view(..,int)) && args(..,id)")
	public void viewArtist(JoinPoint jp, int id) {
		System.out.println("In the viewArtist advice!");
		Audit audit = new Audit(SecurityContextHolder.getContext().getAuthentication().getName(),
				"About to view an Artist with id " + id + " using " + jp.getSignature(), new Date());
		auditService.add(audit);
	}
	
	@Pointcut("execution(* ie.cit.larkin.thymeleaf.controller.ArtistController.createSubmit(ie.cit.larkin.thymeleaf.entity.Artist,..)) && args(artist,..)")
	void addingArtist(Artist artist) {}
	
	@Before("addingArtist(artist)")
	public void justLogArtist(Artist artist) {
		System.out.println("In the newArtists log advice!");
		System.out.println("About to add and the artist with name " + artist.getFullName() + " currently has the id " + artist.getId());
	}
	
	@After("addingArtist(artist)")
	public void newArtists(Artist artist) {
		System.out.println("In the newArtists advice!");
		Audit audit = new Audit(SecurityContextHolder.getContext().getAuthentication().getName(),
								"Adding artist: " + artist.getFullName() + " with id " + artist.getId(), new Date());
		auditService.add(audit);
	}
	
	@Around("@annotation(logExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
		long start = System.currentTimeMillis();
		 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	 
	    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    return proceed;
	}
	
	// All methods that are annotated with @Secure
	@Before("execution(@org.springframework.security.access.annotation.Secured * *(..))")
	public void securedMethod(JoinPoint jp) {
		System.out.println("Accessing secured method: " + jp.getSignature());
	}
	
	@AfterReturning(value="execution(* org.springframework.data.repository.CrudRepository+.findByGender(String)) && args(gender)", returning="artists")
	public void artistLists(JoinPoint jp, List<Artist> artists, String gender) {
		System.out.println("There were " + artists.size() + " " + gender + " artists.");
	}
	
}
