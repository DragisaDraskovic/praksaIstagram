package Instagram.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.dto.UserDto;
import Instagram.jpa.Role;
import Instagram.jpa.User;
import Instagram.jpa.UserJpa;
import Instagram.repository.RoleRepository;
import Instagram.repository.UserRepo;
import Instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements UserServ {

	private final UserRepo userRepo;
	private final RoleRepository roleRepo;
	
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

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	
	
	
	/*
	@Transactional(rollbackFor = Exception.class) 
	public String saveDto(UserDto userDto) { 
	    userDto.setPassword(bCryptPasswordEncoder
	           .encode(userDto.getPassword())); 
	    return save(new User(userDto)).getId(); 
	}
	*/
	
	
}
