package velo.ladealpha.main;

interface ModS {
	Object m1();
	Object m2();
	Object m3();
	Object m4();
	Object m5();
}

public class Mod implements ModS {
	
	public Mod() {}
	
	public Mod(Object[] params) {
		this.params = params;
	}
	
	public Object[] params;
	public Object[] methods = {m1(), m2(), m3(), m4(), m5()};
	
	@Override
	public Object m1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object m2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object m3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object m4() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object m5() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
