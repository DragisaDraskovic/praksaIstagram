package Instagram.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Instagram.jpa.TestJpa;
import Instagram.repository.TestRepository;

@Service
public class TestServices {

	@Autowired
	TestRepository testRepository;
	
	public void save(TestJpa testJpa) {
		testRepository.save(testJpa);
	}
	
	
	public Collection<TestJpa> findAll(){
		return testRepository.findAll();
	}

	
}
