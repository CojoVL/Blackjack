package pack1;

import java.math.MathContext;
import java.util.Scanner;

public class Principala {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Geereaza pachetul de carti
		Scanner sc = new Scanner(System.in);
		Pachet cards = new Pachet();
		// afisaza pachetul de carti
		for (int i = 0; i < 4; i++) {
			System.out.print("\n\t\t\t");
			for (int j = 0; j < 13; j++) {
				System.out.print(cards.pachet[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println("\t\t\t\t~~~*CASINO ROYALE*~~~");
		System.out.println("\t\t\t\t      *WELCOME*   ");

		// Creaza ce doi participanti la joc Dealer si jucator
		Jucator dealer = new Jucator("DEALER");
		System.out.println("\n\n\tBuna ziua! Introduceti numele dumneavoastra:");
		Jucator player = new Jucator(sc.nextLine());
		
		//Se cere jucatorului sa inroduca suma disponibila pt mai multe runde de pariere
		System.out.println("\tIntroduceti suma cu care intrati la masa:");
		String playerSold=sc.nextLine();
		player.sold=Integer.parseInt(playerSold);
		int sumaPariataRunda=0;
		int runda = 0;
		System.out.println("\n\n\t\t\t$$$$$*Let's Play*$$$$$ ");
		
		//bucla pentru rularea jocului pentru mai multe runde(care sunt contorizate si
		//afisat numarul rundei)pana cand playerul
		// doreste sa retraga suma castigataa sau este nevoit sa paraseasca masa 
		// datorita fondurilor insuficiente
			rundaNoua: do {
			runda++;
			System.out.println("\n\n\t\t\t\t~~~*CASINO ROYALE*~~~");
			//		System.out.println("\t\t\t\t      *WELCOME*   ");
			System.out.println("\t\t\t\t\n\n\nMana numarul : " + runda + "\n\n\n");
			System.out.println("\tSold disponibil: "+player.sold);
			System.out.println("\tPlasati pariul[pentru CASHOUT si parasirea mesei apasati \"0\"]\n\tSuma pariata :");
			String sumaPariataRunda1=sc.nextLine();
			sumaPariataRunda=Integer.parseInt(sumaPariataRunda1);
			
			//Optiune Cashout si parasire a mesei. (Inchidere program)
			if((sumaPariataRunda>player.sold)||(player.sold==0)){
				System.out.println("Fonduri insuficiente!La revedere!!");
				return;
			}
			switch (sumaPariataRunda) {
			case 0:
				System.out.println("\n\t***Va multumim pentru vizita***\n\t***Va mai asteptam la mesele noastre***");
				return;

			default:
				break;
			}
			
		
			// Amesteca cartile din pachet
			cards.amestecaPachet();

			// Atribuie cate 2 carti fiecarui jucator
			player.nrCarti = 2;
			dealer.nrCarti = 2;
			for (int i = 0; i < 2; i++) {
				dealer.carti[i] = cards.getCard();
				player.carti[i] = cards.getCard();
			}
			// afiseaza cartile celor 2 jcatori

			// afiseaza doar prima carte a dealerului
			System.out.println("Carti Dealer:\n----------");
			System.out.println(dealer.carti[0] + " XX");
			System.out.println("----------\n");
			// afiseaza cartile jucatorului
			player.afisareCarti(player.nrCarti);

			// Calculeaza valoarea cartilor jucatorilor

			player.sumaCarti(player.nrCarti);
			dealer.sumaCarti(dealer.nrCarti);
			// verifica daca cineva are blackjack
			if ((dealer.sumaCarti == 21) && (player.sumaCarti != 21)) {
				System.out.println("\tYou LOOSE!! Dealerul a facut BLACKJACK!\n");
				player.sold-=sumaPariataRunda;
				dealer.afisareCarti(2);
				continue rundaNoua;
			}
			if ((dealer.sumaCarti == 21) && (player.sumaCarti == 21)) {
				System.out.println("\tREMIZA.Ambii ati facut BLACKJACK!");
				dealer.afisareCarti(2);
				continue rundaNoua;
				
			}
			if (player.sumaCarti == 21) {
				System.out.println("\tBLACKJACK!!!! YOU WINN!!");
				player.sold+=sumaPariataRunda;
				continue rundaNoua;
			} else {
				// bucla infinita pentru a mai primi o carte pana cand jucatorul spune nu
				primesteCarte: do {
					// Verifica daca jucatorul a primit As si intreba-l ce
					// valoare ii atribuie
					for (int i = 0; i < player.nrCarti; i++) {
						if (player.carti[i].valoareblack == 11) {
							System.out.println("Ati primit un As. Ii atribuiti valoarea 1? ");
							String answer = sc.nextLine();
							switch (answer) {
							case "da":
								player.carti[i].valoareblack = 1;
								break;
							default:
								break;
							}
						}
					}
					
					System.out.println("Mai doriti o carte?");
					String answer = sc.nextLine();
					answer = answer.toLowerCase();
					switch (answer) {
					case "da":
						player.carti[player.nrCarti] = cards.getCard();
						if (player.carti[player.nrCarti].valoareblack == 11) {
							System.out.println("Ati primit un As. Ii atribuiti valoarea 1? ");
							String answer2 = sc.nextLine();
							switch (answer2) {
							case "da":
								player.carti[player.nrCarti].valoareblack = 1;
								break;
							default:
								break;
							}
						}
						player.nrCarti++;
						player.afisareCarti(player.nrCarti);
						break;
					default:
						break primesteCarte;
					}
					player.sumaCarti(player.nrCarti);
					System.out.println("Valoare carti :"+player.sumaCarti);
					if (player.sumaCarti > 21) {
						System.out.println("\tAti pierdut!!! ");
						player.sold-=sumaPariataRunda;
						continue rundaNoua;
					} else {
						if (player.sumaCarti == 21) {
							System.out.println("\n\tFelicitari , ati realizat 21 de pct.!");
							break;
						}
					}

				} while (true);
			}
			//Se iese din bucla unde jucatorul cere si primeste carti 
			//dealerul primesti carti daca are mai putin de 17 pcte
			while (dealer.sumaCarti < 17) {
				dealer.carti[dealer.nrCarti] = cards.getCard();
				dealer.nrCarti++;
				dealer.sumaCarti(dealer.nrCarti);
			}
			//afisarea carti dealer
			dealer.afisareCarti(dealer.nrCarti);
			//verificarea castigatorului prin compararea punctelor
			if (dealer.sumaCarti > 21) {
				System.out.println("\n\tFelicitari!!Ati castigat!!");
				player.sold+=sumaPariataRunda;
			} else {
				if (dealer.sumaCarti < player.sumaCarti) {
					System.out.println("\n\tFelicitari!!Ati castigat!!");
					player.sold+=sumaPariataRunda;
				} else {
					System.out.println("\n\tAti pierdut!!");
					player.sold-=sumaPariataRunda;
				}
			}
			if (player.sumaCarti == dealer.sumaCarti) {
				System.out.println("\n\tRemiza!!");
			}

		} while (true);

	}
}
