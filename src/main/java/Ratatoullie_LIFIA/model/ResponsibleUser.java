package Ratatoullie_LIFIA.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ResponsibleUser extends User {
	
	private List<Restaurant> restaurants;
	
	public ResponsibleUser() {
		super();
	}
	
	public ResponsibleUser(String name , String username, String password, Date birthDate, Location location ) {
		super();
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setBirthDate(birthDate);
		this.setLocation(location);
		this.setRank(RankUser.VISITANTS);
		this.setComments(new LinkedList<Comment>());		
		this.setFriends(new LinkedList<User>());
		this.setRestaurants(new LinkedList<Restaurant>());
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	public void addRestaurant(Restaurant restaurant) {
		this.getRestaurants().add(restaurant);		
	}

	@Override
	public boolean isResponsible() {
		return true;
	}
	
	
}
