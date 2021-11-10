package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.entity.Plan;

public class PlanDao {

	//Get All pack methods to show on JSP
	public static List<Plan> getAll(){
		ConnectionManager conn = new ConnectionManager();
		
		List<Plan> planList = new ArrayList<Plan>();
		
		try {
			PreparedStatement getPlan = conn.getConnection().prepareStatement("SELECT cd_plano, nm_plano "
					+ "FROM T_PLANO");
								
			ResultSet result = conn.getData(getPlan);
			
			while (result.next()) {
				Plan plan = new Plan();
		    	plan.setId(result.getInt(1));
		    	plan.setPlan(result.getString(2));
		    	
				planList.add(plan);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return planList;
	} 
	
	public static int getPlanId(ConnectionManager conn, String planName) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_plano "
					+ "FROM T_PLANO WHERE nm_plano = ?");
			
			getId.setString(1, planName);
						
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