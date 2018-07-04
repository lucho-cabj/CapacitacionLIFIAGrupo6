package Ratatoullie_LIFIA.model;

public enum RankUser {
	VISITANTS("Visitantes"),
	COMMENSALS("Comensales"),
	GOURMETS("Gourmets");
	
	private String rank;
	
	RankUser(String rank){
		this.rank = rank;
	}
	public String rank() {
		return rank;
	}
	
	public String toString() {
		return rank;
	}
}