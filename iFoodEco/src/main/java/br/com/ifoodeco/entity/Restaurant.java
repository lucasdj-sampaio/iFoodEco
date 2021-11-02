package br.com.ifoodeco.entity;
import java.util.List;

public class Restaurant {
	
	private int cnpjNumber;
	private Adress adress;
	private String name;
	private int number;
	private boolean scheduledDelivery;
	private String emailAdress;
	private int agencyNumber;
	private int accountNumber;
	private String plain;
	private String category;
	private List<Pix> pixList;
	private List<Packaging> packList;
	private List<PayMethod> payList;
	
	public int getCnpjNumber() {
		return cnpjNumber;
	}
	
	public void setCnpjNumber(int cnpjNumber) {
		this.cnpjNumber = cnpjNumber;
	}
	
	public Adress getAdress() {
		return adress;
	}
	
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isScheduledDelivery() {
		return scheduledDelivery;
	}
	
	public void setScheduledDelivery(boolean scheduledDelivery) {
		this.scheduledDelivery = scheduledDelivery;
	}
	
	public String getEmailAdress() {
		return emailAdress;
	}
	
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	public int getAgencyNumber() {
		return agencyNumber;
	}
	
	public void setAgencyNumber(int agencyNumber) {
		this.agencyNumber = agencyNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public List<Pix> getPixList() {
		return pixList;
	}
	
	public void setPixList(List<Pix> pixList) {
		this.pixList = pixList;
	}
	
	public List<Packaging> getPackList() {
		return packList;
	}
	
	public void setPackList(List<Packaging> packList) {
		this.packList = packList;
	}
	
	public List<PayMethod> getPayList() {
		return payList;
	}
	
	public void setPayList(List<PayMethod> payList) {
		this.payList = payList;
	}

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}