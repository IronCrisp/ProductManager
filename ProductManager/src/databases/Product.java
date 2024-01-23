package databases;

// Implemented product class and its attributes in reference to class Customer.
public class Product {
	
	private int id;
	private String title;
	private String releaseDate;
	private double price;
	private String genre;
	private char rating;
	
	Product(int id, String title, String releaseDate, double price, String genre, char rating) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.price = price;
		this.genre = genre;
		this.rating = rating;
	}
	
	//Setters
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setRating(char rating) {
		this.rating = rating;
	}
	
	//Getters
	public String getTitle() {
		return title;
	}
	
	public int getId() {
		return id;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public char getRating() {
		return rating;
	}
	
	public static int SIZE() {
		return 98;
	}
}
