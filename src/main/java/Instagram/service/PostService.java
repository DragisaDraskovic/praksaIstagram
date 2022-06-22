package Instagram.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.jpa.PostJpa;
import Instagram.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Collection<PostJpa> getAllPost() {	
		return postRepository.findAll();
	}
	public void save(PostJpa postJpa) {
		postRepository.save(postJpa);
	}
	
	public void delete(Integer id) {
		postRepository.deleteById(id);
	}
	
	
	public boolean existBy(Integer id) {
		if(postRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
}
