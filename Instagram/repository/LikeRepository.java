package Instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Instagram.jpa.LikeJpa;

public interface LikeRepository extends JpaRepository<LikeJpa, Integer>{

		
}
