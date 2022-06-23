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
import org.springframework.web.bind.annotation.RestController;

import Instagram.jpa.PostJpa;
import Instagram.repository.PostRepository;
import Instagram.service.PostService;

@RestController
public class PostRestController {

	
	@Autowired
	PostService postService;
	
	
	@GetMapping("/post")
	public Collection<PostJpa> getAllPost(){
		return postService.getAllPost();
	}
	
	@PostMapping("/postSave")
	public ResponseEntity<HttpStatus> addPost(@RequestBody PostJpa postJpa) {
		postService.save(postJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PutMapping("/postUpdate/{id}")
	public ResponseEntity<HttpStatus> updatePost(@RequestBody PostJpa postJpa, @PathVariable("id") Integer id) {
		if(postService.existBy(id) == true) {
			postJpa.setId(id);
			postService.save(postJpa);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}

			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/postDelete/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Integer id) {
		if(postService.existBy(id) == true) {
			postService.delete(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
