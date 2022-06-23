package Instagram.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Instagram.dto.UserDto;
import Instagram.jpa.LikeJpa;
import Instagram.jpa.UserJpa;

public interface UserRepository extends JpaRepository<UserJpa,Integer> {
	
	//UserJpa findUserByUserName(String username);
	UserJpa findByUsername(String username);
	//Collection<UserJpa> findByNameContainingIgnoreCase(String name);
	//Collection<UserJpa> findByUserNameContainingIgnoreCase(String userName);
	//Collection<UserJpa> findByEmail(String email);
	// da nadjem user-a koji je lajkovao
	Collection<UserJpa> findByLike(LikeJpa like);
	
	// da nadjem user-a koji je komentarisao
	// da nadjem sve postove jednog usera
}
