package br.com.ifoodeco.entity;

public class Packaging {
	
	private int Id; 
	private String packagingName;
	
	public Packaging(String packagingName) {
		super();
		this.packagingName = packagingName;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id){
		this.Id = id;
	}
	
	public String getPackagingName() {
		return packagingName;
	}

	public void setPackagingName(String packagingName) {
		this.packagingName = packagingName;
	}
}