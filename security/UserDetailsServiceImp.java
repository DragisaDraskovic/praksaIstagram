package Instagram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;
import Instagram.service.UserService;

public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserJpa userJpa = userRepository.findUserByUserName(username);
		UserJpa userJpa = userRepository.findByUsername(username);
		if(userJpa == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(userJpa);
	}

}
