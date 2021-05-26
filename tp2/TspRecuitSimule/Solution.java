package com.DerriLazrek;

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
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.path.length; i++) {
            s += "" + this.path[i];
        }
        return s;
    }
}

