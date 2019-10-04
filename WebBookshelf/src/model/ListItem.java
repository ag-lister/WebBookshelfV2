package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookshelf")
public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BookID")
	private int id;
	@Column(name="BookTitle")
	private String title;
	@Column(name="BookAuthor")
	private String author;
	@Column(name="BookGenre")
	private String genre;
	
	public ListItem() {
		super();
	}
	
	public ListItem(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String returnBookDetails() {
		return title + " - " + author + ". " + genre +".";
	}
	
	@Override
	public String toString() {
		return "ListItem [id=" + id + ", title=" + title + ", author=" + author + ", genre= " + genre + "]";
	}
}