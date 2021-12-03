package lada.shell.velo.main;

public class Function {
	private String name, descrition;
	private String[] params;
	private boolean desc = false;
	
	
	
	public Function(String name, String[] params) {
		super();
		this.name = name;
		this.params = params;
	}
	public Function(String name, String[] params, String description) {
		super();
		this.name = name;
		this.params = params;
		this.desc = true;
		this.descrition = description;
	}

	public Object stringify(Object o) {
		return o;
	}

	public Object evaluate(Object[] params) {
		return null;
	}



	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public boolean isDesc() {
		return desc;
	}
	public void setDesc(boolean desc) {
		this.desc = desc;
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
