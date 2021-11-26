package velo.q.structure;

public class Source {
	public String name;
	public DataPoint[] data;
	public static String corePath;
	public Source() {
		
	}
	public Source(String name, DataPoint[] data, String path) {
		super();
		this.name = name;
		this.data = data;
		corePath = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DataPoint[] getData() {
		return data;
	}
	public void setData(DataPoint[] data) {
		this.data = data;
	}
	public static String getCorePath() {
		return corePath;
	}
	public static void setCorePath(String corePath) {
		Source.corePath = corePath;
	}
	
}
