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
	
	/*
	public void setLike(LikeJpa likeJpa) {
		if(!likeRepository.existsById(likeJpa.getId())) {
			likeRepository.save(likeJpa);
		}
	}
	*/
	public void save(LikeJpa likeJpa) {
		likeRepository.save(likeJpa);
	}
	
	// proverava da li ne postoji
	public boolean existBy(Integer id) {
		if(!likeRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void delete(Integer id) {
		likeRepository.deleteById(id);
	}
}