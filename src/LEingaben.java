import java.util.ArrayList;

public class LEingaben {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Diese Klasse überführt einge Eingaben der Textfelder in zwei ArrayLists (listEingabe1 und listEingabe2)
	
	public static String createString1() {
		FormelUmsteller.string1 = FormelUmsteller.eingabe1.getText();
		return FormelUmsteller.string1;
	}
	
	public static String createString2() {
		FormelUmsteller.string2 = FormelUmsteller.eingabe2.getText();
		return FormelUmsteller.string2;
	}
	
	public static char[] createArrayString1() {
		FormelUmsteller.arrayString1 = FormelUmsteller.string1.toCharArray();
		return FormelUmsteller.arrayString1;
	}
	
	public static char[] createArrayString2() {
		FormelUmsteller.arrayString2 = FormelUmsteller.string2.toCharArray();
		return FormelUmsteller.arrayString2;
	}
	
	public static ArrayList<String> createListEingabe1() {
		for(int crtPos1 = 0; crtPos1 < FormelUmsteller.arrayString1.length; crtPos1++) {
			int lastPos1 = crtPos1 - 1;
			int nextPos1 = crtPos1 + 1;
			
			if(Character.isDigit(FormelUmsteller.arrayString1[crtPos1]) == true) {
				FormelUmsteller.zahlen1.add(Character.toString(FormelUmsteller.arrayString1[crtPos1]));
				
				if(nextPos1 < FormelUmsteller.arrayString1.length) {
					
					if (lastPos1 == -1 &&
						Character.isDigit(FormelUmsteller.arrayString1[nextPos1]) == false) {
						FormelUmsteller.listEingabe1.add(FormelUmsteller.zahlen1.toString());
						FormelUmsteller.zahlen1.clear();
						continue;
					}
					else if(lastPos1 == -1 &&
							Character.isDigit(FormelUmsteller.arrayString1[nextPos1]) == true) {
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString1[lastPos1]) == false &&
							Character.isDigit(FormelUmsteller.arrayString1[nextPos1]) == false) {
						FormelUmsteller.listEingabe1.add(FormelUmsteller.zahlen1.toString());
						FormelUmsteller.zahlen1.clear();
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString1[lastPos1]) == false &&
							Character.isDigit(FormelUmsteller.arrayString1[nextPos1]) == true) {
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString1[lastPos1]) == true &&
							Character.isDigit(FormelUmsteller.arrayString1[nextPos1]) == false) {
						FormelUmsteller.listEingabe1.add(FormelUmsteller.zahlen1.toString());
						FormelUmsteller.zahlen1.clear();
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString1[lastPos1]) == true &&
							Character.isDigit(FormelUmsteller.arrayString1[nextPos1]) == true) {
						continue;
					}
				}
				
				else {
					FormelUmsteller.listEingabe1.add(FormelUmsteller.zahlen1.toString());
					FormelUmsteller.zahlen1.clear();
					continue;
				}	
			}
			
			if(Character.isDigit(FormelUmsteller.arrayString1[crtPos1]) == false) {
				FormelUmsteller.listEingabe1.add(Character.toString(FormelUmsteller.arrayString1[crtPos1]));
			}
		}
		
		for (int c1 = 0; c1 < FormelUmsteller.listEingabe1.size(); c1++) {
			if(FormelUmsteller.listEingabe1.get(c1).startsWith("[")) {
				String num = FormelUmsteller.listEingabe1.get(c1).replaceAll("\\D", "");
				FormelUmsteller.listEingabe1.set(c1, num);
			}
		}
		return FormelUmsteller.listEingabe1;
	}
	
	public static ArrayList<String> createListEingabe2() {
		for(int crtPos2 = 0; crtPos2 < FormelUmsteller.arrayString2.length; crtPos2++) {
			int lastPos2 = crtPos2 - 1;
			int nextPos2 = crtPos2 + 1;
			
			if(Character.isDigit(FormelUmsteller.arrayString2[crtPos2]) == true) {
				FormelUmsteller.zahlen2.add(Character.toString(FormelUmsteller.arrayString2[crtPos2]));
				
				if(nextPos2 < FormelUmsteller.arrayString2.length) {
					
					if (lastPos2 == -1 &&
						Character.isDigit(FormelUmsteller.arrayString2[nextPos2]) == false) {
						FormelUmsteller.listEingabe2.add(FormelUmsteller.zahlen2.toString());
						FormelUmsteller.zahlen2.clear();
						continue;
					}
					else if(lastPos2 == -1 &&
							Character.isDigit(FormelUmsteller.arrayString2[nextPos2]) == true) {
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString2[lastPos2]) == false &&
							Character.isDigit(FormelUmsteller.arrayString2[nextPos2]) == false) {
						FormelUmsteller.listEingabe2.add(FormelUmsteller.zahlen2.toString());
						FormelUmsteller.zahlen2.clear();
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString2[lastPos2]) == false &&
							Character.isDigit(FormelUmsteller.arrayString2[nextPos2]) == true) {
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString2[lastPos2]) == true &&
							Character.isDigit(FormelUmsteller.arrayString2[nextPos2]) == false) {
						FormelUmsteller.listEingabe2.add(FormelUmsteller.zahlen2.toString());
						FormelUmsteller.zahlen2.clear();
						continue;
					}
					else if(Character.isDigit(FormelUmsteller.arrayString2[lastPos2]) == true &&
							Character.isDigit(FormelUmsteller.arrayString2[nextPos2]) == true) {
						continue;
					}
				}
				
				else {
					FormelUmsteller.listEingabe2.add(FormelUmsteller.zahlen2.toString());
					FormelUmsteller.zahlen2.clear();
					continue;
				}	
			}
			
			if(Character.isDigit(FormelUmsteller.arrayString2[crtPos2]) == false) {
				FormelUmsteller.listEingabe2.add(Character.toString(FormelUmsteller.arrayString2[crtPos2]));
			}
		}
		
		for (int c1 = 0; c1 < FormelUmsteller.listEingabe2.size(); c1++) {
			if(FormelUmsteller.listEingabe2.get(c1).startsWith("[")) {
				String num = FormelUmsteller.listEingabe2.get(c1).replaceAll("\\D", "");
				FormelUmsteller.listEingabe2.set(c1, num);
			}
		}
		return FormelUmsteller.listEingabe2;
	}
	
	
	
}
