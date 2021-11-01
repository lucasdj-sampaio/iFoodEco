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
			
			if (!insertPix(restaurant.getPixList(), restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertPack(restaurant.getPackList(), restaurant.getCnpjNumber())) {
				conn.getConnection().rollback();
				return false;
			}
			
			if (!insertPay(restaurant.getPayList(), restaurant.getCnpjNumber())) {
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
	
	private boolean insertAdress(Adress adress) {
		try {
			PreparedStatement adressInsert = conn.getConnection().prepareStatement("INSERT INTO "
					+ "T_ENDERECO VALUES (ENDERECO.Nextval, ?, ?, ?, ?)");
			
			adressInsert.setString(1, adress.getStreet());
			adressInsert.setInt(1, adress.getCep());
			adressInsert.setInt(1, adress.getNumber());
			adressInsert.setString(1, adress.getComplement());
			
			if (conn.executeCommand(adressInsert, false) != 0) {
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
	
	private boolean insertRestaurant(Restaurant restaurant) {
		try {
			
			PreparedStatement restaurantInsert = conn.getConnection().prepareStatement("INSERT INTO "
					+ "T_CADASTRO VALUES (?, (SELECT MAX(cd_endereco FROM T_ENDERECO)), "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			restaurantInsert.setInt(1, restaurant.getCnpjNumber());
			restaurantInsert.setInt(2, getPlainId(restaurant.getPlain()));
			restaurantInsert.setInt(3, getCategoryId(restaurant.getCategory()));
			restaurantInsert.setString(4, restaurant.getName());
			restaurantInsert.setInt(5, restaurant.getNumber());
			restaurantInsert.setBoolean(6, restaurant.isScheduledDelivery());
			restaurantInsert.setString(7, restaurant.getEmailAdress());
			restaurantInsert.setInt(8, restaurant.getAgencyNumber());
			restaurantInsert.setInt(9, restaurant.getAccountNumber());
			restaurantInsert.setBoolean(10, restaurant.isOilDiscart());
						
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
	
	private boolean insertPix(List<Pix> pixList, int cnpjNumber) {
		try {
			for (Pix pix : pixList) {
				
				PreparedStatement pixInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_PIX_RESTAURANTE VALUES (PIX.Nextval, ?, ?, ?)");
				
				pixInsert.setInt(1, cnpjNumber);
				pixInsert.setInt(2, getPixKeyId(pix.getKeyName()));
				pixInsert.setString(3, pix.getValue());

				conn.executeCommand(pixInsert, false);
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
	} 
	
	private boolean insertPack(List<Packaging> packList, int cnpjNumber) {
		try {
			for (Packaging pack : packList) {
				
				PreparedStatement packInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_USO_EMBALAGEM VALUES (EMBALAGEM.Nextval, ?, ?)");
				
				packInsert.setInt(1, cnpjNumber);
				packInsert.setInt(2, getPackId(pack.getPackagingName()));

				conn.executeCommand(packInsert, false);
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
	} 
	
	private boolean insertPay(List<PayMethod> paymentList, int cnpjNumber) {
		try {
			for (PayMethod payment : paymentList) {
				
				PreparedStatement packInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_PAG_RESTAURANTE VALUES (PAG.Nextval, ?, ?)");
				
				packInsert.setString(1, getPaymentKey(payment.getPayMethod()));
				packInsert.setInt(2, cnpjNumber);

				conn.executeCommand(packInsert, false);
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	private int getPlainId(String plainName) {
		
	}
	
	private int getCategoryId(String categoryName) {
		
	}
	
	private int getPixKeyId(String pixKey) {
		
	}
	
	private int getPackId(String packKey) {
		
	}
	
	private String getPaymentKey(String packKey) {
		
	}
}