package Instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Instagram.jpa.CommentJpa;

@Repository
public interface CommentRepository extends JpaRepository<CommentJpa,Integer>{
	
	//public void post(CommentJpa commentJpa);
	//public void delete(CommentJpa commenJpa);
}
