package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifoodeco.entity.Packaging;

public class PackagingDao {

	public static List<Packaging> getAll(ConnectionManager conn, long cnpjNumber){
		List<Packaging> packList = new ArrayList<Packaging>();
		
		try {
			PreparedStatement getPack = conn.getConnection().prepareStatement("SELECT nm_emb, "
					+ "cd_relacao FROM T_USO_EMBALAGEM UE, T_EMBALAGEM E "
					+ "WHERE UE.cd_emb = E.cd_emb AND nr_cnpj = ?");
			
			getPack.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPack);
			
			while (result.next()) {
				Packaging pack = new Packaging(result.getString(1));
				pack.setId(result.getInt(2));
				
				packList.add(pack);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return packList;
	}
	
	public static List<Packaging> getAll(long cnpjNumber){
		ConnectionManager conn = new ConnectionManager();
		
		List<Packaging> packList = new ArrayList<Packaging>();
		
		try {
			PreparedStatement getPack = conn.getConnection().prepareStatement("SELECT nm_emb, "
					+ "cd_relacao FROM T_USO_EMBALAGEM UE, T_EMBALAGEM E "
					+ "WHERE UE.cd_emb = E.cd_emb AND nr_cnpj = ?");
			
			getPack.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPack);
			
			while (result.next()) {
				Packaging pack = new Packaging(result.getString(1));
				pack.setId(result.getInt(2));
				
				packList.add(pack);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return packList;
	}
	
	//Get All pack methods to show on JSP
	public static List<Packaging> getAll(){
		ConnectionManager conn = new ConnectionManager();
		
		List<Packaging> packList = new ArrayList<Packaging>();
		
		try {
			PreparedStatement getPack = conn.getConnection().prepareStatement("SELECT nm_emb "
					+ "FROM T_EMBALAGEM");
								
			ResultSet result = conn.getData(getPack);
			
			while (result.next()) {
				packList.add(new Packaging(result.getString(1)));
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return packList;
	} 
	
	public static boolean insertPack(ConnectionManager conn, List<Packaging> packList, long cnpjNumber) {
		try {
			for (Packaging pack : packList) {
				
				PreparedStatement packInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_USO_EMBALAGEM VALUES (EMBALAGEM.Nextval, ?, ?)");
				
				packInsert.setLong(1, cnpjNumber);
				packInsert.setInt(2, getPackId(conn, pack.getPackagingName()));

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
	
	private static int getPackId(ConnectionManager conn, String packKey) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_emb "
					+ "FROM T_EMBALAGEM WHERE nm_emb = ?");
			
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
	
	public static boolean updatePack(Packaging pack) {
		ConnectionManager conn = new ConnectionManager();
		
		try {			
			PreparedStatement packUpdate = conn.getConnection().prepareStatement("UPDATE T_USO_EMBALAGEM "
						+ "SET CD_EMB = ?"
						+ "WHERE CD_EMB = ?");
				
			packUpdate.setInt(1, getPackId(conn, pack.getPackagingName()));
			packUpdate.setInt(2, pack.getId());

			if (conn.executeCommand(packUpdate, false) == 1) {
				conn.getConnection().commit();
				
				return true;
			}
			else
			{
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
	
	public static boolean deletePack(Packaging pack) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement packDelete = conn.getConnection().prepareStatement("DELETE FROM T_USO_EMBALAGEM"
					+ "WHERE CD_RELACAO = ?");
				
			packDelete.setInt(1, pack.getId());
			
			conn.executeCommand(packDelete, true);
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			conn.closeConnection();
		}
	} 
}