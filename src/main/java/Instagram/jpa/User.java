package Instagram.jpa;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Table(name = "USERTEST")
@DiscriminatorValue("USERTEST")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Column(name = "USERNAME", nullable = false, unique = true)
	public String username;
	
	@Column(name= "PASSWORD", nullable = false)
	public String password;
	
	@Column(name= "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	//@Email
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	ArrayList<String> authorities;
}
