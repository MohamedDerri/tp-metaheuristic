package tp1.SAC_A_DOS;

import java.util.*;

public class SacDos {
	private ArrayList<Object>	object;
	private int					capacity;

	//-------------------constructor-------------------------
	public SacDos(ArrayList<Object> object, int capacity) {
		this.object = object;
		this.capacity = capacity;
	}
	//-------------------methods-------------------------
	void glouton1() {

		ArrayList<Boolean> taken = new ArrayList<Boolean>();
		ArrayList<Double> fraction = new ArrayList<Double>();
		double finalValue = 0;
		int currentWeight = 0;

		for (int i = 0; i < this.object.size(); i++) {
			taken.add(false);
			fraction.add((double)(this.object.get(i).getValue()) / (double)(this.object.get(i).getWeight()));
		}

		for (int i = 0; i < this.object.size(); i++) {
			double max;
			int indexOf;
			max = Collections.max(fraction);
			indexOf = fraction.indexOf(max);
			if (currentWeight + this.object.get(indexOf).getWeight() <= this.capacity) {
				currentWeight += this.object.get(indexOf).getWeight();
				finalValue += this.object.get(indexOf).getValue();
				taken.set(indexOf, true);
				fraction.set(indexOf, -30. + i);
			}
			else {
				fraction.set(indexOf, -30. + i);
			}
		}

		System.out.println("==> " + taken);
		System.out.println("the final value is " + finalValue);
		// Solution solution = new Solution(taken, finalValue);
		// return solution;

	}

}

