package Instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Instagram.jpa.PostJpa;

public interface PostRepository extends JpaRepository<PostJpa,Integer>{

}
