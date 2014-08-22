package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;

@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	/*
	public static MongoRepository<User, String> getRepository() {
		return repository;
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		
		repository.save(new User(
		    "test1", "test1@test.com", "Bob Smith", 27, 
		    	"San Francisco", "Male"));
		repository.save(new User(
			"test2", "test2@test.com", "John Doe", 72,
				"Los Angeles", "Male"));
		repository.save(new User(
			 "test3", "test3@test.com", "Lady Gaga", 28,
			 	"NYC", "Female"));
		
	}

}
