package velo.ladenet.math;

public class LadeMath {
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
	public static double[][] transpose(double[][] data) {
		double[][] ret = new double[data[0].length][data.length];		
		for(int r = 0 ; r < data.length; r +=1) {
			for(int c = 0; c < data[0].length; c+=1) {
				ret[c][r] = data[r][c];
			}
		}		
		return ret;
	}
	public static double[] max(double[] input) {
		for(int i = 0; i < input.length; i+=1) {
			input[i] = (input[i] > 0 ? input[i] : 0.0);
		}
		return input;
	}
}
