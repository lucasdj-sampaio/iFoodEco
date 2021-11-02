package br.com.ifoodeco.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.entity.PayMethod;

public class PayDao {

	public static List<PayMethod> getAll(ConnectionManager conn, int cnpjNumber){
		List<PayMethod> payList = new ArrayList<PayMethod>();
		
		try {
			PreparedStatement getPayment = conn.getConnection().prepareStatement("SELECT descricao "
					+ "FROM T_PAG_RESTAURANTE PR INNER JOIN T_FORMA_PAG FP "
					+ "WHERER PR.cd_pag = FP.cd_pag AND nr_cnpj = ?");
			
			getPayment.setInt(1, cnpjNumber);
						
			ResultSet result = conn.getData(getPayment);
			
			while (result.next()) {
				payList.add(new PayMethod(result.getString(1)));
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return payList;
	}
	
	//Get All pay methods to show on JSP
	public List<PayMethod> getAll(){
		ConnectionManager conn = new ConnectionManager();
		
		List<PayMethod> payList = new ArrayList<PayMethod>();
		
		try {
			PreparedStatement getPayment = conn.getConnection().prepareStatement("SELECT descricao "
					+ "FROM T_FORMA_PAG");
						
			ResultSet result = conn.getData(getPayment);
			
			while (result.next()) {
				payList.add(new PayMethod(result.getString(1)));
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return payList;
	}
	
	public static boolean insertPay(ConnectionManager conn, List<PayMethod> paymentList
			, int cnpjNumber) {
		try {
			for (PayMethod payment : paymentList) {
				
				PreparedStatement payInsert = conn.getConnection().prepareStatement("INSERT INTO "
						+ "T_PAG_RESTAURANTE VALUES (PAG.Nextval, ?, ?)");
				
				payInsert.setString(1, getPaymentKey(conn, payment.getPayMethod()));
				payInsert.setInt(2, cnpjNumber);

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
	
	private static String getPaymentKey(ConnectionManager conn, String payKey) {
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