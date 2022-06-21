package Instagram.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import Instagram.dto.UserDto;
import Instagram.jpa.LikeJpa;
import Instagram.jpa.UserJpa;

public interface UserRepository extends JpaRepository<UserJpa,Integer> {

	Collection<UserJpa> findByFirstNameContainingIgnoreCase(String firstName);
	Collection<UserJpa> findBySecondNameContainingIgnoreCase(String secondName);
	Collection<UserJpa> findByEmail(String email);
	// da nadjem user-a koji je lajkovao
	Collection<UserJpa> findByLike(LikeJpa like);
	
	// da nadjem user-a koji je komentarisao
	// da nadjem sve postove jednog usera
}
