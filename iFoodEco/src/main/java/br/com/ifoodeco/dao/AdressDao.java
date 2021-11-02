package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.ifoodeco.entity.Adress;

public class AdressDao {

	public static Adress getAdress(ConnectionManager conn, int cnpjNumber){
		try {
			PreparedStatement getAdress = conn.getConnection().prepareStatement("SELECT logradouro, "
					+ "cep, nr_logradouro, complemento FROM T_ENDERECO E INNER JOIN T_CADASTRO C "
					+ "WHERER E.cd_endereco = C.cd_endereco AND nr_cnpj = ?");
			
			getAdress.setInt(1, cnpjNumber);
						
			ResultSet result = conn.getData(getAdress);
			
			if (result.next()) {
				return new Adress(result.getString(1), result.getInt(2), result.getInt(3)
						, result.getString(4));
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
}