package Instagram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;
import Instagram.service.UserService;
import lombok.Data;

public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	UserJpa userJpa;
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//	return new userJpa;
		return null;
	}
	*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserJpa userJpa = userRepository.findUserByUserName(username);
		UserJpa userJpa = userRepository.findByUsername(username);
		if(userJpa == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(userJpa);
	}
	
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserJpa userJpa = userRepository.findByUsername(username);
		MyUserDetails userDetails = null;
		if(userJpa !=null) {
			//generaisati JWT
			userDetails = new MyUserDetails();
			userDetails.setUser(userJpa);
		} else {
			throw new UsernameNotFoundException("user not exists whit the name" + username);
		}
		
		return userDetails;
	}
	*/
	

}
