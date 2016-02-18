package pack1;



public class Jucator {
	String denumire;
	int sold;
	Carte[] carti=new Carte[52];
	int sumaCarti=0;
	int nrCarti=0;
	
	public Jucator(String denumire) {
		super();
		this.denumire = denumire;
	}
	//era mai comod cu un araylist 
	public void sumaCarti(int nrcarti){
		sumaCarti=0;
		for(int i=0;i<nrcarti;i++){
			sumaCarti+=carti[i].valoareblack;
		}
		}
	
	public void afisareCarti(int nrCartiPrimite) {
		
		System.out.println("\nCarti "+denumire+":\n----------");
		for (int i = 0; i < nrCartiPrimite; i++) {
			System.out.print(this.carti[i] + " ");
		}
		System.out.println("\n----------");
	}
	
	
		
	
	
	
	

}
