package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	/*
	private static MongoRepository<User, String> repository;
	*/
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/*
	public static void setRepository(MongoRepository<User, String> repository) {
		UserController.repository = repository;
	}
	*/
	
	@RequestMapping("/users/userlist")
	public List<User> userlist() {
		List<User> userlist = null;
		
		/*
		if (repository == null) {
			repository = Application.getRepository();
		}
		
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
		
		List<User> userlist = repository.findAll();
		*/
		return userlist;
	}
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
							String.format(template, name));
	}
}
