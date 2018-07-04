package Ratatoullie_LIFIA.model.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import Ratatoullie_LIFIA.model.Category;
import Ratatoullie_LIFIA.model.Comment;
import Ratatoullie_LIFIA.model.Dish;
import Ratatoullie_LIFIA.model.Location;
import Ratatoullie_LIFIA.model.Menu;
import Ratatoullie_LIFIA.model.RankUser;
import Ratatoullie_LIFIA.model.Restaurant;
import Ratatoullie_LIFIA.model.User;

public class RestaurantController {
	private List<Restaurant> restaurants;
	
	public RestaurantController() {
		super();
		this.setRestaurants(new LinkedList<Restaurant>());
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	public void addRestaurant(Restaurant restaurant) {
		this.getRestaurants().add(restaurant);
	}
	
	//Metodos propios del controller
	/**
	 * crea un restaurante nuevo
	 * @param name nombre del restaurante
	 * @param category categoria del restaurante
	 * @param location ubicacion del restaurante
	 * @return el restaurante creado 
	 */
	public Restaurant createRestaurant(String name, Category category, Location location) {
		Restaurant restaurant = new Restaurant(name, category, location);
		this.addRestaurant(restaurant);
		return restaurant;
	}
	
	/**
	* Obtiene un restaurante por su nombre
	* @param name nombre del restaurante a buscar
	* @return el restaurante que coincida o null si no hay ninguna coincidencia
	*/
	public Restaurant findRestaurantByName(String name){
		Restaurant rest = null;
		ListIterator<Restaurant> it = this.getRestaurants().listIterator();
		while (it.hasNext()) {
			rest = it.next();
			if (rest.getName() == name) {
				return rest;
			}
		}
		rest = null; //no se encontro el restaurante.
		return rest;
	}
	
	/**
	* Obtiene todos los menus del restaurante solicitado
	* @param restaurant restaurante de donde se van a obtener los menus
	* @return Una lista de menus del restaurante requerido
	*/
	public List<Menu> getAllMenusByRestaurant(Restaurant restaurant){
		return restaurant.getMenus();
	}
	
	/**
	 * Devuelve una lista de restaurantes que tuvieron mas comentarios en un determinado rango de fechas.
	 * @param from fecha de inicio
	 * @param to fecha de fin
	 * @return Una lista de restaurantes que tuvieron mas comentarios entre las fecha from y to.
	 */
	public List<Restaurant> restaurantsHavingMoreCommentsBetween(Date from, Date to){
		List<Restaurant> restaurants = new LinkedList<Restaurant>();
		ListIterator<Restaurant> it = this.getRestaurants().listIterator();
		while (it.hasNext()) {
			Restaurant rest = it.next();
			ListIterator<Comment> itComments = rest.getComments().listIterator();
			while (itComments.hasNext()) {
				Comment com = itComments.next();
				if (com.getDate().after(from) && com.getDate().before(to) ) {
					restaurants.add(rest);
				}
			}
		}
		return restaurants;
	}
	
	/**
	 * Agrega un menu a un restaurante
	 * @param restaurant restaurante a agregar un menu
	 * @param menu a ser agregado
	 */
	public void addMenuToRestaurant(Restaurant restaurant, Menu menu) {
		restaurant.addMenu(menu);
	}
	
	/**
	 * Elimina un menu de un restaurante
	 * @param restaurant restaurante de donde se eliminara un menu determinado
	 * @param menu menu a ser eliminado
	 */
	public void deleteMenuFromRestaurant(Restaurant restaurant, Menu menu) {
		restaurant.deleteMenu(menu);		
	}
	
	/**
	 * Agrega un plato a un menu determinado
	 * @param menu menu a agregar un plato
	 * @param dish plato a ser agregado
	 */
	public void addDish(Menu menu, Dish dish) {
		menu.addDish(dish);
	}
	
	/**
	 * Elimina un plato de un menu
	 * @param menu de donde se eliminara un menu determinado
	 * @param dish plato a ser eliminado
	 */
	public void deleteDishFromMenu(Menu menu, Dish dish) {
		menu.deleteDish(dish);
	}
	
	
	
}
