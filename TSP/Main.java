package TSP;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int[][] graph = {{0, 5, 1000, 6, 1000, 4, 1000, 7}, 
						{5, 0, 2, 4, 3, 1000, 1000, 1000}, 
						{1000, 2, 0, 1, 1000, 1000, 1000, 1000},
						{6, 4, 1, 0, 7, 1000, 1000, 1000}, 
						{1000, 3, 1000, 7, 0, 1000, 6, 4}, 
						{4, 1000, 1000, 1000, 1000, 0, 3, 1000}, 
						{1000, 1000, 1000, 1000, 6, 3, 0, 2}, 
						{7, 1000, 1000, 1000, 4, 1000, 2, 0}};
		Tsp	tsp = new Tsp(graph);
		// tsp.affichage();
		tsp.gloutonTsp(0);
	}
	
}
