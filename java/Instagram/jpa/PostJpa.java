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
@Entity
@Table(name="post_table")
public class PostJpa implements Serializable {

	@Id
	@SequenceGenerator(name="ID_GENERATOR_POST",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_POST")
	private int id;
	
	// promenljiva za sadrzaj
	@Column(name="content")
	private String content;
	//private boolean like; // za cekiranje za lajk
	
	// nesto po cemu cu raspoznavati svaki komentar i preko cega cu ga povezivati
	//private int name; 

	// Jedan post moze da ima vise lajkova
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	private List<LikeJpa> likeJpa;
	
	// Jedan post moze imati vise komentara
	@OneToMany(mappedBy="id", cascade = {CascadeType.ALL})
	private List<CommentJpa> commentJpa;
	
	//Vise postova pise jedan user
	@ManyToOne 
	//@JoinColumn(name="user_id")   //mapiranje bi trebal da bude po mail-u
	@JoinColumn(name="user_email")
	private UserJpa userJpa;
	
}
