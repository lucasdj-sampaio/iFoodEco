package br.com.ifoodeco.entity;

public class PayMethod {
	
	private int id;
	private String payMethod;

	public PayMethod(String payMethod) {
		super();
		this.payMethod = payMethod;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
		
	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
}