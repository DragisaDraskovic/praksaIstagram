package Instagram.service;

import java.util.List;

import Instagram.jpa.Role;
import Instagram.jpa.User;

public interface UserServ {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
