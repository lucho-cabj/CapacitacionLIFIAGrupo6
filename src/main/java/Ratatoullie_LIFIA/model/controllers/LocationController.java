package Ratatoullie_LIFIA.model.controllers;

import java.util.LinkedList;
import java.util.List;

import Ratatoullie_LIFIA.model.Location;

public class LocationController {
	private List<Location> locations;
	
	public LocationController() {
		super();
		this.locations = new LinkedList<Location>();
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public void addLocation(Location location) {
		this.getLocations().add(location);		
	}

	
	/**
	 * Crea una ubicacion para un restaurante o para un usuario
	 * @param name nombre de la ubicacion
	 * @param latitude latitud de la ubicacion
	 * @param length longitud de la ubicacion
	 * @return la ubicacion creada
	 */
	public Location createLocation(String name, double latitude, double length) {
		Location location = new Location(name, latitude, length);	
		this.addLocation(location);
		return location;
	}

	
	
}
