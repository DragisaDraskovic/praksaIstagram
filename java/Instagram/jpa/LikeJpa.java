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

@Entity
@Table(name="like_table")
public class LikeJpa implements Serializable {

	
	@Id
	@SequenceGenerator(name="ID_GENERATOR_LIKE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR_LIKE")
	private int id;
	
	@Column(name="check")
	private boolean check;

	
	@ManyToOne
	@JoinColumn(name="id")
	private UserJpa userJpa;
	public LikeJpa() {
		
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserJpa getUserJpa() {
		return userJpa;
	}

	public void setUserJpa(UserJpa userJpa) {
		this.userJpa = userJpa;
	}
	
	
}
