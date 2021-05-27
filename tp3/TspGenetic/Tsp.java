package TspGenetic;

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

    public int findMin(int currentCity, Boolean visited[]) {
        int min = 1001;
        int indexOfMin = currentCity;
        for (int i = 0; i < this.graph[currentCity].length; i++) {
            if (i != currentCity && visited[i] == false && min > this.graph[currentCity][i]) {
                min = this.graph[currentCity][i];
                indexOfMin = i;
            }
        }
        System.out.println("min => " + min);
        return indexOfMin;
    }

    public Solution gloutonTsp(int start) {
        Boolean	visited[] = new Boolean[this.graph.length];
        int	path[] = new int[this.graph.length + 1]; // point de depart + point d'arrivée
        int p = 0;
        int nextCity = start;
        int totalDistance = 0;

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int j = start;
        path[0] = start;
        path[this.graph.length] = start;
        visited[start] = true;
        for (int i = 0; i < this.graph.length - 1 ; i++) {
            nextCity = findMin(j, visited);
            totalDistance += this.graph[j][nextCity];
            j = nextCity;
            visited[nextCity]  = true;
            path[++p] = nextCity;
        }
        totalDistance += this.graph[j][start];
        return new Solution(path, totalDistance, this.graph);
    }
}
