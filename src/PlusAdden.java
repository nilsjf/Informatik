import java.util.ArrayList;
//von Johann in die Klasse überführt und kommentiert, von Paul geschrieben
public class PlusAdden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * hier werden + Zeichen vor die Gleichungsseiten gestellt für eine einfachere Programmierung beim Summenumstellen
	 */
	public static ArrayList<String> plusAdden1() {
		if(FormelUmsteller.listEingabe1.get(0).equals("+") == false && FormelUmsteller.listEingabe1.get(0).equals("-") == false){
			FormelUmsteller.listEingabe1.add(0, "+");
		}
		return FormelUmsteller.listEingabe1;
	}
	
	public static ArrayList<String> plusAdden2() {
		if(FormelUmsteller.listEingabe2.get(0).equals("+") == false && FormelUmsteller.listEingabe2.get(0).equals("-") == false){
			FormelUmsteller.listEingabe2.add(0, "+");
		}
		return FormelUmsteller.listEingabe2;
	}
	
	
	
	
}
