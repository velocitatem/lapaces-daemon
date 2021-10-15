package velo.ladealpha.fields.astronomy;

public class SpaceObject {
	
	public SpaceObject(long mass) {
		super();
		this.mass = (long) (mass * Math.pow(10, 20));
	}

	private long mass; // rel to 10^20
}
