package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.entity.Adress;
import br.com.ifoodeco.entity.Packaging;
import br.com.ifoodeco.entity.PayMethod;
import br.com.ifoodeco.entity.Pix;
import br.com.ifoodeco.entity.Restaurant;

public class RestaurantDao {
	
	ConnectionManager conn = new ConnectionManager();
	
	public Restaurant getRestaurant(int cnpjNumber) {
		
		Restaurant restaurant = new Restaurant();
	    restaurant.setCnpjNumber(cnpjNumber);
		
		try {
			PreparedStatement getRestaurant = conn.getConnection().prepareStatement("SELECT nm_plano, "
					+ "nm_categoria, nm_restaurante, nr_telefone, ent_agendada, email, nr_agencia, "
					+ "nr_conta FROM T_CADASTRO CD INNER JOIN T_PLANO P INNER JOIN T_CATEGORIA C "
					+ "WHERE CD.cd_planp = P.cd_plano "
					+ "AND CD.cd_categoria = C.cd_categoria nr_cnpj = ?");
			
			getRestaurant.setInt(1, cnpjNumber);
						
			ResultSet result = conn.getData(getRestaurant);
			
			if (result.next()) {
			    restaurant.setPlain(result.getString(1));
			    restaurant.setCategory(result.getString(2));
				restaurant.setName(result.getString(3));
			    restaurant.setNumber(result.getInt(4));
			    restaurant.setScheduledDelivery(result.getBoolean(5));
			    restaurant.setEmailAdress(result.getString(6));
			    restaurant.setAgencyNumber(result.getInt(7));
			    restaurant.setAccountNumber(result.getInt(8));
			}
			
		    restaurant.setAdress(AdressDao.getAdress(conn, cnpjNumber));
		    restaurant.setPixList(PixDao.getAll(conn, cnpjNumber));
		    restaurant.setPackList(PackagingDao.getAll(conn, cnpjNumber));
		    restaurant.setPayList(PayDao.getAll(conn, cnpjNumber));
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return restaurant;
	}
	
	public List<Restaurant> getAll(){
		return null;
	}
	
	public boolean insertRestautantDao(Restaurant restaurant) {
		try {
			if (AdressDao.insertAdress(conn, restaurant.getAdress())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertRestaurant(restaurant)) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (PixDao.insertPix(conn, restaurant.getPixList()
					, restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (PackagingDao.insertPack(conn, restaurant.getPackList()
					, restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (PayDao.insertPay(conn, restaurant.getPayList()
					, restaurant.getCnpjNumber())) {
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
	
	private boolean insertRestaurant(Restaurant restaurant) {
		try {
			
			PreparedStatement restaurantInsert = conn.getConnection().prepareStatement("INSERT INTO "
					+ "T_CADASTRO VALUES (?, (SELECT MAX(cd_endereco FROM T_ENDERECO)), "
					+ "?, ?, ?, ?, ?, ?, ?, ?)");
			
			restaurantInsert.setInt(1, restaurant.getCnpjNumber());
			restaurantInsert.setInt(2, getPlainId(restaurant.getPlain()));
			restaurantInsert.setInt(3, getCategoryId(restaurant.getCategory()));
			restaurantInsert.setString(4, restaurant.getName());
			restaurantInsert.setInt(5, restaurant.getNumber());
			restaurantInsert.setBoolean(6, restaurant.isScheduledDelivery());
			restaurantInsert.setString(7, restaurant.getEmailAdress());
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
	
	private int getPlainId(String plainName) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_plano "
					+ "FROM T_PLANO WHERER = ?");
			
			getId.setString(1, plainName);
						
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
	
	private int getCategoryId(String categoryName) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_categoria "
					+ "FROM T_CATEGORIA WHERER nm_categoria = ?");
			
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
}