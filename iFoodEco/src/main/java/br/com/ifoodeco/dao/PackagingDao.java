package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifoodeco.entity.Packaging;

public class PackagingDao {

	public static List<Packaging> getAll(ConnectionManager conn, int cnpjNumber){
		List<Packaging> packList = new ArrayList<Packaging>();
		
		try {
			PreparedStatement getPack = conn.getConnection().prepareStatement("SELECT nm_emb "
					+ "FROM T_USO_EMBALAGEM UE INNER JOIN T_EMBALAGEM E "
					+ "WHERER UE.cd_emb = E.cd_emb AND nr_cnpj = ?");
			
			getPack.setInt(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPack);
			
			while (result.next()) {
				packList.add(new Packaging(result.getString(1)));
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return packList;
	}
	
	//Get All pack methods to show on JSP
	public List<Packaging> getAll(){
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
		
		return packList;
	} 
	
	public static boolean insertPack(ConnectionManager conn, List<Packaging> packList, int cnpjNumber) {
		try {
			for (Packaging pack : packList) {
				
				PreparedStatement packInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_USO_EMBALAGEM VALUES (EMBALAGEM.Nextval, ?, ?)");
				
				packInsert.setInt(1, cnpjNumber);
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
}