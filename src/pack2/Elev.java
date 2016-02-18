package pack2;

public class Elev {
	String nume;
	int nota;

	public Elev(String nume, int nota) {
		super();
		this.nume = nume;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "\nElev [nume=" + nume + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nota;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elev other = (Elev) obj;
		if (nota != other.nota)
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		return true;
	}


	
}
