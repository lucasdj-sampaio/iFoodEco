package br.com.ifoodeco.entity;
import java.util.List;

public class Restaurant {
	
	private long cnpjNumber;
	private Address address;
	private String name;
	private long number;
	private boolean scheduledDelivery;
	private String emailAddress;
	private int agencyNumber;
	private int accountNumber;
	private String plan;
	private String category;
	private List<Pix> pixList;
	private List<Packaging> packList;
	private List<PayMethod> payList;
	
	public long getCnpjNumber() {
		return cnpjNumber;
	}
	
	public void setCnpjNumber(long cnpjNumber) {
		this.cnpjNumber = cnpjNumber;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
	public boolean isScheduledDelivery() {
		return scheduledDelivery;
	}
	
	public void setScheduledDelivery(boolean scheduledDelivery) {
		this.scheduledDelivery = scheduledDelivery;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}