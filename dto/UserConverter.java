package Instagram.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;

@Component
public class UserConverter {

	@Autowired
	UserRepository userRepository;

	public List<UserDto> getUserDto(){
		return userRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	
	public UserDto convertEntityToDto(UserJpa userJpa) {
		
		UserDto userDto = new UserDto();
		userDto.setFirstName(userJpa.getName());
		userDto.setSecondName(userJpa.getUsername());
		//userDto.setDate(userJpa.getDate());
		userDto.setEmail(userJpa.getEmail());
		return userDto;
		
		/*
		ModelMapper mapper = new ModelMapper();
		UserDto map = mapper.map(userJpa, UserDto.class);
		return map;
		*/
	}
	
	public List<UserDto> convertEntityToDto(List<UserJpa> user) {
		
		return user.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());
	
	}

	
	public UserJpa convertDtoToEntity(UserDto userDto) {
		UserJpa userJpa = new UserJpa();
		userJpa.setName(userDto.getSecondName());
		userJpa.setUsername(userDto.getSecondName());
		//userJpa.setDate(userDto.getDate());
		userJpa.setEmail(userDto.getEmail());
		return userJpa;
		
		/*
		ModelMapper mapper = new ModelMapper();
		User map = mapper.map(userDtp, User.class);
		return map;
		*/
	}
	
	public List<UserJpa> convertDtoToEntity(List<UserDto> dto) {
		return dto.stream().map(x -> convertDtoToEntity(x)).collect(Collectors.toList());
	}
}
