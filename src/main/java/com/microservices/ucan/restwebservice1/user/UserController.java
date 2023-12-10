package com.microservices.ucan.restwebservice1.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.ucan.restwebservice1.user.exception.UserNotFoundException;

import jakarta.validation.Valid;


@RestController
public class UserController {
	
	private UserDaoService userService;
	
	

	public UserController(UserDaoService userService) {
		this.userService = userService;
	}


   @GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
   
   @GetMapping("/users/{id}")
   public User getUserById(@PathVariable int id) {
	   User userById = userService.getUserById(id);
	   if(userById == null) {
		   throw new UserNotFoundException("User not found with id: %d".formatted(id));
	   }
	return userById;
   }
   
   @PostMapping("/users")
//   public ResponseEntity<User> addUser(@RequestBody User user) {  // without validation
   public ResponseEntity<User> addUser(@Valid @RequestBody User user) {  // @Valid checks validation specified in user class.
	   User addedUser = userService.addUser(user);
	   
	   // if just want to send 201 status
	   // return ResponseEntity.created(null).build();
	   
	   // returns 201 and uri of created user in a http header - location
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
   }
   
   @DeleteMapping("/users/{id}")
   public void deleteUserById(@PathVariable int id) {
	   userService.deleteUserById(id);
   }
   
   
}
