package dataprocessing.H3;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] arg) {	
		Scanner reader = new Scanner(System.in);
		List<Reiziger> reizigerList = Reiziger.update();
		
		while(true) {	
			System.out.println("Wat wil je doen?\n"
					+ "1: Reiziger toevoegen\n"
					+ "2: Reiziger aanpassen\n"
					+ "3: Reiziger verwijderen\n"
					+ "4: Alle reizigers tonen\n"
					+ "5: Alle reizigers verwijderen\n"
					+ "6: Stoppen");
			int keuze = reader.nextInt();
			
			if(keuze == 1) {
				System.out.println("Wat zijn je voorletters?");
				String voorletters = reader.next();
				System.out.println("Wat is je tussenvoegsel?");
				String tussenvoegsel = reader.next();
				System.out.println("Wat is je achternaam?");
				String achternaam = reader.next();
				System.out.println("Wat is je geboortedag?");
				int gbDag = reader.nextInt();
				System.out.println("Wat is je geboortemaand?");
				int gbMaand = reader.nextInt();
				System.out.println("Wat is je geboortejaar?");
				int gbJaar = reader.nextInt();
				
				reizigerList.add(new Reiziger(voorletters,tussenvoegsel,achternaam,Date.valueOf(LocalDate.of(gbJaar,gbMaand,gbDag))));
				reizigerList.get(Reiziger.index-1).insert();
				
			}else if(keuze == 2) {
				System.out.println("Lijst met reizigers:\n");
				System.out.println(Reiziger.fetchData());
				System.out.println("Noem het reizigersID van de reiziger die je wil aanpassen.");
				Reiziger tempReiziger = reizigerList.get(reader.nextInt());
				System.out.println("Waarnaar moeten de voorletters veranderd worden?");
				tempReiziger.changeVoorletters(reader.next());
				
			}else if(keuze == 3) {
				System.out.println("Lijst met reizigers:\n");
				System.out.println(Reiziger.fetchData());
				System.out.println("Noem het reizigersID van de reiziger die je wil verwijderen.");
				reizigerList.get(reader.nextInt()).delete();
				
			}else if(keuze == 4) {
				System.out.println(Reiziger.fetchData());
				
			}else if(keuze == 5) {
				Reiziger.clearTable();
				
			}else if(keuze == 6) {
				break;
			}
		}
		
		reader.close();
		System.out.println("Program terminated.");
	}
}
