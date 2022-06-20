package Instagram.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class TestJpa {

	@Id	
	//@SequenceGenerator(name="TEST_ID_GENERATOR", sequenceName="TEST_SEQ", allocationSize=1)
	@SequenceGenerator(name="TEST_ID_GENERATOR", allocationSize=1)	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TEST_ID_GENERATOR")
	private int testId; 
	
	@Column(name="test_string")
	private String testString;
	
	/*
	@Column(name="test_datum")
	private Date testDatum;

*/
	public TestJpa(String testString) {
		this.testString = testString;
	}
	/*
	public TestJpa(String testSring, Date testDatum) {
		this.testString = testString;
		this.testDatum = testDatum;
	}
	*/
	public TestJpa() {
		
	}
	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	/*
	public Date getTestDatum() {
		return testDatum;
	}

	public void setTestDatum(Date testDatum) {
		this.testDatum = testDatum;
	}
	
	*/
	//@JoinColumn(name="") // ime kolone po kojoj ce se spajati
	//private String nesto;
	
	
}
