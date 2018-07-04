package Ratatoullie_LIFIA.model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Menu {
	private Long id;
	private String name;
	private double price;
	private String description;
	private List<LabelsMenu> tags;
	private List<Dish> dishes;
	private List<Comment> comments;
	
	public Menu() {
		super();
	}	
	
	public Menu(String name, String description) {
		super();
		this.setName(name);
		this.setDescription(description);
		this.setTags(new LinkedList<LabelsMenu>());
		this.setDishes(new LinkedList<Dish>());
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<LabelsMenu> getTags() {
		return tags;
	}

	public void setTags(List<LabelsMenu> tags) {
		this.tags = tags;
	}
	
	public void addLabel(LabelsMenu label) {
		this.getTags().add(label);
	}
	
	public void deleteTag(LabelsMenu labelMenu) {
		ListIterator<LabelsMenu> it = this.getTags().listIterator();
		while(it.hasNext()){
			LabelsMenu tag = it.next();
			if (tag.equals(labelMenu)){
				it.previous();
				it.remove();
			}
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	public void addDish(Dish dish) {
		this.getDishes().add(dish);
	}
	
	public void deleteDish(Dish dish) {
		ListIterator<Dish> it = this.getDishes().listIterator();
		while(it.hasNext()){
			Dish dis = it.next();
			if (dis.getId() == dish.getId()){
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
