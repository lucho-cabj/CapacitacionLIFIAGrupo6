package Ratatoullie_LIFIA.model.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import Ratatoullie_LIFIA.model.*;


public class UserController {
	
	private List<User> users;

	public UserController() {
		super();
		this.setUsers(new LinkedList<User>());
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	private void addUser(User user) {
		this.getUsers().add(user);		
	}
	
	
	
	//Metodos propios del controller
	/**
	* Verifica si el usuario con username existe en el sistema
	* @param username nombre de usuario a verificar si existe
	* @return true si el usuario existe, false caso contrario.
	*/
	private boolean existUser(String username) {
		User user;
		ListIterator<User> it = this.getUsers().listIterator();
		while (it.hasNext()) {
			user = it.next();
			if (user.getUsername() == username) {
				return true; //se encontro el usuario con username
			}
		}
		return false; // no se encontro el usuario con username
	}
	
	/**
	* Crea un usuario normal
	* @param name nombre del usuario
	* @param username nombre de usuario en el sistema
	* @param password contraseña del usuario
	* @param birthDate fecha de nacimiento
	* @param location direccion del usuario
	* @return el usuario normal creado
	* @throws RepeatedUsernameException excepcion por nombre de usuario repetido 
	*/
	public NormalUser createNormalUser(String name, String username, String password , Date birthDate, Location location) throws RepeatedUsernameException {
		
		if (!this.existUser(username)) {
			//el usuario no existe en el sistema, se lo crea y agrega al sistema
			NormalUser user = new NormalUser(name, username, password, birthDate, location);
			this.addUser(user);
			return user;
		}else {
			throw new RepeatedUsernameException("El usuario "+username+" ya existe en el sistema.");
		}		
		/**
		try {
			if (!this.existUser(username)) {
				//el usuario no existe en el sistema, se lo crea y agrega al sistema
				NormalUser user = new NormalUser(name, username, password, birthDate, location);
				this.addUser(user);
				return user;
			}
		}catch (Exception e) {
			throw new RepeatedUsernameException("El usuario "+username+" ya existe en el sistema.");
		}
		return null;*/
		
	}
	
	
	/**
	* Crea un usuario responable
	* @param name nombre del usuario
	* @param username nombre de usuario en el sistema
	* @param password contraseña del usuario
	* @param birthDate fecha de nacimiento
	* @param location direccion del usuario
	* @return el usuario responsable creado
	* @throws RepeatedUsernameException excepcion por nombre de usuario repetido 
	*/
	public ResponsibleUser createResponsibleUser(String name, String username, String password , Date birthDate, Location location) throws RepeatedUsernameException {
		if (!this.existUser(username)) {
			//el usuario no existe en el sistema, se lo crea y agrega al sistema
			ResponsibleUser user = new ResponsibleUser(name, username, password, birthDate, location);
			this.addUser(user);
			return user;
		}else {
			throw new RepeatedUsernameException("El usuario "+username+" ya existe en el sistema.");
		}	
	}
	
	
	/**
	* Se agrega un amigo a un usuario en su lista de amigos, es reciproco. 
	* @param user usuario a agregar amigo
	* @param friend usuario a ser agregado como amigo
	*/
	
	public void addFriendToUser(User user, User friend) {
		user.addFriend(friend);
		friend.addFriend(user);		
	}
	
	/**
	* Se elimina un amigo a un usuario en su lista de amigos, es reciproco. 
	* @param user usuario que va a eliminar un amigo
	* @param friend usuario que va a ser eliminado como amigo
	*/
	public void deleteFriendToUser(User user, User friend) {
		user.deleteFriend(friend);
		friend.deleteFriend(user);		
	}
	
	/**
	* Obtiene un usuario por su username
	* @param username username del usuario a buscar
	* @return el usuario que coincida o null si no hay ninguna coincidencia
	*/
	public User findUserByUsername(String username) {
		User user = null;
		ListIterator<User> it = this.getUsers().listIterator();
		while (it.hasNext()) {
			user = it.next();
			if (user.getUsername() == username) {
				return user;
			}
		}
		user = null; //no se encontro el usuario.
		return user;
	}
	
	/**
	 * Lista los usuarios que tienen mejor score, .
	 * @return Una lista de usuarios con mejor score.
	 */
	public List<User> usersWithBestScore() {
		List<User> users = new LinkedList<User>();
		ListIterator<User> it = this.getUsers().listIterator();
		while (it.hasNext()) {
			User user = it.next();
			if (user.getRank() == RankUser.GOURMETS) {
				users.add(user);
			}
		}
		return users;		
	}
	
	/**
	 * Cambia el score de un usuario
	 * @param user usuario a modificar su score
	 * @param rank score nuevo
	 */
	public void changeScoreForUser(User user, RankUser rank) {
		user.setRank(rank);		
	}
	
	

	
	/**
	* Obtiene todos los amigos del usuario solicitado
	* @param username nombre de usuario
	* @return Una lista de amigos del usuario requerido, o null en caso que no exista el usuario.
	*/
	public List<User> getAllFriendsForUser(String username){
		if (this.existUser(username)) {
			return this.findUserByUsername(username).getFriends();			
		}else {
			return null; // el usuario no existe
		}
	}
	
	/**
	* Agrega un restaurante a un responsable
	* @param user usuario responsable del restaurante
	*/
	public void addRestaurantToResponsible(ResponsibleUser user,  Restaurant restaurant) {
		user.addRestaurant(restaurant);		
	}
	
	/**
	* Lista todos los restaurantes creados por el usuario correspondiente a username
	* @param username nombre de usuario
	* @return una lista de restaurantes del usuario responsable con nombre de usuario 'username'
	*/
	public List<Restaurant> getAllRestaurantsCreatedByUser(String username){
		if(this.existUser(username)) {
			User user = this.findUserByUsername(username);
			if(user.isResponsible()) {
				ResponsibleUser resp = (ResponsibleUser) this.findUserByUsername(username);
				return resp.getRestaurants();
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	
	/**
	 * Listar la cantidad total de usuarios visitantes / comensales / gourmets
	 * @return Un hashmap con la cantidad total de usuarios visitantes / comensales / gourmets
	 */
	public HashMap<String, Integer> amountUsersByRank(){
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		int visitants = 0, commensals = 0, gourmets = 0;
		ListIterator<User> it = this.getUsers().listIterator();
		while (it.hasNext()) {
			User user = it.next();
			if (user.getRank() == RankUser.VISITANTS) {
				++visitants;
			}else if (user.getRank() == RankUser.COMMENSALS) {
				++commensals;
			}else {
				++gourmets;
			}
		}
		hash.put(RankUser.VISITANTS.toString(), visitants);
		hash.put(RankUser.COMMENSALS.toString(), commensals);
		hash.put(RankUser.GOURMETS.toString(), gourmets);
		return hash;
	}
	
}
