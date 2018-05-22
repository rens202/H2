package connection;

import java.sql.Date;

public class Reiziger {
	private int reizigerid;
	private String voorletters;
	private String naam;
	private String achternaam;
	private Date gbdatum;
	private String tussenvoegsel;
	
	public Reiziger(String nm, Date gbd, String an, String vl, int ri) {
		naam = nm;
		gbdatum = gbd;
		reizigerid = ri;
		voorletters = vl;
		achternaam = an;
		
	}

	public Reiziger(int int1, String string, String string2, String string3, Date string4) {
		reizigerid = int1;
		voorletters = string;
		tussenvoegsel = string2;
		achternaam = string3;
		gbdatum = string4;
	}

	public String getNaam() {
		return naam;
	}
	
	public int getReizigerID(){
		return reizigerid;
	}
	
	public Date getgbd() {
		return gbdatum;
	}
	
	public String getTussenVoegsel() {
		return tussenvoegsel;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	
	public void setNaam(String nm) {
		naam = nm;
		
	}
	

	public void setGBdatum(Date gbd) {
		gbdatum = gbd;
	}

	public boolean equals(Object andereObject) {
		boolean resultaat = false;
		if(andereObject instanceof Reiziger) {
			Reiziger andereReiziger = (Reiziger) andereObject;
			if(this.naam.equals(andereReiziger.naam) &&
			this.gbdatum.equals(andereReiziger.gbdatum)) {
				resultaat = true;
			}
		}
		return resultaat;
	}
	
	public String toString() {
		String s = "";
		s += naam + " is geboren op: ";
		s += gbdatum;
		return s;
	}
}
