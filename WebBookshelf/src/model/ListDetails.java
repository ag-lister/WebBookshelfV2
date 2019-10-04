package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="borrow_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="BORROW_DATE")
	private LocalDate borrowDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="BORROWER_ID")
	private Borrower borrower;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="BORROWED_BOOKS", joinColumns= { @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID")}, 
	inverseJoinColumns= {@JoinColumn(name="BOOK_ID", referencedColumnName="BookID", unique=true)})
	private List<ListItem> listOfBooks;
	
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, LocalDate borrowDate, Borrower borrower, List<ListItem> listOfBooks) {
		super();
		this.id = id;
		this.borrowDate = borrowDate;
		this.borrower = borrower;
		this.listOfBooks = listOfBooks;
	}

	public ListDetails(LocalDate borrowDate, Borrower borrower, List<ListItem> listOfBooks) {
		super();
		this.borrowDate = borrowDate;
		this.borrower = borrower;
		this.listOfBooks = listOfBooks;
	}

	public ListDetails(LocalDate borrowDate, Borrower borrower) {
		super();
		this.borrowDate = borrowDate;
		this.borrower = borrower;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public List<ListItem> getListOfBooks() {
		return listOfBooks;
	}
	public void setListOfBooks(List<ListItem> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", borrowDate=" + borrowDate + ", borrower=" + borrower
				+ ", listOfBooks=" + listOfBooks + "]";
	}
	
}
