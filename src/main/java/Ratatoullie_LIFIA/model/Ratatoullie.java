package Ratatoullie_LIFIA.model;

import Ratatoullie_LIFIA.model.controllers.CommentController;
import Ratatoullie_LIFIA.model.controllers.DishController;
import Ratatoullie_LIFIA.model.controllers.LocationController;
import Ratatoullie_LIFIA.model.controllers.MenuController;
import Ratatoullie_LIFIA.model.controllers.RestaurantController;
import Ratatoullie_LIFIA.model.controllers.UserController;

public class Ratatoullie {
	private static Ratatoullie instance;
	private UserController userController;
	private RestaurantController restaurantController;
	private LocationController locationController;
	private MenuController menuController;
	private DishController dishController;
	private CommentController commentController;
	
	private Ratatoullie() {
		this.setUserController(new UserController());
		this.setRestaurantController(new RestaurantController());
		this.setLocationController(new LocationController());
		this.setMenuController(new MenuController());
		this.setDishController(new DishController());
		this.setCommentController(new CommentController());		
	}

	public static Ratatoullie getInstance() {
		if (instance == null) {
			instance = new Ratatoullie();
		}
		return instance;
	}

	public static void setInstance(Ratatoullie instance) {
		Ratatoullie.instance = instance;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public RestaurantController getRestaurantController() {
		return restaurantController;
	}

	public void setRestaurantController(RestaurantController restaurantController) {
		this.restaurantController = restaurantController;
	}

	public LocationController getLocationController() {
		return locationController;
	}

	public void setLocationController(LocationController locationController) {
		this.locationController = locationController;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

	public DishController getDishController() {
		return dishController;
	}

	public void setDishController(DishController dishController) {
		this.dishController = dishController;
	}

	public CommentController getCommentController() {
		return commentController;
	}

	public void setCommentController(CommentController commentController) {
		this.commentController = commentController;
	}
	
	
	
}
