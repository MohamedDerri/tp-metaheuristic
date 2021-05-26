package SAC_A_DOS_DESCENTE;

import java.util.*;



public class Main {
	public static int calcValuefromInstance(ArrayList<Boolean> inst, SacDos sacDos) {
		int cnt = 0;
		for (int i = 0; i < inst.size(); i++) {
			if (inst.get(i) == true)
				cnt += sacDos.getObject().get(i).getValue();
		}
		return cnt;
	}

	public static int calcWeightFromInstance(ArrayList<Boolean> inst, SacDos sacDos) {
		int cnt = 0;
		for (int i = 0; i < inst.size(); i++) {
			if (inst.get(i) == true)
				cnt += sacDos.getObject().get(i).getWeight();
		}
		return cnt;
	}
	public static ArrayList<Boolean>	  hamming(ArrayList<Boolean> oldInstance, int indexToChance) {
		ArrayList<Boolean> ret = new ArrayList<>();
		for (int i = 0; i < oldInstance.size(); i++) {
			ret.add(oldInstance.get(i));
		}
		if (indexToChance >= 0 && indexToChance <= oldInstance.size()-1 && ret.get(indexToChance) == true)
			ret.set(indexToChance, false);
		else if (indexToChance >= 0 && indexToChance <= oldInstance.size()-1 && ret.get(indexToChance) == false)
			ret.set(indexToChance, true);
		return ret;
	}
	public static ArrayList<Solution> generate(Solution sol, SacDos sacDos) {
		ArrayList<Solution> list = new ArrayList<>();
		int i = 0;
		System.out.println("generation des solutions voisinages par la methodes HAMMING: WORKED IN A => ");
		while (i < sol.getInstance().size()) {
			ArrayList<Boolean> newInstance = hamming(sol.getInstance(),  i);///indice i a changer || hamming(newInstance)
			int newFinalValue = calcValuefromInstance(newInstance, sacDos);//ArrayList<Object> for ret value in same indace of new instance 
			list.add(new Solution(newInstance, newFinalValue));
			i++;
		}
		return list;
	}

	public static Solution select(ArrayList<Solution> list, SacDos sacDos) {
		double max = calcValuefromInstance(list.get(0).getInstance(), sacDos);
		Solution s = list.get(0);
		System.out.println("max = " + max);
		System.out.println("|||maxWeight :" + calcWeightFromInstance(list.get(0).getInstance(), sacDos));



		for (int i = 1; i < list.size(); i++) {
			System.out.println("|||capacity of instance :" + calcValuefromInstance(list.get(i).getInstance(), sacDos));
			System.out.println("|||totalWeight of instance :" + calcWeightFromInstance(list.get(i).getInstance(), sacDos));
			if (max <  calcValuefromInstance(list.get(i).getInstance(), sacDos) && calcWeightFromInstance(list.get(i).getInstance(), sacDos) <= sacDos.getCapacity())
			{
				s = list.get(i);
				max = list.get(i).getFinalValue();
				// System.out.println("max = " + max);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// ArrayList<Boolean> old = new ArrayList<>();
		// old.add(false);
		// old.add(true);
		// old.add(false);
		// old.add(false);
		// old.add(true);
		// old.add(false);
		// old.add(true);
		// ArrayList<Boolean> newI = hamming(old, 2);
		// System.out.println(old);
		// System.out.println(newI);

		//////////////////INITIALISTAION
		ArrayList<Object> object = new ArrayList<>();
		object.add(new Object(10, 2));
		object.add(new Object(5, 3));
		object.add(new Object(15, 5));
		object.add(new Object(7, 7));
		object.add(new Object(6, 1));
		object.add(new Object(18, 4));
		object.add(new Object(3, 1));
		
		SacDos sacDos = new SacDos(object, 15);
		Solution sol = sacDos.glouton1();
		///////////////////////////////////////

		/////////////test BAAADDD
		// ArrayList<Boolean> arr = new ArrayList<Boolean>();
		// arr.add(true);
		// arr.add(true);
		// arr.add(true);
		// arr.add(true);
		// arr.add(true);
		// arr.add(true);
		// arr.add(true);
		// Solution sol = new Solution(arr, 64.0);
		///////////////////////////
		//////////////DESCENT
		int t = 0;
		while(t < object.size()) {
			ArrayList<Solution> listgenerate = generate(sol, sacDos);//ADD objects
			Solution se = select(listgenerate, sacDos);
			System.out.print("the selected soltion is : ");
			System.out.print(se.getInstance());
			
			System.out.println();
			System.out.println("the value of the selected solution is : " + se.getFinalValue());
			if (sol.getFinalValue() > se.getFinalValue() && calcWeightFromInstance(sol.getInstance(), sacDos) >= calcWeightFromInstance(se.getInstance(), sacDos) )
				break ;
			sol = se;
			t++;
		}
		System.out.println("the perfect instance is : ");
		System.out.println(sol.getInstance());

		System.out.println();
		System.out.println("the perfect solution is " + sol.getFinalValue());
		//////////////////////////////////////////////
	}
	
}
