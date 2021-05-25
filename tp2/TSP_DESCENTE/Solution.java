package TSP_DESCENTE;

import java.util.*;

public class Solution {
	private int[]		path;
	private	int				totalDistance;
	private int[][] 		gr;
	//-------------------constructor-------------------------
	public Solution(int[] path, int totalDistance, int [][] gr) {
		this.path = path;
		this.totalDistance = totalDistance;
		this.gr = gr;
	}

	//-------------------methods-------------------------

	public void afficheSolution() {
		for (int i = 0; i < this.path.length; i++) {
			System.out.print("city" + this.path[i] + " ");
		}
		System.out.println();
		System.out.println("total distance = " + this.totalDistance);
	}
	public int getDist() {
		return this.totalDistance;
	}
	public int [] getPath() {
		return this.path;
	}
	public int[][] getGraph() {
		return this.gr;
	}
	// public static int get_index(int c) {
	// 	int i = 0;
	// 	while (i < c.length()) {
	// 		if (c.charAt(i) >= '0' )
	// 		i++;
	// 	}
	// }
	// public int calcDistfromPath() {
	// 	int cnt = 0;
	// 	for (int i = 0; i < this.path.length - 1; i++) {
	// 		int index = this.path[i];
	// 		int nextIndex = this.path[i + 1];
	// 		cnt += this.gr[index][nextIndex];
	// 	}
	// 	return cnt;
	// }
	// public void setSolution(ArrayList<Boolean>	instance, int finalValue) {
	// 	this.instance = instance;
	// 	this.finalValue = finalValue;
	// }
}
