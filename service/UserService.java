package Instagram.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.dto.UserDto;
import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
 // Da li moze ovako?
	public UserJpa getOneUser(Integer id) {
		return userRepository.getOne(id);
	}
	
	public List<UserJpa> findAll(){
		return userRepository.findAll();
	}
	
	public void save(UserJpa userJpa) {
		userRepository.save(userJpa);
	}
	
	/*
	public void save(UserDto userDto) {
		userRepository.save(userDto);
	}
	*/
	
	public void delete(Integer id) {
		if (!userRepository.existsById(id)) {
			return;
		} 
		userRepository.deleteById(id);
	}

	public boolean existBy(Integer id) {
		if(userRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Collection<UserJpa> getAllUser() {
		return userRepository.findAll();
	}
	
	
}
