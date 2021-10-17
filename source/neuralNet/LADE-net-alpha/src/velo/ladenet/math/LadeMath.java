package velo.ladenet.math;


public class LadeMath {
	public static double[][] manipulateMatrix(MatrixOps op, double[][] input, double cst) {
		
		if(op.equals(MatrixOps.SubtractFrom)) {
			for(int i = 0; i < input.length; i+=1) {
				for(int j = 0; j < input[i].length; j+=1) {
					input[i][j] -= cst;
				}
			}
		}
		else {
			
		}
		
		return input;
	}
	public static double[][] dot(double[][] a, double[][] b) {		
		int row1 = a.length, col1 = a[0].length, col2 = b[0].length;
		double[][] c = new double[row1][col2];
        for(int i = 0; i < row1; i++) {    
            for(int j = 0; j < col2; j++){    
              c[i][j]=0;      
              for(int k = 0; k < col1; k++){      
                c[i][j] += a[i][k] * b[k][j];      
              }               
            }            
        }
		return c;
	}
	public static double vectorSum(double[] input) {
		double sum = 0;
		for(int i = 0; i < input.length; i++ ) {
			sum += input[i];
		}
		return sum;
	}
	public static double[][] normalize(double[][] input) {
		double[][] normalized = new double[input.length][input[0].length];
		for(int i = 0; i < normalized.length; i += 1) {
			double sum = vectorSum(input[i]);
			for(int j = 0 ; j < input[i].length;j += 1) {
				normalized[i][j] = input[i][j] / sum;
			}
		}		
		return normalized;
	}
	public static double[][] exponentiate(double[][] input) {
		for(int i = 0; i < input.length; i+=1) {
			for(int j = 0; j < input[i].length; j+=1) {
				input[i][j] = Math.pow(Math.E, input[i][j] - max(input[i]));
			}
		}
		return input;
	}
	public static double[][] transpose(double[][] data) {
		double[][] ret = new double[data[0].length][data.length];		
		for(int r = 0 ; r < data.length; r +=1) {
			for(int c = 0; c < data[0].length; c+=1) {
				ret[c][r] = data[r][c];
			}
		}		
		return ret;
	}
	public static double max(double[] input) {
		double maxVal = Double.NEGATIVE_INFINITY;
		for(int i = 0; i < input.length; i+=1) {							
			maxVal = (input[i]>maxVal?input[i]:maxVal);			
		}
		return maxVal;
	}
	public static double[][] maximum(double[][] input) {
		for(int i = 0; i < input.length; i+=1) {
			for(int j = 0; j < input[i].length; j+=1) {
				input[i][j] = (input[i][j] > 0 ? input[i][j] : 0.0);
			}
		}
		return input;
	}	
}
