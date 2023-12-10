package com.microservices.ucan.restwebservice1.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int counter = 1;
	
	static {
		users.add(new User(counter++, "Anoop", LocalDate.now().minusYears(32)));
		users.add(new User(counter++, "Aryanoop", LocalDate.now().minusYears(30)));
		users.add(new User(counter++, "Atindriya", LocalDate.now().minusYears(6)));
		users.add(new User(counter++, "Adishwar", LocalDate.now().minusYears(3)));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUserById(int id) {
		Predicate<? super User> Predicate = User -> User.getId().equals(id);
		// return users.stream().filter(Predicate).findFirst().get(); // this throws error if not found
		return users.stream().filter(Predicate).findFirst().orElse(null);
	}
	
	public User addUser(User user) {
		
		user.setId(counter++);
		users.add(user);
		return user;
	}
	
	public void deleteUserById(int id) {
		Predicate<? super User> Predicate = User -> User.getId().equals(id);
		users.removeIf(Predicate);
	}

}
