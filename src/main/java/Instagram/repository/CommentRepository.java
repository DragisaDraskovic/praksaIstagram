package Instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Instagram.jpa.CommentJpa;

public interface CommentRepository extends JpaRepository<CommentJpa,Integer>{
	
	//public void post(CommentJpa commentJpa);
	//public void delete(CommentJpa commenJpa);
}
