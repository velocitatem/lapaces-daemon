package velo.ladanet.visual;

public class Visualizer {
	public static void visualizeMatrix(double[][] mat) {
		for(int i = 0 ; i < mat.length ; i+=1) {
			for(int c = 0; c < mat[i].length; c+=1) {
				System.out.print(mat[i][c] + " ");
			}
			System.out.println();
		}
	}
}
