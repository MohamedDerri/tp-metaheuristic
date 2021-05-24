package SAC_A_DOS;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Object> object = new ArrayList<Object>();
		object.add(new Object(10, 2));
		object.add(new Object(5, 3));
		object.add(new Object(15, 5));
		object.add(new Object(7, 7));
		object.add(new Object(6, 1));
		object.add(new Object(18, 4));
		object.add(new Object(3, 1));
		
		SacDos sacDos = new SacDos(object, 15);
		sacDos.glouton1();
	}
	
}
