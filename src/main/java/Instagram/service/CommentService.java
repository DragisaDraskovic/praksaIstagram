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

	
	public void delete(Integer id) {
		if(commentRepository.existsById(id)) {
			commentRepository.deleteById(id);
			new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
			}
	}
	
	/*
	  
	  public void delete(Integer id) {
	  commentRepository.deleteById(id);
	  
	 */
	/*
	public CommentJpa update(CommentJpa commentJpa) {
		if(commentRepository.existsById(commentJpa.getId())) {
			commentJpa.setId(commentJpa.getId());
			commentRepository.save(commentJpa);
		}
		return commentJpa;
	}
	
	public void existBy(Integer id) {
		if(commentRepository.existsById(id)){
			return;
		} else {
			
		}
	} */
	
	
	// metoda vraca ako ne postoji1
	public boolean existBy(Integer id) {
		if(commentRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void update(Integer id, CommentJpa commentJpa) {
		if(commentRepository.existsById(id)) {
			commentJpa.setId(id);
			commentRepository.save(commentJpa);
			new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
	}
		
	public Collection<CommentJpa> getAllComment() {
		 return commentRepository.findAll();
	}
	
}
