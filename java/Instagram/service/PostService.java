package Instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.jpa.PostJpa;
import Instagram.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public void save(PostJpa postJpa) {
		postRepository.save(postJpa);
	}
	
	public void delete(PostJpa postJpa) {
		if(postRepository.existsById(postJpa.getId())) {
			postRepository.deleteById(postJpa.getId());
		}
	}
	
	public void update(PostJpa postJpa) {
		if(postRepository.existsById(postJpa.getId())) {
			postJpa.setId(postJpa.getId());
			postRepository.save(postJpa);
		}
	}
}
