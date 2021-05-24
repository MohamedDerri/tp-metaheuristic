package TSP;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int[][] graph = {{1, 2, 3}, 
						{4, 5, 6}, 
						{7, 8, 9}};
		Tsp	tsp = new Tsp(graph);
		tsp.affichage();
		tsp.gloutonTsp(0);
	}
	
}
