package Instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.jpa.CommentJpa;
import Instagram.jpa.TestJpa;
import Instagram.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public void post(CommentJpa commentJpa) {
		commentRepository.save(commentJpa);
	}
	
	public void delete(CommentJpa commentJpa) {
		if(commentRepository.existsById(commentJpa.getId())) {
		   commentRepository.deleteById(commentJpa.getId());
		}
	}
	
	public CommentJpa update(CommentJpa commentJpa) {
		if(commentRepository.existsById(commentJpa.getId())) {
			commentJpa.setId(commentJpa.getId());
			commentRepository.save(commentJpa);
		}
		return commentJpa;
	}
}
