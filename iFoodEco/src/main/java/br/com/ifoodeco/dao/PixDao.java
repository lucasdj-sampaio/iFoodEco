package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.entity.Pix;

public class PixDao {
	
	public static List<Pix> getAll(ConnectionManager conn, int cnpjNumber){
		List<Pix> pixList = new ArrayList<Pix>();
		
		try {
			PreparedStatement getPix = conn.getConnection().prepareStatement("SELECT nm_chave, vlr_chave, "
					+ "cd_relacao FROM T_PIX_RESTAURANTE R INNER JOIN T_PIX P "
					+ "WHERER P.chave_pix = R.chave_pix AND nr_cnpj = ?");
			
			getPix.setInt(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPix);
			
			while (result.next()) {
				Pix pix = new Pix(result.getString(1)
						, result.getString(2));
				
				pix.setId(result.getInt(3));
				
				pixList.add(pix);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return pixList;
	}
	
	public List<Pix> getAll(){
		ConnectionManager conn = new ConnectionManager();
		
		List<Pix> pixList = new ArrayList<Pix>();
		
		try {
			PreparedStatement getPix = conn.getConnection().prepareStatement("SELECT nm_chave, vlr_chave "
					+ "FROM T_PIX");
						
			ResultSet result = conn.getData(getPix);
			
			while (result.next()) {
				pixList.add(new Pix(result.getString(1)
						, result.getString(2)));
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return pixList;
	}
	
	public static boolean insertPix(ConnectionManager conn, List<Pix> pixList, int cnpjNumber) {
		try {
			for (Pix pix : pixList) {
				
				PreparedStatement pixInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_PIX_RESTAURANTE VALUES (PIX.Nextval, ?, ?, ?)");
				
				pixInsert.setInt(1, cnpjNumber);
				pixInsert.setInt(2, getPixKeyId(conn, pix.getKeyName()));
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
	
	private static int getPixKeyId(ConnectionManager conn, String pixKey) {
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
	
	public boolean updatePix(Pix pix) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement pixUpdate = conn.getConnection().prepareStatement("UPDATE T_PIX_RESTAURANTE "
						+ "SET VLR_CHAVE = ?, CHAVE_PIX = ?)"
						+ "WHERE CD_RELACAO = ?");
				
			pixUpdate.setString(1, pix.getValue());
			pixUpdate.setString(2, pix.getKeyName());
			pixUpdate.setInt(3, pix.getId());
				
			pixUpdate.executeUpdate();

			if(conn.executeCommand(pixUpdate, false) == 1) {
				
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
	
	public boolean deletePix(Pix pix) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement pixDelete = conn.getConnection().prepareStatement("DELETE FROM T_PIX_RESTAURANTE"
				+ "WHERE CD_RELACAO = ?");
		
			pixDelete.setInt(1, pix.getId());

			conn.executeCommand(pixDelete, true);
						
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