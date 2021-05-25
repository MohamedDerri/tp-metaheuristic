package SAC_A_DOS;

import java.util.*;

public class Solution {
	private ArrayList<Boolean>	instance;
	private	double				finalValue;	
	//-------------------constructor-------------------------
	public Solution(ArrayList<Boolean>	instance, int finalValue) {
		this.instance = instance;
		this.finalValue = finalValue;
	}

	public void setSolution(ArrayList<Boolean>	instance, int finalValue) {
		this.instance = instance;
		this.finalValue = finalValue;
	}
}
