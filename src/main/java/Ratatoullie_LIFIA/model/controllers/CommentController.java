package Ratatoullie_LIFIA.model.controllers;

import java.util.LinkedList;
import java.util.List;

import Ratatoullie_LIFIA.model.Comment;
import Ratatoullie_LIFIA.model.Menu;
import Ratatoullie_LIFIA.model.Restaurant;
import Ratatoullie_LIFIA.model.User;

public class CommentController {
	private List<Comment> comments;
	
	public CommentController() {
		super();
		this.setComments(new LinkedList<Comment>());
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
	
	
	//Metodos propios del controller
	
	/**
	 * Crea un comentario para un restaurante
	 * @param user usuario que realiza el comentario
	 * @param title titulo del comentario
	 * @param description descripcion del comentario
	 * @param restaurant restaurante al que se le realiza el comentario
	 * @param vote voto
	 * @return el comentario realizado al restaurante
	 */
	public Comment createCommentRestaurant(User user, String title, String description, Restaurant restaurant, double vote) {
		Comment comment = new Comment(title, description, restaurant, vote);
		user.addComment(comment);
		restaurant.addComment(comment);		
		return comment;
	}

	/**
	 * Crea un comentario para un menu
	 * @param user usuario que realiza el comentario
	 * @param title titulo del comentario
	 * @param description descripcion del comentario
	 * @param restaurant restaurante que posee el menu
	 * @param menu menu al que se le realiza el comentario
	 * @param vote voto
	 * @return el comentario realizado al menu
	 */
	public Comment createCommentMenu(User user, String title, String description, Restaurant restaurant, Menu menu, double vote) {
		Comment comment = new Comment(title, description, restaurant, menu, vote);
		user.addComment(comment);	
		menu.addComment(comment);
		return comment;
	}



	

}
