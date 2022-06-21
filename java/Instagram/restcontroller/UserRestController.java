package Instagram.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Instagram.dto.UserDto;
import Instagram.jpa.UserJpa;
import Instagram.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public Collection<UserJpa> getAllUsers() {
		return userService.getAllUser();
	}
	
	
	// sa DTO
	
	/*
	@GetMapping("/users")
	public Collection<UserDto> getAllUsers() {
		return userServices.getAllUser();
	}
	*/
	
	@PostMapping("/userPost")
	public ResponseEntity<HttpStatus> addUser(@RequestBody UserJpa userJpa) {
		userService.save(userJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PutMapping("/userUpdate/{id}")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody UserJpa userJpa, @PathVariable("id") Integer id) {
		if(userService.existBy(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		userJpa.setId(id);
		userService.save(userJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@DeleteMapping("/userDelete/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
		if(userService.existBy(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		userService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
