package Instagram.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Instagram.jpa.LikeJpa;
import Instagram.service.LikeService;

@RestController
public class LikeRestController {

	@Autowired
	LikeService likeService;

	//@GetMapping("/like")
	
	
	@PostMapping("/likeSave")
	public ResponseEntity<HttpStatus> addLike(@RequestBody LikeJpa likeJpa){
		likeService.save(likeJpa);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/likeDelete/{id}")
	public ResponseEntity<HttpStatus> deleteLike(@PathVariable("id") Integer id){
		if(likeService.existBy(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		likeService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
