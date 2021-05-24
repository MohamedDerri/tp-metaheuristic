package TSP;

import java.util.*;

public class Tsp {
	private int[][]	graph;

	//-------------------constructor-------------------------
	public Tsp(int[][] graph) {
		this.graph = graph;
	}

	//-------------------methods-------------------------

	public	void affichage() {
		for (int i = 0; i < this.graph.length; i++) {
			for (int j = 0; j < this.graph[i].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	void gloutonTsp() {
		Boolean	visited = new Boolean[this.graph.length];
		String	path = new String[this.graph.length + 1]; // point de depart + point d'arrivée
		
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		

	}

}

