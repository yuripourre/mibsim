package br.com.mibsim.model;


public abstract class Concept {

	private String name = "thing";
	
	public Concept() {
		super();
	}
	
	public Concept(String name) {
		super();
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
