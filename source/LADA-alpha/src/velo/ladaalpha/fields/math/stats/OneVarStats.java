package velo.ladaalpha.fields.math.stats;

import java.util.Arrays;

import velo.ladaalpha.misc.SortingAlgorithms;

public class OneVarStats {
	private Double xBar = 0.0, sumX = 0.0, sumX2 = 0.0, SD = 0.0, n = 0.0, minX = 0.0, q1 = 0.0, med = 0.0, q3 = 0.0, maxX = 0.0, iqr = 0.0;
	private double[] arr;
	private double[] Quartiles(double[] val) {
	    double ans[] = new double[3];

	    for (int quartileType = 1; quartileType < 4; quartileType++) {
	        float length = val.length + 1;
	        double quartile;
	        float newArraySize = (length * ((float) (quartileType) * 25 / 100)) - 1;	        
	        if (newArraySize % 1 == 0) {
	            quartile = val[(int) (newArraySize)];
	            } else {
	            int newArraySize1 = (int) (newArraySize);
	            quartile = (val[newArraySize1] + val[newArraySize1 + 1]) / 2;
	             }
	        ans[quartileType - 1] =  quartile;
	    }
	    return ans;
	}
	public OneVarStats(double[] arr) {
		super();
		this.arr = arr;
		this.n = 1.0 * arr.length;
		for (Double d : arr) {
			this.sumX += d;
		}
		this.xBar = sumX / n;
		for (Double d : arr) {
			this.sumX2 += d * d;
		}
		double sumMeanDiffSQ = 0, sumMeanDiffSQP = 0;
		for (double d : arr) {
			sumMeanDiffSQ += Math.pow(d - this.xBar, 2);			
		}
		SD = Math.sqrt(sumMeanDiffSQ / (n - 1));		
		double[] sorted = SortingAlgorithms.insertionSort(arr);
		minX = sorted[0];
		maxX = sorted[sorted.length - 1];
		double[] qs = Quartiles(sorted); q1 = qs[0]; med = qs[1]; q3 = qs[2]; iqr = q3 - q1;
	}

	
	@Override
	public String toString() {
		return "OneVarStats [xBar=" + xBar + ", sumX=" + sumX + ", sumX2=" + sumX2 + ", SD=" + SD + ", n=" + n
				+ ", minX=" + minX + ", q1=" + q1 + ", med=" + med + ", q3=" + q3 + ", maxX=" + maxX + ", iqr=" + iqr
				+ ", arr=" + Arrays.toString(arr) + "]";
	}
	public Double getxBar() {
		return xBar;
	}
	public void setxBar(Double xBar) {
		this.xBar = xBar;
	}
	public Double getSumX() {
		return sumX;
	}
	public void setSumX(Double sumX) {
		this.sumX = sumX;
	}
	public Double getSumX2() {
		return sumX2;
	}
	public void setSumX2(Double sumX2) {
		this.sumX2 = sumX2;
	}
	public Double getSD() {
		return SD;
	}
	public void setSD(Double sD) {
		SD = sD;
	}
	public Double getN() {
		return n;
	}
	public void setN(Double n) {
		this.n = n;
	}
	public Double getMinX() {
		return minX;
	}
	public void setMinX(Double minX) {
		this.minX = minX;
	}
	public Double getQ1() {
		return q1;
	}
	public void setQ1(Double q1) {
		this.q1 = q1;
	}
	public Double getMed() {
		return med;
	}
	public void setMed(Double med) {
		this.med = med;
	}
	public Double getQ3() {
		return q3;
	}
	public void setQ3(Double q3) {
		this.q3 = q3;
	}
	public Double getMaxX() {
		return maxX;
	}
	public void setMaxX(Double maxX) {
		this.maxX = maxX;
	}
	public Double getIqr() {
		return iqr;
	}
	public void setIqr(Double iqr) {
		this.iqr = iqr;
	}
	public double[] getArr() {
		return arr;
	}
	public void setArr(double[] arr) {
		this.arr = arr;
	}
	


}
