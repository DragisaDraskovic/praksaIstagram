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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Entity
@Table(name="comment_table")
public class CommentJpa implements Serializable {

	@Id
	@SequenceGenerator(name="ID_GENERATOR_COMMENT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_COMMENT")
	private int id;
	
	//Sadrzaj komentaras
	@Column(name="content", length=200, nullable=false)
	private String content;
	
	//neki kljuc po kome ce se lakse raspoznavati svaki komentar a da nije ID
	@Column(name="key",length=100,nullable=false)
	private int key; 
	//private boolean like; // za cekiranje kada se lajkuje
	
	// jedan post sadrzi vise komentara
	@ManyToOne
	@JoinColumn(name="post_id")
	private PostJpa postJpa;
	
	//jedan user moze pisati vise komentara
	@ManyToOne
	//@JoinColumn(name="user_id")  //mapiranje bi trebal da bude po mail-u
	@JoinColumn(name="user_email")
	private UserJpa userJpa;
	
	
}
