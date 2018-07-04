package Ratatoullie_LIFIA.model.controllers;

import java.util.LinkedList;
import java.util.List;

import Ratatoullie_LIFIA.model.Dish;

public class DishController {
	private List<Dish> dishes;

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public DishController() {
		super();
		this.setDishes(new LinkedList<Dish>());
	}
	
	public void addDish(Dish dish) {
		this.getDishes().add(dish);
	}
	
	//Metodos propios del controller
	
	/**
	* Crea un plato nuevo y lo agrega al sistema
	* @param name nombre del plato
	* @param price precio del plato
	* @param description descripcion del plato
	* @param tag tag del plato
	* @return el plato creado
	*/
	public Dish createDish(String name, double price, String description, String tag ){
		Dish dish = new Dish(name, price, description, tag);
		this.addDish(dish);
		return dish;
	}
	
}
