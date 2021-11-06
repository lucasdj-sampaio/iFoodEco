package br.com.ifoodeco.entity;

public class Address {

	private int Id;
	private String street;
	private int cep;
	private int number;
	private String complement;
	
	public Address(String aStreet, int aCep, int aNumber, String aComplement) {
		this.street = aStreet;
		this.cep = aCep;
		this.number = aNumber;
		this.complement = aComplement;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id){
		this.Id = id;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}