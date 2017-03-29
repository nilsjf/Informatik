import java.util.ArrayList;
import java.util.HashMap;

public class TeilenClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static HashMap<String, ArrayList<String>> teilen() {
		FormelUmsteller.listEingabe.get("eSeite").add(0, "[");
		FormelUmsteller.listEingabe.get("eSeite").add("]");
		FormelUmsteller.listEingabe.get("xSeite").add(0, "[");
		FormelUmsteller.listEingabe.get("xSeite").add("]");
		
		for (int i=0 ; i<FormelUmsteller.listEingabe.get("xSeite").size(); i++) {
			if (FormelUmsteller.listEingabe.get("xSeite").get(i).equals("x") == false) {
				FormelUmsteller.zsTeil.add(FormelUmsteller.listEingabe.get("xSeite").get(i));
				FormelUmsteller.listEingabe.get("xSeite").remove(i);
				i = i-1;
			}
		}
		
		FormelUmsteller.listEingabe.get("eSeite").add("/");
		
		for (int j=0 ; j < FormelUmsteller.zsTeil.size(); j++){
			FormelUmsteller.listEingabe.get("eSeite").add(FormelUmsteller.zsTeil.get(j));
		}
		
		return FormelUmsteller.listEingabe;
	}
	
}
