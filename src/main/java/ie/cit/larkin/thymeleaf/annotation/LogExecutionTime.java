package ie.cit.larkin.thymeleaf.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author larkin
 *
 * Based on http://www.baeldung.com/spring-aop-annotation
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
 
}
