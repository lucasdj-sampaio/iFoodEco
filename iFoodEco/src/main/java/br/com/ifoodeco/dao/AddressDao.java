package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.ifoodeco.entity.Address;

public class AddressDao {

	public static Address getAddress(long cnpjNumber){
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement getAddress = conn.getConnection().prepareStatement("SELECT logradouro, "
					+ "cep, nr_logradouro, complemento, E.cd_endereco FROM T_ENDERECO E, T_CADASTRO C "
					+ "WHERE E.cd_endereco = C.cd_endereco AND nr_cnpj = ?");
			
			getAddress.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getAddress);
			
			if (result.next()) {
				 Address address = new Address(result.getString(1), result.getInt(2), result.getInt(3)
						, result.getString(4));
				 address.setId(result.getInt(5));
				 
				 return address;
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return null;
	}
	
	public static Address getAddress(ConnectionManager conn, long cnpjNumber){
		try {
			PreparedStatement getAddress = conn.getConnection().prepareStatement("SELECT logradouro, "
					+ "cep, nr_logradouro, complemento, E.cd_endereco FROM T_ENDERECO E, T_CADASTRO C "
					+ "WHERE E.cd_endereco = C.cd_endereco AND nr_cnpj = ?");
			
			getAddress.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getAddress);
			
			if (result.next()) {
				 Address address = new Address(result.getString(1), result.getInt(2), result.getInt(3)
						, result.getString(4));
				 address.setId(result.getInt(5));
				 
				 return address;
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean insertAddress(ConnectionManager conn, Address address) {
		try {
			PreparedStatement addressInsert = conn.getConnection().prepareStatement("INSERT INTO "
					+ "T_ENDERECO VALUES (ENDERECO.Nextval, ?, ?, ?, ?)");
			
			addressInsert.setString(1, address.getStreet());
			addressInsert.setInt(2, address.getCep());
			addressInsert.setInt(3, address.getNumber());
			addressInsert.setString(4, address.getComplement());
			
			if (conn.executeCommand(addressInsert, false) != 0) {
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
		
	public static boolean updateAddress(Address address) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement addressUpdate = conn.getConnection().prepareStatement("UPDATE T_ENDERECO "
					+ "SET LOGRADOURO = ?, CEP = ?, NR_LOGRADOURO = ?, COMPLEMENTO = ?  "
					+ "WHERE CD_ENDERECO = ?");
			
			  addressUpdate.setString(1, address.getStreet());
			  addressUpdate.setInt(2, address.getCep());
			  addressUpdate.setInt(3, address.getNumber());
			  addressUpdate.setString(4, address.getComplement());
			  addressUpdate.setInt(5, address.getId());
			  
			if (conn.executeCommand(addressUpdate, false) <= 1) {
				conn.getConnection().commit();
				return true;
			}
			else {
				conn.getConnection().rollback();
				return false;
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
}