package pack2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



 public class Principala {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Elev> elevi = new ArrayList<Elev>();
		
		
		elevi.add(new Elev("Gigi", 3));
		elevi.add(new Elev("Gigi", 7));
		elevi.add(new Elev("Aon", 10));
		
		ComparatorDupaNumeNota comparator = new ComparatorDupaNumeNota();
		Collections.sort(elevi, comparator);
		
		System.out.println(elevi.toString());
		
	}

}
