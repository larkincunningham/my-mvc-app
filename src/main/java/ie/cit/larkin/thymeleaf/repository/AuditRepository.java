package ie.cit.larkin.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import ie.cit.larkin.thymeleaf.entity.Audit;

public interface AuditRepository extends CrudRepository<Audit, Integer>{

}
