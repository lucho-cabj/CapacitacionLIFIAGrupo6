package Ratatoullie_LIFIA.model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Restaurant {
	private Long id;
	private String name;
	private Category category;
	private Location location;
	private List<Menu> menus;
	private List<byte[]> photos;
	private List<Comment> comments;
	
	public Restaurant() {
		super();
	}
	
	public Restaurant(String name, Category category, Location location) {
		super();
		this.setName(name);
		this.setLocation(location);
		this.setCategory(category);
		this.setMenus(new LinkedList<Menu>());
		this.setPhotos(new LinkedList<byte[]>());
		this.setComments(new LinkedList<Comment>());
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public void addMenu(Menu menu) {
		this.getMenus().add(menu);		
	}
	
	public void deleteMenu(Menu menu) {
		ListIterator<Menu> it = this.getMenus().listIterator();
		while(it.hasNext()){
			Menu men = it.next();
			if (men.getId() == menu.getId()){
				it.previous();
				it.remove();
			}
		}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<byte[]> getPhotos() {
		return photos;
	}

	public void setPhotos(List<byte[]> photos) {
		this.photos = photos;
	}
	
	public void addPhoto(byte[] photo) {
		this.getPhotos().add(photo);
	}
	
	public void deletePhoto(byte[] photo) {
		ListIterator<byte[]> it = this.getPhotos().listIterator();
		while(it.hasNext()){
			byte[] phot = it.next();
			if (phot.equals(photo)){
				it.previous();
				it.remove();
			}
		}
	}

	public void addComment(Comment comment) {
		this.getComments().add(comment);		
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
