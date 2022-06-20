package Instagram.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="post_table")
public class PostJpa implements Serializable {

	@Id
	@SequenceGenerator(name="ID_GENERATOR_POST",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_POST")
	private int id;
	
	@Column(name="content")
	private String content;
	//private boolean like; // za cekiranje za lajk
	
	private int name; // nesto po cemu cu raspoznavati svaki komentar i preko cega cu ga povezivati
	
	// vie postova moze imati jedan user
	/*
	@ManyToOne(mappedBy="id")
	//@JoinColumn(name="id")
	private UserJpa userJpa;
	*/

	// Jedan post moze da ima vise lajkova
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	private List<LikeJpa> likeJpa;
	
	// Jedan post moze imati vise komentara
	@OneToMany(mappedBy="key", cascade = {CascadeType.ALL})
	private List<CommentJpa> commentJpa;
	
	//Vise postova pise jedan user
	@ManyToOne
	@JoinColumn(name="id")
	private UserJpa userJpa;
	
	public PostJpa() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public List<LikeJpa> getLikeJpa() {
		return likeJpa;
	}

	public void setLikeJpa(List<LikeJpa> likeJpa) {
		this.likeJpa = likeJpa;
	}

	public List<CommentJpa> getCommentJpa() {
		return commentJpa;
	}

	public void setCommentJpa(List<CommentJpa> commentJpa) {
		this.commentJpa = commentJpa;
	}

	public UserJpa getUserJpa() {
		return userJpa;
	}

	public void setUserJpa(UserJpa userJpa) {
		this.userJpa = userJpa;
	}
	

}
