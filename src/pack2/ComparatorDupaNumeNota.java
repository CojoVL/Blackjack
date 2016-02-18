package pack2;

import java.util.Comparator;

public class ComparatorDupaNumeNota implements Comparator<Elev> {

	
	
	
	
	
	
	
	
	@Override
	public int compare(Elev elev1, Elev elev2) {
		if(elev1.nume.compareTo(elev2.nume)<0){
			return -1;
		}else if(elev1.nume.compareTo(elev2.nume)>0){
			return 1;
		}else if(elev1.nota<elev2.nota){
			return -1;
		}else if(elev1.nota>elev2.nota){
			return 1;
		}else {
			return 0;
		}
		
	}
	

}
