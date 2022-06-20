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


@Entity
@Table(name="user_table")
public class UserJpa implements Serializable {

	@Id
	@SequenceGenerator(name="ID_GENERATOR_USER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_USER")
	private int id;
	
	@Column(name="first_name", length=30, nullable=false)
	private String firstName;
	
	@Column(name="second_name", length=30, nullable=false)
	private String secondName;

	@Column(name="date", nullable=false)
	//@Temporal()
	private Date date;
	
	@Column(name="email", length=30, nullable=false)
	private String email;
	
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
	
	public UserJpa() {
		
	}
	
	public UserJpa(String firstName, String secondName, Date date, String email, String password) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.date = date;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PostJpa> getPost() {
		return post;
	}

	public void setPost(List<PostJpa> post) {
		this.post = post;
	}

	public List<CommentJpa> getCommentJpa() {
		return commentJpa;
	}

	public void setCommentJpa(List<CommentJpa> commentJpa) {
		this.commentJpa = commentJpa;
	}

	public List<LikeJpa> getLike() {
		return like;
	}

	public void setLike(List<LikeJpa> like) {
		this.like = like;
	}

	

}
