package br.com.ifoodeco.entity;

public class Packaging {
	
	private String packagingName;
	
	public Packaging(String packagingName) {
		super();
		this.packagingName = packagingName;
	}

	public String getPackagingName() {
		return packagingName;
	}

	public void setPackagingName(String packagingName) {
		this.packagingName = packagingName;
	}
}