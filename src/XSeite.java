import java.util.ArrayList;

public class XSeite {

	public static ArrayList<String> listEingabeX = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void xSeiteInEinG(){
		if (FormelUmsteller.xSeite == 1){
			for(int i=0 ; i<FormelUmsteller.listEingabe1.size() ; i++ ){
				listEingabeX.add(FormelUmsteller.listEingabe1.get(i));
			}
		}
		else if(FormelUmsteller.xSeite == 2){
			for(int i=0 ; i<FormelUmsteller.listEingabe2.size() ; i++ ){
				listEingabeX.add(FormelUmsteller.listEingabe2.get(i));
			}
		}		
	}
}