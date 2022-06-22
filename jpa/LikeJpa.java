package Instagram.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name="like_table")
public class LikeJpa implements Serializable {

	
	@Id
	@SequenceGenerator(name="ID_GENERATOR_LIKE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_LIKE")
	private int id;
	
	// promenljiva za cekiranje lajkova, odnosno a li je lajkovano ili ne
	@Column(name="like_check")
	private boolean check;

	//Jedan user moze lajkovati vise stvari
	@ManyToOne
	//@JoinColumn(name="user_id")  //mapiranje bi trebal da bude po mail-u
	@JoinColumn(name="user_email")
	private UserJpa userJpa;
	
	// Jedan post moze imati vise lajkova
	@ManyToOne
	@JoinColumn(name="post_id")
	private LikeJpa likeJpa;
	

	
}
