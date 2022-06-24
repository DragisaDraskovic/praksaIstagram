package Instagram.restcontroller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Instagram.converter.UserConverter;
import Instagram.dto.UserDto;
import Instagram.jpa.UserJpa;
import Instagram.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserConverter userConverter;
	

	@GetMapping("/users")
	public Collection<UserJpa> getAllUsers() {
		return userService.getAllUser();
	}

	
	// za DTO
	/*
	@GetMapping("/usersDto")
	public Collection<UserDto> getAllUsersDto() {
		return userService.getUserDto();
	}
	*/
	
	@GetMapping("/usersDto")
	public List<UserDto> getAllUsersDto() {
		List<UserJpa> findAll = userService.findAll();
		return userConverter.getUserDto();
	}
	
	
	@GetMapping("/user/{id}")
	public UserJpa getOne(@PathVariable("id") Integer id) {
		return userService.getOneUser(id);
	}
	
	
	/* nema logike posto i DTO nema ID
	@GetMapping("/userDto/{id}")
	public UserDto findById(@PathVariable("id") Integer id) {
		UserJpa user = userService.getOneUser(id);
		return userConverter.convertEntityToDto(id);
	}
	*/
	
	
	/*
	@PostMapping("/userPost")
	public ResponseEntity<HttpStatus> addUser(@RequestBody UserJpa userJpa) {
		userService.save(userJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	*/
	/*
	@PostMapping("/userPost")
	public UserDto save(@RequestBody UserDto dto) {
		UserJpa user = userConverter.convertDtoToEntity(dto);
		user = userService.save(user);
		return userConverter.convertEntityToDto(user);
	}
	*/
	
	@PutMapping("/userUpdate/{id}")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody UserJpa userJpa, @PathVariable("id") Integer id) {
		if(userService.existBy(id) == true) {
			userJpa.setId(id);
			userService.save(userJpa);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/userDelete/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
		if(userService.existBy(id) == true) {
			userService.delete(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
