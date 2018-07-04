package Ratatoullie_LIFIA.model;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;


public abstract class User {
	private Long id;
	private String name;
	private String username;
	private String password;	
	private Date birthDate;
	private Location location;
	private RankUser rank;
	private List<User> friends;
	private byte[] photo;
	private List<Comment> comments;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	public RankUser getRank() {
		return rank;
	}

	public void setRank(RankUser rank) {
		this.rank = rank;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public void addFriend(User user) {
		this.getFriends().add(user);
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.getComments().add(comment);		
	} 
	
	public void deleteComment(Comment comment) {
		ListIterator<Comment> it = this.getComments().listIterator();
		while(it.hasNext()){
			Comment com = it.next();
			if (com.getId() == comment.getId()){
				it.previous();
				it.remove();
			}
		}
	}

	public void deleteFriend(User user) {
		ListIterator<User> it = this.getFriends().listIterator();
		while(it.hasNext()){
			User friendD = it.next();
			if (friendD.getId() == user.getId()){
				it.previous();
				it.remove();
			}
		}		
	}

	public abstract boolean isResponsible();
	
}