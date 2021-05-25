package TSP_DESCENTE;

import java.util.ArrayList;

import TSP.Solution;

public class Main {
	public static int calcDistfromPath(int [] path, int [][] gr) {
		int cnt = 0;
		for (int i = 0; i < path.length - 1; i++) {
			int index = path[i];
			int nextIndex = path[i + 1];
			cnt += gr[index][nextIndex];
		}
		return cnt;
	}
	public static ArrayList<Solution> generate(Solution sol) {
		ArrayList<Solution> list = new ArrayList<>();
		int i = 0;
		while (i < 5) {
			int [] newPath = two_opt(sol.getPath(), i, j);
			int newdist = calcDistfromPath(newPath, sol.getGraph()); 
			list.add(new Solution(newPath, newdist, sol.getGraph()));
			i++;
		}
	}
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
		// // tsp.affichage();
		// Solution solution = tsp.gloutonTsp(0);
		// solution.afficheSolution();
		// System.out.println(solution.calcDistfromPath());
		Solution sol = tsp.gloutonTsp(0);
		int t = 0;
		while(t < 5) {
			ArrayList<Solution> listgenerate = generate(sol);
			Solution se = select(listgenerate);
			if (sol.getDist() < se.calcDistfromPath())//se.getDist()
				break ;
			sol = se;
			t++;
		}

	}
	
}
