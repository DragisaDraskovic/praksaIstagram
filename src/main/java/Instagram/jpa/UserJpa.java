package Instagram.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="user_table")
public class UserJpa implements Serializable {

	@Id
	@SequenceGenerator(name="ID_GENERATOR_USER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_USER")
	private int id;
	
	// promenljiva za ime
	@Column(name="first_name", length=30, nullable=false)
	private String firstName;
	
	// promenljiva za prezime
	@Column(name="second_name", length=30, nullable=false)
	private String secondName;

	// promenljiva za datum rodjenja
	@Column(name="date", nullable=false)
	//@Temporal()
	private Date date;
	
	// promenljiva za email
	@Column(name="email", length=30, nullable=false)
	private String email;
	
	// promenljiva za password za logovanje
	@Column(name="password", length=50, nullable=false)
	private String password;
	
	//jedan user ima vise postova
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	private List<PostJpa> post;
	
	// jedan user moze napisati vise komentara
	@OneToMany()
	private List<CommentJpa> commentJpa;
	
	// jedan user moze da lajkuje vise stvari
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	private List<LikeJpa> like;
	
}
