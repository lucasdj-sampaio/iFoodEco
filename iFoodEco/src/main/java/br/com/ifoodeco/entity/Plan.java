package br.com.ifoodeco.entity;

public class Plan {
	
	private int id;
	private String plan;

	public Plan(String plan, int id) {
		super();
		this.plan = plan;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
		
	public String getPlan() {
		return plan;
	}
}