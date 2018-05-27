package dataprocessing.H3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {
	public static void main(String[] arg){
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE Adres (" + 
					"  adresID    number(10) NOT NULL, " + 
					"  postcode   varchar2(10) NOT NULL, " + 
					"  huisnummer varchar2(10) NOT NULL, " + 
					"  straat     varchar2(255) NOT NULL, " + 
					"  woonplaats varchar2(255) NOT NULL, " + 
					"  reizigerID number(10) NOT NULL, " + 
					"  PRIMARY KEY (adresID));" + 
					"CREATE TABLE OV_Chipkaart (" + 
					"  kaartNummer number(10) NOT NULL, " + 
					"  geldigTot   date NOT NULL, " + 
					"  klasse      number(1) NOT NULL, " + 
					"  saldo       number(16, 2) NOT NULL, " + 
					"  reizigerID  number(10) NOT NULL, " + 
					"  PRIMARY KEY (kaartNummer));" + 
					"CREATE TABLE Product (" + 
					"  productNummer number(10) NOT NULL, " + 
					"  productNaam   varchar2(30) NOT NULL, " + 
					"  beschrijving  varchar2(500) NOT NULL, " + 
					"  prijs         number(16, 2) NOT NULL, " + 
					"  PRIMARY KEY (productNummer));" + 
					"CREATE TABLE Reiziger (" + 
					"  reizigerID    number(10) NOT NULL, " + 
					"  voorletters   varchar2(10) NOT NULL, " + 
					"  tussenvoegsel varchar2(10), " + 
					"  achternaam    varchar2(255) NOT NULL, " + 
					"  geboortedatum  date, " + 
					"  PRIMARY KEY (reizigerID));" + 
					"CREATE TABLE OV_Chipkaart_Product (" + 
					"  ovproductID       number(10) NOT NULL, " + 
					"  kaartNummer       number(10) NOT NULL, " + 
					"  productNummer     number(10) NOT NULL, " + 
					"  reisproductStatus varchar2(10) NOT NULL, " + 
					"  lastUpdate        date NOT NULL, " + 
					"  PRIMARY KEY (ovproductID));" + 
					"ALTER TABLE OV_Chipkaart ADD CONSTRAINT FKOV_Chipkaa98923 FOREIGN KEY (reizigerID) REFERENCES Reiziger (reizigerID);" + 
					"ALTER TABLE Adres ADD CONSTRAINT FKAdres632599 FOREIGN KEY (reizigerID) REFERENCES Reiziger (reizigerID);" + 
					"ALTER TABLE OV_Chipkaart_Product ADD CONSTRAINT FKOV_Chipkaa92944 FOREIGN KEY (kaartNummer) REFERENCES OV_Chipkaart (kaartNummer);" + 
					"ALTER TABLE OV_Chipkaart_Product ADD CONSTRAINT FKOV_Chipkaa700031 FOREIGN KEY (productNummer) REFERENCES Product (productNummer);";
			
			stmt.executeUpdate(sql);
			System.out.println("Tables created and constraints added.");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
