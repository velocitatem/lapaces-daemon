package velo.ladaalpha.fields.math.stats;

import java.util.Arrays;

public class TwoVarStats {
	private double xBar, sumX, sumX2, sX, n, yBar, sumY, sumY2, sY, sumXY, minX, maxX, minY, maxY, r, r2;
	private double[] x, y;
	public TwoVarStats(double[] x, double[] y) {
		this.x = x; this.y = y;
		OneVarStats ovsX = new OneVarStats(x), ovsY = new OneVarStats(y);
		n = x.length-y.length==0?x.length:-1;
		if(n==-1) return;
		xBar = ovsX.getxBar(); sumX = ovsX.getSumX(); sumX2 = ovsX.getSumX2(); sX = ovsX.getSD();
		yBar = ovsY.getxBar(); sumY = ovsY.getSumX(); sumY2 = ovsY.getSumX2(); sY = ovsY.getSD();
		double sum1 = 0, sum2 = 0, sum3 = 0;
		int i = 0;
		for(double xx : x) {
			double yy = y[i];
			sum1+=(xx-xBar)*(yy-yBar);
			i+=1;
		}
		i = 0;
		for(double xx : x) {
			sum2+=Math.pow(xx -xBar, 2);
		}
		i = 0;
		for(double yy : y) {
			sum3+=Math.pow(yy -yBar, 2);
		}
		r = (sum1)/Math.sqrt(sum2*sum3);
		r2 = Math.pow(r, 2);
	}
	@Override
	public String toString() {
		return "TwoVarStats [xBar=" + xBar + ", sumX=" + sumX + ", sumX2=" + sumX2 + ", sX=" + sX + ", n=" + n
				+ ", yBar=" + yBar + ", sumY=" + sumY + ", sumY2=" + sumY2 + ", sY=" + sY + ", sumXY=" + sumXY
				+ ", minX=" + minX + ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY + ", r=" + r + ", r2=" + r2
				+ ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + "]";
	}
	public double getxBar() {
		return xBar;
	}
	public void setxBar(double xBar) {
		this.xBar = xBar;
	}
	public double getSumX() {
		return sumX;
	}
	public void setSumX(double sumX) {
		this.sumX = sumX;
	}
	public double getSumX2() {
		return sumX2;
	}
	public void setSumX2(double sumX2) {
		this.sumX2 = sumX2;
	}
	public double getsX() {
		return sX;
	}
	public void setsX(double sX) {
		this.sX = sX;
	}
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}
	public double getyBar() {
		return yBar;
	}
	public void setyBar(double yBar) {
		this.yBar = yBar;
	}
	public double getSumY() {
		return sumY;
	}
	public void setSumY(double sumY) {
		this.sumY = sumY;
	}
	public double getSumY2() {
		return sumY2;
	}
	public void setSumY2(double sumY2) {
		this.sumY2 = sumY2;
	}
	public double getsY() {
		return sY;
	}
	public void setsY(double sY) {
		this.sY = sY;
	}
	public double getSumXY() {
		return sumXY;
	}
	public void setSumXY(double sumXY) {
		this.sumXY = sumXY;
	}
	public double getMinX() {
		return minX;
	}
	public void setMinX(double minX) {
		this.minX = minX;
	}
	public double getMaxX() {
		return maxX;
	}
	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}
	public double getMinY() {
		return minY;
	}
	public void setMinY(double minY) {
		this.minY = minY;
	}
	public double getMaxY() {
		return maxY;
	}
	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getR2() {
		return r2;
	}
	public void setR2(double r2) {
		this.r2 = r2;
	}
	public double[] getX() {
		return x;
	}
	public void setX(double[] x) {
		this.x = x;
	}
	public double[] getY() {
		return y;
	}
	public void setY(double[] y) {
		this.y = y;
	}

	
}
