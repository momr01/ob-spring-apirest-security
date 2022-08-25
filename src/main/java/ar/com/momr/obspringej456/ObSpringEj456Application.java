package ar.com.momr.obspringej456;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ar.com.momr.obspringej456.entities.Laptop;
import ar.com.momr.obspringej456.repository.LaptopRepository;

/**
 * 
 * heroku deply site= https://ob-spring-ej10-11-12.herokuapp.com/
 * @author maxio
 *
 */
@EnableWebMvc
@SpringBootApplication
public class ObSpringEj456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringEj456Application.class, args);
	
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		
		Laptop laptop1 = new Laptop(null, "MSI", "Windows 10", 32, 1000.0, 4);
		Laptop laptop2 = new Laptop(null, "Toshiba", "Linux", 64, 950.0, 2);
		
		repository.save(laptop1);
		repository.save(laptop2);
	}

}
