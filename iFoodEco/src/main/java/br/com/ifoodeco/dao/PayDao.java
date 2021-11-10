package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.entity.PayMethod;

public class PayDao {

	public static List<PayMethod> getAll(ConnectionManager conn, long cnpjNumber){
		List<PayMethod> payList = new ArrayList<PayMethod>();
		
		try {
			PreparedStatement getPayment = conn.getConnection().prepareStatement("SELECT PR.cd_pag "
					+ ", cd_relacao FROM T_PAG_RESTAURANTE PR, T_FORMA_PAG FP "
					+ "WHERE PR.cd_pag = FP.cd_pag AND nr_cnpj = ?");
			
			getPayment.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPayment);
			
			while (result.next()) {
				PayMethod pay = new PayMethod(result.getString(1));
				pay.setId(result.getInt(2));
				
				payList.add(pay);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return payList;
	}
	
	public static List<PayMethod> getAll(long cnpjNumber){
		ConnectionManager conn = new ConnectionManager();
		
		List<PayMethod> payList = new ArrayList<PayMethod>();
		
		try {
			PreparedStatement getPayment = conn.getConnection().prepareStatement("SELECT cd_pag "
					+ ", cd_relacao FROM T_PAG_RESTAURANTE PR, T_FORMA_PAG FP "
					+ "WHERE PR.cd_pag = FP.cd_pag AND nr_cnpj = ?");
			
			getPayment.setLong(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPayment);
			
			while (result.next()) {
				PayMethod pay = new PayMethod(result.getString(1));
				pay.setId(result.getInt(2));
				
				payList.add(pay);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return payList;
	}
	
	//Get All pay methods to show on JSP
	public static List<PayMethod> getAll(){
		ConnectionManager conn = new ConnectionManager();
		
		List<PayMethod> payList = new ArrayList<PayMethod>();
		
		try {
			PreparedStatement getPayment = conn.getConnection().prepareStatement("SELECT CD_PAG, DESCRICAO "
					+ "FROM T_FORMA_PAG");
						
			ResultSet result = conn.getData(getPayment);
			
			while (result.next()) {
				PayMethod pay = new PayMethod(result.getString(1));
				pay.setId(result.getInt(2));
				
				payList.add(pay);
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		finally {
			conn.closeConnection();
		}
		
		return payList;
	}
	
	public static boolean insertPay(ConnectionManager conn, List<PayMethod> paymentList
			, long cnpjNumber) {
		try {
			for (PayMethod payment : paymentList) {
				
				PreparedStatement payInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_PAG_RESTAURANTE (CD_RELACAO, NR_CNPJ, CD_PAG) VALUES (PAG.Nextval, ?, ?)");
				
				payInsert.setLong(1, cnpjNumber);
				payInsert.setInt(2, getPayId(conn, payment.getPayMethod()));
				
				conn.executeCommand(payInsert, false);
			}
			
			return true;
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public static int getPayId(ConnectionManager conn, String payName) {
		try {
			
			PreparedStatement getId = conn.getConnection().prepareStatement("SELECT cd_pag "
					+ "FROM T_FORMA_PAG WHERE descricao = ?");
			
			getId.setString(1, payName);
						
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
	
	public static boolean updatePay(PayMethod pay) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement payUpdate = conn.getConnection().prepareStatement("UPDATE T_PAG_RESTAURANTE "
						+ "SET CD_PAG = ? WHERE CD_RELACAO = ?");
				
			payUpdate.setString(1, pay.getPayMethod());
			payUpdate.setInt(2, pay.getId());
				
			if (conn.executeCommand(payUpdate, false) <= 1) {
				conn.getConnection().commit();
				
				return true;
			}
			else{
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
	
	public static boolean deletePay(PayMethod pay) {
		ConnectionManager conn = new ConnectionManager();
		
		try {
			PreparedStatement packDelete = conn.getConnection().prepareStatement("DELETE FROM T_PAG_RESTAURANTE"
					+ "WHERE CD_RELACAO = ?");
				
			packDelete.setInt(1, pay.getId());

			conn.executeCommand(packDelete, true);
			
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