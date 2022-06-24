package Instagram.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Instagram.jpa.User;
import Instagram.service.UserServ;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

	private final UserServ userServ;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>>getUsers() {
		return ResponseEntity.ok().body(userServ.getUsers());
	}
}
