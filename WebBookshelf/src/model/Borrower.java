package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="borrower")
public class Borrower {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BORROWER_ID")
	private int id;
	@Column(name="BORROWER_NAME")
	private String borrowerName;
	
	public Borrower() {
		super();
	}
	
	public Borrower(String borrowerName) {
		super();
		this.borrowerName = borrowerName;
	}
	
	public Borrower(int id, String borrowerName) {
		super();
		this.id = id;
		this.borrowerName = borrowerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	
	@Override
	public String toString() {
		return "Borrower [id=" + id + ", borrowerName=" + borrowerName + "]";
	}
}
