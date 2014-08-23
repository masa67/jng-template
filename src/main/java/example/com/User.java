package example.com;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userlist")
public class User {
	@Id
	private String id;
	private String username;
	private String email;
	private String fullname;
	private Integer age;
	private String location;
	private String gender;
	
	public User() {
	}
	
	// This constructor is needed when reading data from DB:
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

	// This constructor is needed when reading data from web API:
	public User(String username,
				String email,
				String fullname,
				String ageStr,
				String location,
				String gender) {
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.age = Integer.parseInt(ageStr);
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

