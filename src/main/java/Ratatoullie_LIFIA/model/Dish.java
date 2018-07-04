package Ratatoullie_LIFIA.model;

public class Dish {
	private Long id;
	private String name;
	private double price;
	private String description;
	private String tag;
	
	public Dish() {
		super();
	}

	public Dish(String name, double price, String description, String tag) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.tag = tag;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
	
	
}
