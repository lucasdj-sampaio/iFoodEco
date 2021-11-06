import java.util.ArrayList;
import java.util.List;
import br.com.ifoodeco.dao.AddressDao;
import br.com.ifoodeco.dao.PackagingDao;
import br.com.ifoodeco.dao.PayDao;
import br.com.ifoodeco.dao.PixDao;
import br.com.ifoodeco.dao.RestaurantDao;
import br.com.ifoodeco.entity.Address;
import br.com.ifoodeco.entity.Packaging;
import br.com.ifoodeco.entity.PayMethod;
import br.com.ifoodeco.entity.Pix;
import br.com.ifoodeco.entity.Restaurant;

public class SolutionTest {
	private static Restaurant restaurant = new Restaurant();
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		creatR();
		//rDao.insertRestaurantDao(restaurant);
		
		//restaurant.setScheduledDelivery(true);
		
		restaurant = RestaurantDao.getRestaurant(19057483018493L);
		//restaurant.setNumber(1143294820L);
		
		//rDao.updateRestaurant(restaurant);
		
		//List<Packaging> packList = PackagingDao.getAll(restaurant.getCnpjNumber());
		//packList.get(1).setPackagingName("emb_vidro");
		
		//PackagingDao.updatePack(packList.get(1));
		
		//List<Pix> pixList = PixDao.getAll(restaurant.getCnpjNumber());
		//pixList.get(0).setKeyName("cnpj_cpf");
		//pixList.get(0).setValue(Long.toString(restaurant.getCnpjNumber()));
	
		//PixDao.updatePix(pixList.get(0));
		
		//List<PayMethod> payList = PayDao.getAll(restaurant.getCnpjNumber());
		//payList.get(0).setPayMethod("MASTERCARD");
			
		//PayDao.updatePay(payList.get(0));
		
		Address addr = AddressDao.getAddress(restaurant.getCnpjNumber());
		addr.setComplement("NUMXEI");
		
		AddressDao.updateAddress(addr);	
	}
	
	private static Restaurant creatR() {
		List<Pix> pixList = new ArrayList<Pix>();
		
		pixList.add(new Pix("email", "acaiterra@yahoo.com.br"));
		pixList.add(new Pix("celular", "21400289229"));
		
		List<Packaging> packList = new ArrayList<Packaging>();
		
		packList.add(new Packaging("emb_isopor"));
		packList.add(new Packaging("emb_plastico"));
		
		List<PayMethod> payList = new ArrayList<PayMethod>();
		
		payList.add(new PayMethod("DINHEIRO"));
		
		Address address = new Address(
				"Rua Paulinia"
				, 07143300
				, 58
				, "");
				
	    restaurant.setCnpjNumber(19057483018493L);
	    restaurant.setAddress(address);
	    restaurant.setName("Açaí da boa terra");
	    restaurant.setNumber(21400289229L);
	    restaurant.setEmailAddress("acaiterra@yahoo.com.br");
	    restaurant.setAgencyNumber(9422);
	    restaurant.setAccountNumber(402257);
	    restaurant.setScheduledDelivery(false);
	    restaurant.setPlan("entrega");
	    restaurant.setCategory("Açaí");
	    restaurant.setPixList(pixList);
	    restaurant.setPackList(packList);
	    restaurant.setPayList(payList);
	    
	    return restaurant;
	}
}