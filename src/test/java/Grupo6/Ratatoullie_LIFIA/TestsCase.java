package Grupo6.Ratatoullie_LIFIA;

import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Ratatoullie_LIFIA.model.Category;
import Ratatoullie_LIFIA.model.Location;
import Ratatoullie_LIFIA.model.NormalUser;
import Ratatoullie_LIFIA.model.Ratatoullie;
import Ratatoullie_LIFIA.model.RepeatedUsernameException;
import Ratatoullie_LIFIA.model.ResponsibleUser;
import Ratatoullie_LIFIA.model.Restaurant;

class TestsCase {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateNormalUser() throws RepeatedUsernameException {
    	String username="juan144";
    	boolean exceptionThrown = false;
    	
    	
		NormalUser user = Ratatoullie.getInstance().getUserController().createNormalUser("Juan Perez", username, "pass1234", new Date(1992,12,30), new Location("domicilio", 12.2, 33.45));
		
        Assert.assertNotNull(user);
        Assert.assertEquals("juan144", user.getUsername());
        
        try {
        	username="juan144assaas";
        	Ratatoullie.getInstance().getUserController().createNormalUser("Juan Perez", username, "pass1234", new Date(1992,12,30), new Location("domicilio", 12.2, 33.45));
    		
        } catch (RepeatedUsernameException e){
        	exceptionThrown = true;
        }
        if (exceptionThrown) {
        	Assert.fail("El usuario "+username+" ya existe en el sistema.");
        }
        
    }
	
	@Test
	public void testCreateRestaurant() throws RepeatedUsernameException {
		@SuppressWarnings("deprecation")
		ResponsibleUser user = Ratatoullie.getInstance().getUserController().createResponsibleUser("Carlos Perez", "responsable", "121212", new Date(1990,12,14), new Location("calle 123", 1.2, 22.3));
		Restaurant restaurant = Ratatoullie.getInstance().getRestaurantController().createRestaurant("Restaurante 1", Category.FIRST, new Location("domicilio", 12.33, 3.44));
		Restaurant restaurant2 = Ratatoullie.getInstance().getRestaurantController().createRestaurant("Restaurante 2", Category.SECOND, new Location("domicilio2", 123.33, 3.44));
		
		Ratatoullie.getInstance().getRestaurantController().addRestaurant(restaurant);		
		Ratatoullie.getInstance().getUserController().addRestaurantToResponsible(user, restaurant);
		Ratatoullie.getInstance().getRestaurantController().addRestaurant(restaurant2);
		Ratatoullie.getInstance().getUserController().addRestaurantToResponsible(user, restaurant2);
		
		
		Assert.assertEquals(restaurant, Ratatoullie.getInstance().getUserController().getAllRestaurantsCreatedByUser("responsable").get(0));
		Assert.assertEquals(restaurant2, Ratatoullie.getInstance().getUserController().getAllRestaurantsCreatedByUser("responsable").get(1));
		
	}
	
	
	@Test
	public void test() {
		
		//Ratatoullie.getInstance().get
		
	}
}
