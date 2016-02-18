package pack1;

import javax.swing.ImageIcon;

public class Carte {
	String valoare;
	String simbol;
	int valoareblack;
	ImageIcon imagine;

	public Carte(int valoare ,String simbol,String imagine) {
		super();
		this.valoare = ""+valoare;
		this.simbol = simbol;
		this.valoareblack = valoare;
		this.imagine=new ImageIcon(imagine);
	}

	public Carte(String valoare, String simbol,String imagine) {
		super();
		this.valoare = valoare;
		this.simbol = simbol;
		this.valoareblack = 10;
		this.imagine=new ImageIcon(imagine);

	}
	public Carte(String valoare, String simbol, int valoareblackAs,String imagine) {
		super();
		this.valoare = valoare;
		this.simbol = simbol;
		this.valoareblack = valoareblackAs;
		this.imagine=new ImageIcon(imagine);
	}

	@Override
	public String toString() {
		return ""+valoare + simbol;
	}

	

}
