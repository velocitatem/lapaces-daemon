package lade.shell.velo.main;

public class Function {
	private String name;
	private String[] params;
	
	
	
	public Function(String name, String[] params) {
		super();
		this.name = name;
		this.params = params;
	}

	public Object stringify(Object o) {
		return o;
	}

	public Object evaluate(Object[] params) {
		return null;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String[] getParams() {
		return params;
	}



	public void setParams(String[] params) {
		this.params = params;
	}
	
	
}
