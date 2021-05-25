package tp1.SAC_A_DOS;

import java.util.*;


public class Object {
	private int 	value;
	private int		weight;
	// private boolean	taken; // si l'object a ete pris ou non;
	//-------------------constructor-------------------------c

	public	Object(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	//-------------------getters-----------------------------

	public int	getValue() {
		return this.value;
	}

	public int getWeight() {
		return this.weight;
	}

	//-------------------setters-----------------------------

	public void setValue(int value) {
		this.value = value;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
