package Ratatoullie_LIFIA.model;

import java.util.Date;
import java.util.LinkedList;

public class NormalUser extends User {

	public NormalUser() {
		super();
	}
	
	public NormalUser(String name , String username, String password, Date birthDate, Location location ) {
		super();
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setBirthDate(birthDate);
		this.setLocation(location);
		this.setRank(RankUser.VISITANTS);
		this.setComments(new LinkedList<Comment>());		
		this.setFriends(new LinkedList<User>());
	}

	@Override
	public boolean isResponsible() {
		return false;
	}
	
}
