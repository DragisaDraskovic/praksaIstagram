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
@Table(name="comment_table")
public class CommentJpa implements Serializable {

	@Id
	@SequenceGenerator(name="ID_GENERATOR_COMMENT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_COMMENT")
	private int id;
	
	//Sadrzaj komentara
	@Column(name="content", length=200, nullable=false)
	private String content;
	
	//neki kljuc po kome ce se lakse raspoznavati svaki komentar a da nije ID
	@Column(name="key",length=100,nullable=false)
	private int key; 
	//private boolean like; // za cekiranje kada se lajkuje
	
	// jedan post sadrzi vise komentara
	@ManyToOne
	@JoinColumn(name="id")
	private PostJpa postJpa;
	
	//jedan user moze pisati vise komentara
	@ManyToOne
	@JoinColumn(name="id")
	private UserJpa userJpa;
	
	public CommentJpa() {
		
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

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public PostJpa getPostJpa() {
		return postJpa;
	}

	public void setPostJpa(PostJpa postJpa) {
		this.postJpa = postJpa;
	}

	public UserJpa getUserJpa() {
		return userJpa;
	}

	public void setUserJpa(UserJpa userJpa) {
		this.userJpa = userJpa;
	}
	
	
	
	
}
