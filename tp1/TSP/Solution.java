package TSP;

import java.util.*;

public class Solution {
	private String[]	path;
	private	double				totalDistance;	
	//-------------------constructor-------------------------
	public Solution(String[] path, int totalDistance) {
		this.path = path;
		this.totalDistance = totalDistance;
	}

	//-------------------methods-------------------------

	public void afficheSolution() {
		for (int i = 0; i < this.path.length; i++) {
			System.out.print(this.path[i] + " ");
		}
		System.out.println();
		System.out.println("total distance = " + this.totalDistance);
	}
	// public void setSolution(ArrayList<Boolean>	instance, int finalValue) {
	// 	this.instance = instance;
	// 	this.finalValue = finalValue;
	// }
}
