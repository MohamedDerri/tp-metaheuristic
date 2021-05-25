package SAC_A_DOS_DESCENTE;

import java.util.*;

public class Solution {
	private ArrayList<Boolean>	instance;
	private	double				finalValue;	
	//-------------------constructor-------------------------
	public Solution(ArrayList<Boolean>	instance, double finalValue) {
		this.instance = instance;
		this.finalValue = finalValue;
	}

	public void setSolution(ArrayList<Boolean>	instance, int finalValue) {
		this.instance = instance;
		this.finalValue = finalValue;
	}
	public ArrayList<Boolean> getInstance() {
		return this.instance;
	}
	public double getFinalValue() {
		return this.finalValue;
	}
}
