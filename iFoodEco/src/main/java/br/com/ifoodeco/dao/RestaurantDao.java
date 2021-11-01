package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	private int getPixKeyId(String pixKey) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT chave_pix "
					+ "FROM T_PIX WHERER nm_chave = ?");
			
			getId.setString(1, pixKey);
						
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
	
	private int getPackId(String packKey) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_emb "
					+ "FROM T_EMBALAGEM WHERER nm_emb = ?");
			
			getId.setString(1, packKey);
						
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
	
	private String getPaymentKey(String payKey) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_pag "
					+ "FROM T_FORMA_PAG WHERER descricao = ?");
			
			getId.setString(1, payKey);
						
			ResultSet result = conn.getData(getId);
			
			if (result.next()) {
				return result.getString(1);
			}
			
			return null;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return null;
		}
	}
}