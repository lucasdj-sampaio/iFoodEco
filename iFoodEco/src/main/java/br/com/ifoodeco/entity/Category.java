package br.com.ifoodeco.entity;

public class Category {
	
	private int id;
	private String category;

	public Category(String category, int id) {
		super();
		this.category = category;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
		
	public String getCategory() {
		return category;
	}
}