package velo.ladealpha.fields.economy.supplyANDdemand;

import velo.ladealpha.fields.math.LinearFunction;

public class Supply extends LinearFunction{
	public Supply(double x1, double y1, double x2, double y2) {
		super();
		super.buildFromTwoPoints(x1, y1, x2, y2);
	}
}
