package br.com.ifoodeco.entity;

public class Packaging {
	
	private int id; 
	private String packagingName;
	
	public Packaging(String packagingName) {
		super();
		this.packagingName = packagingName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getPackagingName() {
		return packagingName;
	}

	public void setPackagingName(String packagingName) {
		this.packagingName = packagingName;
	}
}