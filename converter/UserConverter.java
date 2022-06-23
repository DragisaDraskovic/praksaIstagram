package Instagram.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Instagram.dto.UserDto;
import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;

@Component
public class UserConverter {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	
	public List<UserDto> getUserDto(){
		return userRepository.findAll()
				.stream()
			.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	/*
	public UserDto convertEntityToDto(UserJpa userJpa) {
		/
		UserDto userDto = new UserDto();
		userDto.setFirstName(userJpa.getName());
		userDto.setSecondName(userJpa.getUsername());
		//userDto.setDate(userJpa.getDate());
		userDto.setEmail(userJpa.getEmail());
		return userDto;
		
		ModelMapper mapper = new ModelMapper();
		UserDto map = mapper.map(userJpa, UserDto.class);
		return map;

	} 
*/
	
	
	private UserDto convertEntityToDto(UserJpa userJpa) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDto userDto = new UserDto();
		userDto = modelMapper.map(userJpa, UserDto.class);
		return userDto;
	}
	
	/*
	public List<UserDto> convertEntityToDto(List<UserJpa> user) {
		
		return user.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());
	
	}
	*/
	/*
	public UserJpa convertDtoToEntity(UserDto userDto) {
		UserJpa userJpa = new UserJpa();
		userJpa.setName(userDto.getSecondName());
		userJpa.setUsername(userDto.getSecondName());
		//userJpa.setDate(userDto.getDate());
		userJpa.setEmail(userDto.getEmail());
		return userJpa;
		
		ModelMapper mapper = new ModelMapper();
		UserJpa map = mapper.map(userDt, UserJpa.class);
		return map;
		
	} */
	
	
	private UserJpa convertDtoToEntity(UserDto userDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserJpa userJpa = new UserJpa();
		userJpa = modelMapper.map(userDto, UserJpa.class);
		return userJpa;
	}
	/*
	public List<UserJpa> convertDtoToEntity(List<UserDto> dto) {
		return dto.stream().map(x -> convertDtoToEntity(x)).collect(Collectors.toList());
	} */
}
