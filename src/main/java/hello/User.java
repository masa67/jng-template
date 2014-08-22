package hello;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String id;
	private final String username;
	private final String email;
	private final String fullname;
	private final Integer age;
	private final String location;
	private final String gender;
	
	public User(String username,
				String email,
				String fullname,
				Integer age,
				String location,
				String gender) {
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.age = age;
		this.location = location;
		this.gender = gender;
	}

	
	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getGender() {
		return gender;
	}
}

