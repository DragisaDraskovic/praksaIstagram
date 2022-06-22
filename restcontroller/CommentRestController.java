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
	
	
	@GetMapping("/comments")
	public Collection<CommentJpa> getAllComments(){
		return commentService.getAllComment();
	}
	
	
	@PostMapping("/commentSave")
	public ResponseEntity<HttpStatus> addPost(@RequestBody CommentJpa commentJpa){
		commentService.save(commentJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	
	@PutMapping("/commentUpdate/{id}")
	public ResponseEntity<HttpStatus> updatePost(@RequestBody CommentJpa commentJpa, @PathVariable("id") Integer id){
		if(commentService.existBy(id) == true) {
			commentJpa.setId(id);
			commentService.save(commentJpa);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/commentDelete/{id}")
	public void deletePost(@PathVariable("id") Integer id) {
		if(commentService.existBy(id) == true) {
			commentService.deleteById(id);
			new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
	}
}
