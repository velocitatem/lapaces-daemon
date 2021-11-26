package velo.q.structure;

public class DataPoint {
	String name;
	String[] queryParams;
	public Object fetch(Object[] p) {
		return null;
	}
	public String stringify(Object o) {
		return (String)o;
	}
	public DataPoint(String name, String[] queryParams) {
		super();
		this.name = name;
		this.queryParams = queryParams;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(String[] queryParams) {
		this.queryParams = queryParams;
	}
	
}
