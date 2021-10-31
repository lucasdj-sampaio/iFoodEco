package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.com.ifoodeco.entity.Adress;
import br.com.ifoodeco.entity.Packaging;
import br.com.ifoodeco.entity.PayMethod;
import br.com.ifoodeco.entity.Pix;
import br.com.ifoodeco.entity.Restaurant;

public class RestaurantDao {
	
	ConnectionManager conn = new ConnectionManager();
	
	public boolean insertRestautantDao(Restaurant restaurant) {
		try {
			if (!insertAdress(restaurant.getAdress())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertRestaurant(restaurant)) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertPix(restaurant.getPixList())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertPack(restaurant.getPackList())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertPay(restaurant.getPayList())) {
				conn.getConnection().rollback();
				return false;
			}
			
			conn.getConnection().commit();
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
			conn.closeConnection();
		}
	}
	
	private int getPlainId(String plainName) {
		
	}
	
	private int getCategoryId(String categoryName) {
		
	}
	
	private boolean insertAdress(Adress adress) {
		try {
						
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
			conn.closeConnection();
		}
	}
	
	private boolean insertRestaurant(Restaurant restaurante) {
		try {
			
			PreparedStatement snack = conn.getConnection().prepareStatement("");
			
			snack.setString(1, userName);
			snack.setString(2, data.typeFood);
			snack.setDate(3, java.sql.Date.valueOf(data.inclusionDate));
			
			conn.executeCommand(snack);
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
			conn.closeConnection();
		}	
	}
	
	private boolean insertPix(List<Pix> pixList) {
		try {
			for (Pix pix : pixList) {
				
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
			conn.closeConnection();
		}
	} 
	
	private boolean insertPack(List<Packaging> packList) {
		try {
			for (Packaging pack : packList) {
			
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
			conn.closeConnection();
		}
	} 
	
	private boolean insertPay(List<PayMethod> paymentList) {
		try {
			for (PayMethod payment : paymentList) {
				
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
			conn.closeConnection();
		}
	}
}