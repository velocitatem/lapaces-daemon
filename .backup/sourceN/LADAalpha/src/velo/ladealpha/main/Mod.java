package velo.ladealpha.main;

// TODO: Auto-generated Javadoc
interface ModS {
	Object m1();
	Object m2();
	Object m3();
	Object m4();
	Object m5();
}

/**
 * The Class Mod.
 */
public class Mod implements ModS {
	
	/**
	 * Instantiates a new mod.
	 */
	public Mod() {}
	
	/**
	 * Instantiates a new mod.
	 *
	 * @param params the params
	 */
	public Mod(Object[] params) {
		this.params = params;
	}
	
	/** The params. */
	public Object[] params;
	
	/** The methods. */
	public Object[] methods = {m1(), m2(), m3(), m4(), m5()};
	
	/**
	 * M 1.
	 *
	 * @return the object
	 */
	@Override
	public Object m1() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M 2.
	 *
	 * @return the object
	 */
	@Override
	public Object m2() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M 3.
	 *
	 * @return the object
	 */
	@Override
	public Object m3() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M 4.
	 *
	 * @return the object
	 */
	@Override
	public Object m4() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M 5.
	 *
	 * @return the object
	 */
	@Override
	public Object m5() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
