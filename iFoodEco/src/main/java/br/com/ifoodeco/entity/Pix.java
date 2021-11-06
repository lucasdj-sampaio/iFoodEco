package br.com.ifoodeco.entity;

public class Pix {
	
	private int id;
	private String keyName;
	private String value;
	
	public Pix(String aKey, String aValue) {
		this.keyName = aKey;
		this.value = aValue;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}