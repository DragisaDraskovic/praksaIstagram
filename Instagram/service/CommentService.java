package Instagram.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Instagram.jpa.CommentJpa;
import Instagram.jpa.TestJpa;
import Instagram.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public void save(CommentJpa commentJpa) {
		commentRepository.save(commentJpa);
	}
	  
	  public void deleteById(Integer id) {
	  commentRepository.deleteById(id);
	  
	  }
	
	public CommentJpa update(CommentJpa commentJpa) {
		if(commentRepository.existsById(commentJpa.getId())) {
			commentJpa.setId(commentJpa.getId());
			commentRepository.save(commentJpa);
		}
		return commentJpa;
	}
	
	
	// metoda vraca true ili false
	public boolean existBy(Integer id) {
		if(commentRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
			
	}
	
	public Collection<CommentJpa> getAllComment() {
		 return commentRepository.findAll();
	}
	
}
