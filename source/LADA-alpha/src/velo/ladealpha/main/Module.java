package velo.ladealpha.main;

public class Module {
	private String name;
	private Module[] sub;
	private String[] methods;
	private IMod cls;
	private Boolean isfinal = false;
	
	
	public String[] getMethods() {
		return methods;
	}

	public void setMethods(String[] methods) {
		this.methods = methods;
	}

	public IMod getCls() {
		return cls;
	}

	public void setCls(IMod cls) {
		this.cls = cls;
	}

	public Boolean getIsfinal() {
		return isfinal;
	}

	public void setIsfinal(Boolean isfinal) {
		this.isfinal = isfinal;
	}

	public Module fin() {
		this.isfinal = true;
		return this;
	}
	
	public Module(String name, String[] methods, IMod cls) {
		this.name = name;
		this.methods = methods;
		this.cls = cls;
		this.isfinal = true;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Module[] getSub() {
		return sub;
	}

	public void setSub(Module[] sub) {
		this.sub = sub;
	}

	public Module(String name) {
		super();
		this.name = name;
	}

	public Module(String name, Module[] sub) {
		super();
		this.name = name;
		this.sub = sub;
	}
	
}
