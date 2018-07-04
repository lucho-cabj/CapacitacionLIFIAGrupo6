package Ratatoullie_LIFIA.model;

public class Location {
	private Long id;
	private String name;
	private double lalitude;
    private double length;
    
    public Location() {
    	super();
    }
    
    public Location(String name, double latitude, double length) {
    	super();
    	this.setName(name);
    	this.setLalitude(latitude);
    	this.setLength(length);
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
	
	public double getLalitude() {
		return lalitude;
	}
	
	public void setLalitude(double lalitude) {
		this.lalitude = lalitude;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}  
    
    
    
}
