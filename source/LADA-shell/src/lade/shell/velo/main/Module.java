package lade.shell.velo.main;

public class Module {
	private String name;
	private Module[] subs;
	private boolean last = false;
	public Module(String name, Module[] subs) {
		super();
		this.name = name;
		this.subs = subs;
	}
	private Function[] functions;
	public Module(String name, Function[] functions) {
		super();
		this.name = name;
		this.functions = functions;
		this.last = true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Module[] getSubs() {
		return subs;
	}
	public void setSubs(Module[] subs) {
		this.subs = subs;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public Function[] getFunctions() {
		return functions;
	}
	public void setFunctions(Function[] functions) {
		this.functions = functions;
	}
	
	
}
