package Instagram.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import Instagram.jpa.LikeJpa;
import Instagram.jpa.User;
import Instagram.jpa.UserJpa;

public interface UserRepo extends JpaRepository<User, Long>{
	
	
	User findByUsername(String username);
	User save(User user);
}
