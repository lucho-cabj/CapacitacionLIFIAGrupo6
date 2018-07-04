package Ratatoullie_LIFIA.model;

public enum LabelsMenu {
	VEGETARIANO("#Vegetariano"),
	LOWCALORIE("#LowCalorie"),
	HIGHCALORIE("#HighCalorie"),
	DAIRY("#Lacteo"),
	FRUITS("#Frutas"),
	PROTEIN("#Proteina"),
	GRAINS("#Granos"),
	VEGETABLES("#Vegetales"),
	FISHES("#Pescados"),
	EGGS("#Huevos"),
	HEALTHY("#Saludable"),
	FASTFOOD("#FastFood"),
	TACFREE("#TacFree"),
	VEGAN("#Vegano");
	
	private String label;
	
	LabelsMenu(String label){
		this.label = label;
	}
	public String label() {
		return label;
	}
	
	public String toString() {
		return label;
	}
}
