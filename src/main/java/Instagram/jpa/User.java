package Instagram.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class User {
/*
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
	*/
	
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String username;
	    private String password;
	    @ManyToMany(fetch = FetchType.EAGER)
	    private Collection<Role> roles = new ArrayList<>();
}
