package Instagram.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Instagram.jpa.TestJpa;
import Instagram.repository.TestRepository;
import Instagram.service.TestServices;

@RestController
public class TestRestController {

	@RequestMapping("/")
	public String hello() {
		return "Radi";
	}
	

	@Autowired
	TestServices testServices;
	
	/*
	@Autowired
	TestRepository testRepository;
	*/
	
	@GetMapping("/home")
	public String admin() {
		return "ti si admin";
	}
	
	@GetMapping("/user")
	public String user() {
		return "ti si user";
	}
	
	@PostMapping("/test")
	public ResponseEntity<HttpStatus> addTest(@RequestBody TestJpa testJpa) {
		testServices.save(testJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@GetMapping("test")
	public Collection<TestJpa> getAll() {
		return testServices.findAll();
	}
}
