package br.com.ifoodeco.entity;

public class PayMethod {
	
	private int Id;
	private String payMethod;

	public PayMethod(String payMethod) {
		super();
		this.payMethod = payMethod;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id){
		this.Id = id;
	}
		
	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
}