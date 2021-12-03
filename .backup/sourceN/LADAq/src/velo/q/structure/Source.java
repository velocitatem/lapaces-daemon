package velo.q.structure;

// TODO: Auto-generated Javadoc
/**
 * The Class Source.
 */
public class Source {
	
	/** The name. */
	public String name;
	
	/** The data. */
	public DataPoint[] data;
	
	/** The core path. */
	public static String corePath;
	
	/**
	 * Instantiates a new source.
	 */
	public Source() {
		
	}
	
	/**
	 * Instantiates a new source.
	 *
	 * @param name the name
	 * @param data the data
	 * @param path the path
	 */
	public Source(String name, DataPoint[] data, String path) {
		super();
		this.name = name;
		this.data = data;
		corePath = path;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public DataPoint[] getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(DataPoint[] data) {
		this.data = data;
	}
	
	/**
	 * Gets the core path.
	 *
	 * @return the core path
	 */
	public static String getCorePath() {
		return corePath;
	}
	
	/**
	 * Sets the core path.
	 *
	 * @param corePath the new core path
	 */
	public static void setCorePath(String corePath) {
		Source.corePath = corePath;
	}
	
}
