package Ratatoullie_LIFIA.model;

public enum Category {
	FOURTH("De cuarta"),
	THIRD("De tercera"),
	SECOND("De segunda"),
	FIRST("De primera"),
	DELUXE("De lujo");
	
	private String category;
	
	Category(String category){
		this.category = category;
	}
	public String category() {
		return category;
	}
	
	public String toString() {
		return category;
	}
}
