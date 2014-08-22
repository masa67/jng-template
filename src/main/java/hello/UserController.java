package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/*
	public static void setRepository(UserRepository repository) {
		UserController.repository = repository;
	}
	*/
	
	@RequestMapping("/userlist")
	public List<User> userlist() {
		List<User> userlist = null;
		
		/*
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
		*/
		
		userlist = repository.findAll();
		
		return userlist;
	}
	
	@RequestMapping("/adduser")
	public UserDBStatus adduser(@RequestBody @Valid User user) {
		User userSaved = repository.save(user);
		UserDBStatus status = new UserDBStatus(
			(userSaved != null) ? "" : "failed"
		);
		return status; 
	}
	
	@RequestMapping(value="/deleteuser/{id}", method=RequestMethod.DELETE)
	public UserDBStatus deleteuser(@PathVariable("id") String id) {
		repository.delete(id);
		return new UserDBStatus(""); 
	}
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
							String.format(template, name));
	}
}
