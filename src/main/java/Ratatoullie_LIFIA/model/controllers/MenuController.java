package Ratatoullie_LIFIA.model.controllers;

import java.util.LinkedList;
import java.util.List;

import Ratatoullie_LIFIA.model.Dish;
import Ratatoullie_LIFIA.model.Menu;
import Ratatoullie_LIFIA.model.Restaurant;

public class MenuController {
	private List<Menu> menus;
	
	public MenuController() {
		super();
		this.setMenus(new LinkedList<Menu>());
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public void addMenu(Menu menu){
		this.getMenus().add(menu);		
	}
	
	//Metodos propios del controller
	/**
	 * Crea el menu para el restaurante
	 * @param restaurant a agregar el menu creado
	 * @param name nombre del menu
	 * @param description descripcion del menu
	 * @return el menu creado
	 */
	public Menu createMenu(Restaurant restaurant, String name, String description) {
		Menu menu = new Menu(name, description);
		restaurant.addMenu(menu);	
		return menu;
	}
	
	/**
	 * Agrega un plato al menu
	 * @param menu menu a agregar el plato
	 * @param dish plato a ser agregado al menu
	 */
	public void addDish(Menu menu, Dish dish) {
		menu.addDish(dish);
	}
	
	/**
	 * Elimina un plato del menu
	 * @param menu a eliminar el plato
	 * @param dish plato a eliminar
	 */
	public void deleteDishFromMenu(Menu menu, Dish dish) {
		menu.deleteDish(dish);		
	}
	
	/**
	* Devuelve una lista de menus que contengan el conjunto de etiquetas cuyos nombres son descriptos en <code>labels</code>
	* @param labels etiquetas requeridas para el menu
    * @return La lista de menus que satisfaga los criterios descriptos
	*/
	public List<Menu> getMatchingMenusInLabels(String... labels) {
		List<Menu> menus = new LinkedList<Menu>();
		//completar...
		//
		//
		return menus;
	}
	
	
}
