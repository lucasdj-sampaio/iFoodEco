package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.ifoodeco.entity.Packaging;
import br.com.ifoodeco.entity.PayMethod;
import br.com.ifoodeco.entity.Pix;
import br.com.ifoodeco.entity.Restaurant;

public class RestaurantDao {
	
	public static Restaurant getRestaurant(long cnpjNumber) {
		ConnectionManager conn = new ConnectionManager();
		
		Restaurant restaurant = new Restaurant();
	    restaurant.setCnpjNumber(cnpjNumber);
		
		try {
			PreparedStatement getRestaurant = conn.getConnection().prepareStatement("SELECT nm_plano, "
					+ "nm_categoria, nm_restaurante, nr_telefone, ent_agendada, email, nr_agencia, "
					+ "nr_conta FROM T_CADASTRO CD, T_PLANO P, T_CATEGORIA C "
					+ "WHERE CD.cd_plano = P.cd_plano "
					+ "AND CD.cd_categoria = C.cd_categoria AND nr_cnpj = ?");
			
			getRestaurant.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getRestaurant);
			
			if (result.next()) {
			    restaurant.setPlan(result.getString(1));
			    restaurant.setCategory(result.getString(2));
				restaurant.setName(result.getString(3));
			    restaurant.setNumber(result.getLong(4));
			    restaurant.setScheduledDelivery(result.getBoolean(5));
			    restaurant.setEmailAddress(result.getString(6));
			    restaurant.setAgencyNumber(result.getInt(7));
			    restaurant.setAccountNumber(result.getInt(8));
			}
			
		    restaurant.setAddress(AddressDao.getAddress(conn, cnpjNumber));
		    restaurant.setPixList(PixDao.getAll(conn, cnpjNumber));
		    restaurant.setPackList(PackagingDao.getAll(conn, cnpjNumber));
		    restaurant.setPayList(PayDao.getAll(conn, cnpjNumber));
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return restaurant;
	}
	
	public List<Restaurant> getAll(){
		return null;
	}
	
	public static boolean insertRestaurantDao(Restaurant restaurant) {
		ConnectionManager conn = new ConnectionManager();
		
		try {	
			if (!AddressDao.insertAddress(conn, restaurant.getAddress())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertRestaurant(conn, restaurant)) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!PixDao.insertPix(conn, restaurant.getPixList()
					, restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!PackagingDao.insertPack(conn, restaurant.getPackList()
					, restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!PayDao.insertPay(conn, restaurant.getPayList()
					, restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			else
			{
				conn.getConnection().commit();
				return true;
			}			
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
	
	private static boolean insertRestaurant(ConnectionManager conn, Restaurant restaurant) {
		try {
			
			PreparedStatement restaurantInsert = conn.getConnection().prepareStatement("INSERT INTO "
					+ "T_CADASTRO VALUES (?, (SELECT MAX(cd_endereco) FROM T_ENDERECO), "
					+ "?, ?, ?, ?, ?, ?, ?, ?)");
			
			restaurantInsert.setLong(1, restaurant.getCnpjNumber());
			restaurantInsert.setInt(2, getPlanId(conn, restaurant.getPlan()));
			restaurantInsert.setInt(3, getCategoryId(conn, restaurant.getCategory()));
			restaurantInsert.setString(4, restaurant.getName());
			restaurantInsert.setLong(5, restaurant.getNumber());
			restaurantInsert.setBoolean(6, restaurant.isScheduledDelivery());
			restaurantInsert.setString(7, restaurant.getEmailAddress());
			restaurantInsert.setInt(8, restaurant.getAgencyNumber());
			restaurantInsert.setInt(9, restaurant.getAccountNumber());
						
			if (conn.executeCommand(restaurantInsert, false) != 0) 
			{
				return true;
			}
			
			return false;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}	
	}
	
	private static int getPlanId(ConnectionManager conn, String planName) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_plano "
					+ "FROM T_PLANO WHERE nm_plano = ?");
			
			getId.setString(1, planName);
						
			ResultSet result = conn.getData(getId);
			
			if (result.next()) {
				return result.getInt(1);
			}
			
			return 0;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
	private static int getCategoryId(ConnectionManager conn, String categoryName) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_categoria "
					+ "FROM T_CATEGORIA WHERE nm_categoria = ?");
			
			getId.setString(1, categoryName);
						
			ResultSet result = conn.getData(getId);
			
			if (result.next()) {
				return result.getInt(1);
			}
			
			return 0;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
	public static boolean updateRestaurantDao(Restaurant restaurant) {
		for (Packaging pack : restaurant.getPackList()) {
			if(!PackagingDao.updatePack(pack)) {
				return false;
			}
		}
		for (PayMethod pay : restaurant.getPayList()) {
			if(!PayDao.updatePay(pay)) {
				return false;
			}
		}
		for (Pix pix : restaurant.getPixList()) {
			if(!PixDao.updatePix(pix)) {
				return false;
			}
		}
		
		if(!AddressDao.updateAddress(restaurant.getAddress())) {
			return false;
		}
		
		if(RestaurantDao.updateRestaurant(restaurant)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean updateRestaurant(Restaurant restaurant) {
		ConnectionManager conn = new ConnectionManager();
		
		try {		
			PreparedStatement restaurantUpdate = conn.getConnection().prepareStatement("UPDATE T_CADASTRO "
					+ "SET CD_PLANO = ?, CD_CATEGORIA = ?, NM_RESTAURANTE = ?"
					+ ", NR_TELEFONE = ?, ENT_AGENDADA = ?, EMAIL = ?, NR_AGENCIA = ?"
					+ ", NR_CONTA = ? WHERE NR_CNPJ = ?");
			
			restaurantUpdate.setInt(1, getPlanId(conn, restaurant.getPlan()));
			restaurantUpdate.setInt(2, getCategoryId(conn, restaurant.getCategory()));
			restaurantUpdate.setString(3, restaurant.getName());
			restaurantUpdate.setLong(4, restaurant.getNumber());
			restaurantUpdate.setBoolean(5, restaurant.isScheduledDelivery());
			restaurantUpdate.setString(6, restaurant.getEmailAddress());
			restaurantUpdate.setInt(7, restaurant.getAgencyNumber());
			restaurantUpdate.setInt(8, restaurant.getAccountNumber());
			restaurantUpdate.setLong(9, restaurant.getCnpjNumber());
								
			if (conn.executeCommand(restaurantUpdate, false) == 1) 
			{
				conn.getConnection().commit();
				return true;
			}
			
			return false;
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