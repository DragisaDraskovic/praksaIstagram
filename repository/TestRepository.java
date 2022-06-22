package Instagram.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import Instagram.jpa.TestJpa;

public interface TestRepository extends JpaRepository<TestJpa,Integer>{
	
	//Collection<TestJpa> findByTestStringContainingIgnoreCase(String naziv);
}
