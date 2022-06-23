package Instagram.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
//@Table(name="user_table")
@Table(name="users")
public class UserJpa implements Serializable {

	@Id
	@Column(name="id")
	@SequenceGenerator(name="ID_GENERATOR_USER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="ID_GENERATOR_USER")
	private int id;
	
	// promenljiva za ime
	@Column(name="first_name", length=30, nullable=false)
	private String name;
	
	// promenljiva za prezime
	@Column(name="user_name", length=30, nullable=false)
	private String username;
/*
	// promenljiva za datum rodjenja
	@Column(name="date", nullable=false)
	//@Temporal()
	private Date date;
	
	*/
	
	// promenljiva za email
	@Column(name="email", length=30, nullable=false)
	private String email;
	
	// promenljiva za password za logovanje
	@Column(name="password", length=200, nullable=false)
	private String password;
	
	//Role trebace za admina i usera
/*
	@ManyToMany
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "users_id"),
			inverseJoinColumns = @JoinColumn(name="roles_id")
			)
	private Set<Role> roles = new HashSet<>(); //Set ne sadrzi duple vrednosti pa je dobraz za role
*/
	private String role;
	
	//jedan user ima vise postova
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	//@OneToMany(mappedBy="id")
	private List<PostJpa> post;
	
	// jedan user moze napisati vise komentaraS
	@OneToMany()
	private List<CommentJpa> commentJpa;
	
	// jedan user moze da lajkuje vise stvari
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	//@OneToMany(mappedBy="id")
	private List<LikeJpa> like;
	
	/*
	//dodavanje uloga
	public void addRole(Set<Role> role) {
		this.roles.addAll(role);
	}
	*/
}
