import java.util.ArrayList;
import java.util.HashMap;
// Die Methode wurde von Johann in die Klasse überführt und KOMMENTIERT
public class SUClass {
	//Variablen
	public static ArrayList<String> zs1 = new ArrayList<String>() ;
	public static ArrayList<Integer> sumPos1 = new ArrayList<Integer>();
	public static HashMap<String, ArrayList<String>> listEingabe = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/*
	 * Diese selbst geschriebene Methode wurde hauptsächlich von Nils und Paul entworfen unter Anfänglicher Hilfe von Johann.
	 * Diese Methode stellt stellt die Gleichung nach dem Summanden um in dem X enthalten ist, das heißt alle anderen Summanden
	 * der Seite wo X Enthalten ist werden mathematisch korrekt auf die andere Seite umgestellt.
	*/
	public static HashMap<String, ArrayList<String>> summandenUmsteller() {
		int lastPos = XSeite.listEingabeX.size()-1; //listEingabeX wird in der Klasse XSeite erstellt und bearbeitet und beschrieben
		
		for(int i = 0; i < XSeite.listEingabeX.size(); i++) {
			
			if(XSeite.listEingabeX.get(i).equals("+") || XSeite.listEingabeX.get(i).equals("-")) {
				//zs1 ist eine ArrayList in der wir die Daten aus listEingabeX bearbeiten
				zs1.add(XSeite.listEingabeX.get(i));
				//sumPos1 enthält die Positionen von den +Zeichen und -Zeichen
				sumPos1.add(i);
				//hier werden jetzt alle Weiteren Zeichen des Summanden in zs1 überführt
				int k = i+1;
				while(XSeite.listEingabeX.get(k).equals("+") == false && XSeite.listEingabeX.get(k).equals("-") == false) {
					zs1.add(XSeite.listEingabeX.get(k));
					sumPos1.add(k);
					if(k != lastPos) {
						k++;
					}
					else {
						break;
					}
				}
				//hier wird überprüft ob in dem Summanden x Enthalten ist damit wir nicht den Summanden mit x auf die Aufdie andere Seite stellen
				if(zs1.contains("x")) {
					zs1.clear();
					sumPos1.clear();
					continue;
				}
				
				if(zs1.get(0).equals("+")) {
					zs1.set(0, "-");
				}
				else if(zs1.get(0).equals("-")) {
					zs1.set(0, "+");
				}
				
				for(int d = 0; d < zs1.size(); d++){
					XSeite.listEingabeE.add(zs1.get(d).toString());
				}
				
				for(int l = 0; l < sumPos1.size(); l++) {
					XSeite.listEingabeX.set(sumPos1.get(l), " ");
				}
				
				zs1.clear();
				
				for (int c4 = 0; c4 < XSeite.listEingabeX.size(); c4++) {
					if(XSeite.listEingabeX.get(c4).equals(" ")) {
						XSeite.listEingabeX.remove(c4);
						lastPos = lastPos-1;
						c4 = c4-1;
					}
				}
				
				i = i-1;
				continue;
			}
			else {
				continue;
			}
		}
		listEingabe.put("xSeite", XSeite.listEingabeX);
		listEingabe.put("eSeite", XSeite.listEingabeE);
		return listEingabe;
	}
	
	
	
	
}
