package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.entity.Category;

public class CategoryDao {

	//Get All pack methods to show on JSP
	public static List<Category> getAll(){
		ConnectionManager conn = new ConnectionManager();
		
		List<Category> categoryList = new ArrayList<Category>();
		
		try {
			PreparedStatement getCat = conn.getConnection().prepareStatement("SELECT cd_categoria, nm_categoria "
					+ "FROM T_CATEGORIA");
								
			ResultSet result = conn.getData(getCat);
			
			while (result.next()) {
				Category category = new Category();
				category.setId(result.getInt(1));
				category.setCategory(result.getString(2));
				
				categoryList.add(category);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return categoryList;
	} 
	
	public static int getCategoryId(ConnectionManager conn, String categoryName) {
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
}