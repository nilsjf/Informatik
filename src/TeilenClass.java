import java.util.ArrayList;
import java.util.HashMap;

public class TeilenClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static HashMap<String, ArrayList<String>> teilen() {
		FormelUmsteller.listEingabeHM.get("eSeite").add(0, "[");
		FormelUmsteller.listEingabeHM.get("eSeite").add("]");
		FormelUmsteller.listEingabeHM.get("xSeite").add(0, "[");
		FormelUmsteller.listEingabeHM.get("xSeite").add("]");
		
		for (int i=0 ; i<FormelUmsteller.listEingabeHM.get("xSeite").size(); i++) {
			if (FormelUmsteller.listEingabeHM.get("xSeite").get(i).equals("x") == false) {
				FormelUmsteller.zsTeil.add(FormelUmsteller.listEingabeHM.get("xSeite").get(i));
				FormelUmsteller.listEingabeHM.get("xSeite").remove(i);
				i = i-1;
			}
		}
		
		FormelUmsteller.listEingabeHM.get("eSeite").add("/");
		
		for (int j=0 ; j < FormelUmsteller.zsTeil.size(); j++){
			FormelUmsteller.listEingabeHM.get("eSeite").add(FormelUmsteller.zsTeil.get(j));
		}
		
		return FormelUmsteller.listEingabeHM;
	}
	
}
