package Instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Instagram.jpa.LikeJpa;
import Instagram.jpa.TestJpa;
import Instagram.repository.LikeRepository;

@Service
public class LikeService {

	@Autowired
	LikeRepository likeRepository;
	
	public void setLike(LikeJpa likeJpa) {
		if(!likeRepository.existsById(likeJpa.getId())) {
			likeRepository.save(likeJpa);
		}
	}
}