import java.util.ArrayList;

public class XSeite {

	public static ArrayList<String> listEingabeX = new ArrayList<String>();
	public static ArrayList<String> listEingabeE = new ArrayList<String>();
	//public static int xSeite;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* von Johann G. : hier wird die Eingabe, die X enth�lt in die Arraylist "listEingabeX" �berf�hrt
	und die andere Seite wird in "listEingabeE" �berf�hrt */
	
	public static int xSeiteSuchen() {
		for(int i=0; i<FormelUmsteller.listEingabe1.size(); i++){
			if(FormelUmsteller.listEingabe1.get(i).equals("x") == true){
				FormelUmsteller.xSeite = 1;
			}
		}
		for(int i=0; i<FormelUmsteller.listEingabe2.size(); i++){
			if(FormelUmsteller.listEingabe2.get(i).equals("x") == true){
				FormelUmsteller.xSeite = 2;
			}
		}
		return FormelUmsteller.xSeite;
	}
	
	public static void xSeiteInEinG(){
		if (FormelUmsteller.xSeite == 1){
			for(int i=0 ; i<FormelUmsteller.listEingabe1.size() ; i++ ){
				listEingabeX.add(FormelUmsteller.listEingabe1.get(i));
			}
			for(int i=0 ; i<FormelUmsteller.listEingabe2.size() ; i++ ){
				listEingabeE.add(FormelUmsteller.listEingabe2.get(i));
			}
		}
		else if(FormelUmsteller.xSeite == 2){
			for(int i=0 ; i<FormelUmsteller.listEingabe2.size() ; i++ ){
				listEingabeX.add(FormelUmsteller.listEingabe2.get(i));
			}
			for(int i=0 ; i<FormelUmsteller.listEingabe1.size() ; i++ ){
				listEingabeE.add(FormelUmsteller.listEingabe1.get(i));
			}
		}		
	}
}