package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository, JobRepository jobRepository) {
		return (args) -> {
			Date date = new Date();
			repository.save(new Customer("Jack", "Bauer", date));
			repository.save(new Customer("Chloe", "O'Brian", date));
			repository.save(new Customer("Kim", "Bauer", date));
			repository.save(new Customer("David", "Palmer", date));
			repository.save(new Customer("Michelle", "Dessler", date));

			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}


		};
	}

}
