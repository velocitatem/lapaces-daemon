package velo.ladealpha.main;

// TODO: Auto-generated Javadoc
/**
 * The Class Module.
 */
public class Module {
	
	/** The name. */
	private String name;
	
	/** The sub. */
	private Module[] sub;
	
	/** The methods. */
	private String[] methods;
	
	/** The cls. */
	private IMod cls;
	
	/** The isfinal. */
	private Boolean isfinal = false;
	
	
	/**
	 * Gets the methods.
	 *
	 * @return the methods
	 */
	public String[] getMethods() {
		return methods;
	}

	/**
	 * Sets the methods.
	 *
	 * @param methods the new methods
	 */
	public void setMethods(String[] methods) {
		this.methods = methods;
	}

	/**
	 * Gets the cls.
	 *
	 * @return the cls
	 */
	public IMod getCls() {
		return cls;
	}

	/**
	 * Sets the cls.
	 *
	 * @param cls the new cls
	 */
	public void setCls(IMod cls) {
		this.cls = cls;
	}

	/**
	 * Gets the isfinal.
	 *
	 * @return the isfinal
	 */
	public Boolean getIsfinal() {
		return isfinal;
	}

	/**
	 * Sets the isfinal.
	 *
	 * @param isfinal the new isfinal
	 */
	public void setIsfinal(Boolean isfinal) {
		this.isfinal = isfinal;
	}

	/**
	 * Fin.
	 *
	 * @return the module
	 */
	public Module fin() {
		this.isfinal = true;
		return this;
	}
	
	/**
	 * Instantiates a new module.
	 *
	 * @param name the name
	 * @param methods the methods
	 * @param cls the cls
	 */
	public Module(String name, String[] methods, IMod cls) {
		this.name = name;
		this.methods = methods;
		this.cls = cls;
		this.isfinal = true;
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
	 * Gets the sub.
	 *
	 * @return the sub
	 */
	public Module[] getSub() {
		return sub;
	}

	/**
	 * Sets the sub.
	 *
	 * @param sub the new sub
	 */
	public void setSub(Module[] sub) {
		this.sub = sub;
	}

	/**
	 * Instantiates a new module.
	 *
	 * @param name the name
	 */
	public Module(String name) {
		super();
		this.name = name;
	}

	/**
	 * Instantiates a new module.
	 *
	 * @param name the name
	 * @param sub the sub
	 */
	public Module(String name, Module[] sub) {
		super();
		this.name = name;
		this.sub = sub;
	}
	
}
