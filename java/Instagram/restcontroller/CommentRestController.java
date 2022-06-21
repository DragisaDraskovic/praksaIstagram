package Instagram.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Instagram.jpa.CommentJpa;
import Instagram.repository.CommentRepository;
import Instagram.service.CommentService;

@RestController
public class CommentRestController {

	
	@Autowired
	CommentService commentService;
	

	/*
	@GetMapping("/comments")
	public Collection<CommentJpa> getAllComment() {
		return commentService.getAll();
	}
	*/
	@GetMapping("/comments")
	public Collection<CommentJpa> getAllComment(){
		return commentService.getAllComment();
	}
	
	
	@PostMapping("/commentSave")
	public ResponseEntity<HttpStatus> addPost(@RequestBody CommentJpa commentJpa){
		commentService.save(commentJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	/*
	@PutMapping("/commentUpdate/{id}")
	public ResponseEntity<HttpStatus> updatePost(@RequestBody CommentJpa commentJpa, @PathVariable("id") Integer id){
		if(commentService.existBy(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	*/
	
	@PutMapping("/comentUpdate/{id}")
	public void updatePost(@RequestBody CommentJpa commentJpa, @PathVariable("id") Integer id) {
		commentService.update(id, commentJpa);
		
	}

	/*
	@DeleteMapping("/commentDelete/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Integer id){
		if(commentService.existBy(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		//treba if da se proberi da li postoji sa tim ID-em!
		commentService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	*/
	
	@DeleteMapping("/commentDelete/{id}")
	public void deletePost(@PathVariable("id") Integer id) {
		commentService.delete(id);
	}
}
