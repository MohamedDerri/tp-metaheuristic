package TspGenetic;

import java.util.*;



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
    public static int [] two_opt(int [] oldPath, int start, int end) {
        if (end < start)
        {
            System.out.println("end > start");
            return null;
        }
        int [] newPath = new int[oldPath.length];

        for (int i = 0; i < oldPath.length; i++)
        {
            if (i < start || i > end) {
                newPath[i] = oldPath[i];
            }
            else
                newPath[i] = oldPath[end - i + start];
        }
        return newPath;
    }
    public static ArrayList<Solution> generate(Solution sol) {
        ArrayList<Solution> list = new ArrayList<>();
        int i = 0;
        System.out.println("generation des solutions voisinages par la methodes 2-opt");
        while (i < sol.getPath().length - 1) {
            int start = (int)Math.floor(Math.random()*(sol.getPath().length / 2)+1);
            int end = (int)Math.floor(Math.random()*((sol.getPath().length - 2)-sol.getPath().length / 2+1)
                    +sol.getPath().length / 2);
            System.out.println("start = " + start + "   end = " + end);
            int [] newPath = two_opt(sol.getPath(), start ,end);///
            int newDist = calcDistfromPath(newPath, sol.getGraph());
            list.add(new Solution(newPath, newDist, sol.getGraph()));
            i++;
        }
        return list;
    }

    public static Solution select(ArrayList<Solution> list) {
        int index = (int)Math.floor(Math.random()*(list.size() - 1));
        return list.get(index);
    }
    public static double p(Solution sol, Solution se, double T) {
        if (se.getDist() < sol.getDist())
            return 1.0;
        else
            return Math.exp(((double)sol.getDist() - (double)se.getDist()) / T);
    }

    public static ArrayList<Solution> initPopulation(int startIndex, int [][] graph) {
        ArrayList<Solution> list = new ArrayList<>();
        int firstPath[] = new int[graph.length + 1];
        firstPath[graph.length] = startIndex;
        int temp;
        // generating the path from witch we will produce the other paths
        for (int i = 0; i < graph.length; i++) {
            firstPath[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            if (firstPath[i] == startIndex) {
                temp = firstPath[i];
                firstPath[i] = firstPath[0];
                firstPath[0] = temp;
            }
        }
        System.out.print("the starting path is : ");
        for (int i = 0; i < graph.length + 1; i++) {
            System.out.print(firstPath[i] + " ");
        }
        System.out.println();

        // producing the other paths, generating a whole population
        for (int i = 0; i < (graph.length + 1 )* 30000; i++) {
            int swapIndex = (int)Math.floor(Math.random()*(firstPath.length - 2)+1);
            int swapIndexT = (int)Math.floor(Math.random()*(firstPath.length - 2)+1);
            int tmp = firstPath[swapIndex];
            firstPath[swapIndex] = firstPath[swapIndexT];
            firstPath[swapIndexT] = tmp;
            int newDist = calcDistfromPath(firstPath, graph);
            int [] newPath = new int[firstPath.length];
            for (int j = 0; j < firstPath.length; j++) {
                newPath[j] = firstPath[j];
            }
            list.add(i, new Solution(newPath, newDist, graph));
            // for (int j = 0; j < graph.length + 1; j++) {
            //     System.out.print(firstPath[j] + " ");
            // }
            // System.out.print("==> " + newDist);
            // System.out.println();
        }
        System.out.println("the generated population is : ");
        for (int i = 0; i < (graph.length + 1)*3000; i++) {
            list.get(i).afficheSolution();
            System.out.println();
        }
        System.out.println();
        return list;
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
        initPopulation(7, graph);
//        Solution sol = tsp.gloutonTsp(0);
        // double T = 1000.;
        // int [] badPath = {0,4,1,2,3,7,6,5,0};
        // Solution sol = new Solution(badPath, 2015, graph);
        // boolean t = false;
        // double r = 0.0;
        // while(T > 0) {
        //     t = false;
        //     do {
        //         ArrayList<Solution> listgenerate = generate(sol);
        //         Solution se = select(listgenerate);//select aleatoire
        //         if (p(sol, se, T) > (r = Math.random())) {
        //             sol = se;
        //             t = true;
        //         }
        //     } while (!t);
        //     T -= r;
        // }
        // System.out.print("the shortest path is : ");
        // for (int i = 0; i < sol.getPath().length; i++) {
        //     System.out.print("City" + sol.getPath()[i] + " ");
        // }
        // System.out.println();
        // System.out.println("the perfect solution is " + sol.getDist());
    }

}

