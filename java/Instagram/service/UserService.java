package Instagram.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.dto.UserDto;
import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	

	public void save(UserJpa userJpa) {
		userRepository.save(userJpa);
	}
	
	public void delete(Integer id) {
		if (!userRepository.existsById(id)) {
			return;
		} 
		userRepository.deleteById(id);
	}

	public boolean existBy(Integer id) {
		if(!userRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
	/*
	public Collection<UserJpa> getAllUser() {
		return userRepository.findAll();
	}
	*/
	
	public Collection<UserJpa> getAllUser() {
		return userRepository.findAll();
	}
	
	
	private UserDto convertEntityToDto(UserJpa userJpa) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(userJpa.getFirstName());
		userDto.setSecondName(userJpa.getSecondName());
		userDto.setDate(userJpa.getDate());
		userDto.setEmail(userJpa.getEmail());
		return userDto;
	}
	
	private UserJpa convertDtoToEntity(UserDto userDto) {
		UserJpa userJpa = new UserJpa();
		userJpa.setFirstName(userDto.getFirstName());
		userJpa.setSecondName(userDto.getSecondName());
		userJpa.setDate(userDto.getDate());
		userJpa.setEmail(userDto.getEmail());
		return userJpa;
	}
}
