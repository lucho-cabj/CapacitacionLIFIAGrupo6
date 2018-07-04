package Ratatoullie_LIFIA.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	private Long id;
	private String title;
	private String description;
	private Restaurant restaurant;
	private Menu menu;
	private double vote;
	private Date date;
	
	public Comment() {
		super();
	}
	
	public Comment(String title, String description, Restaurant restaurant, Menu menu, double vote) {
		super();
		this.title = title;
		this.description = description;
		this.restaurant = restaurant;
		this.menu = menu;
		this.vote = vote;
		this.setDate(new Date());
	}
	
	public Comment(String title, String description, Restaurant restaurant, double vote) {
		super();
		this.title = title;
		this.description = description;
		this.restaurant = restaurant;
		this.vote = vote;
		this.setDate(new Date());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public double getVote() {
		return vote;
	}

	public void setVote(double vote) {
		this.vote = vote;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
