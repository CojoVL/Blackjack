package pack1;

import java.util.Arrays;

public class Pachet {
	Carte[][] pachet = new Carte[4][13];
	int nrcarte = -1;

	public Pachet() {
		String[] simbol = { "♣", "♦", "♥", "♠" };
		String[] simbolText = { "A", "J", "Q", "K" };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (j < 9) {
					pachet[i][j] = new Carte(j + 2, simbol[i],""+(j + 2)+"."+(i+1)+".jpg");
				} else {
					if (j == 9) {
						pachet[i][j] = new Carte(simbolText[j - 9], simbol[i], 11,""+simbolText[j - 9]+"."+(i+1)+".jpg");
					} else {
						pachet[i][j] = new Carte(simbolText[j - 9], simbol[i],""+simbolText[j - 9]+"."+(i+1)+".jpg");
					}
				}
			}
		}
	}

	public void amestecaPachet() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				int z = (int) (Math.random() * 4);
				int y = (int) (Math.random() * 13);
				Carte temp = this.pachet[i][j];
				this.pachet[i][j] = this.pachet[z][y];
				this.pachet[z][y] = temp;
			}
		}
	}

	public Carte getCard() {
		Carte[] carti = new Carte[52];
		int z = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				carti[z] = pachet[i][j];
				z++;
			}
		}
		nrcarte++;
		
		return carti[nrcarte];
	}

	@Override
	public String toString() {
		return "Pachet [pachet=" + Arrays.toString(pachet) + "]";
	}

}
