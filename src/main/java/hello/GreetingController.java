package hello;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/users/userlist")
	public User[] userlist() {
		User[] userlist = {
				new User("53e9ba879c0ba5f9aebab154",
					 "test1",
					 "test1@test.com",
					 "Bob Smith",
					 27,
					 "San Francisco",
					 "Male"),
				new User("53e9ba879c0ba5f9aebab155",
					 "test2",
					 "test2@test.com",
					 "John Doe",
					 72,
					 "Los Angeles",
					 "Male"),
				new User("53e9ba879c0ba5f9aebab156",
					 "test3",
					 "test3@test.com",
					 "Lady Gaga",
					 28,
					 "NYC",
					 "Female")
			};
		return userlist;
	}
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
							String.format(template, name));
	}
}
