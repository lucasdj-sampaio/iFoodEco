package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.ifoodeco.entity.Adress;

public class AdressDao {

	public static Adress getAdress(ConnectionManager conn, int cnpjNumber){
		try {
			PreparedStatement getAdress = conn.getConnection().prepareStatement("SELECT logradouro, "
					+ "cep, nr_logradouro, complemento, cd_endereco FROM T_ENDERECO E INNER JOIN T_CADASTRO C "
					+ "WHERER E.cd_endereco = C.cd_endereco AND nr_cnpj = ?");
			
			getAdress.setInt(1, cnpjNumber);
						
			ResultSet result = conn.getData(getAdress);
			
			if (result.next()) {
				 Adress adress = new Adress(result.getString(1), result.getInt(2), result.getInt(3)
						, result.getString(4));
				 adress.setId(result.getInt(5));
				 
				 return adress;
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean insertAdress(ConnectionManager conn, Adress adress) {
		try {
			PreparedStatement adressInsert = conn.getConnection().prepareStatement("INSERT INTO "
					+ "T_ENDERECO VALUES (ENDERECO.Nextval, ?, ?, ?, ?)");
			
			adressInsert.setString(1, adress.getStreet());
			adressInsert.setInt(2, adress.getCep());
			adressInsert.setInt(3, adress.getNumber());
			adressInsert.setString(4, adress.getComplement());
			
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
	
	public boolean updateAdress(Adress adress) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement adressUpdate = conn.getConnection().prepareStatement("UPDATE T_ENDERECO "
					+ "SET LOGRADOURO = ?, CEP = ?, NR_LOGRADOURO = ?, COMPLEMENTO = ?  "
					+ "WHERE CD_ENDERECO = ?");
			
			  adressUpdate.setString(1, adress.getStreet());
			  adressUpdate.setInt(2, adress.getCep());
			  adressUpdate.setInt(3, adress.getNumber());
			  adressUpdate.setString(4, adress.getComplement());
			  adressUpdate.setInt(5, adress.getId());
			  
			  adressUpdate.executeUpdate();

			if (conn.executeCommand(adressUpdate, false) == 1) {
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