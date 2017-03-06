import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FormelUmsteller extends JFrame {

	public static JPanel contentPane;
	public static JTextField eingabe1;
	public static JLabel lbl;
	public static JTextField eingabe2;
	public static JButton btnStart;
	public static JLabel lblAusgabe;
	
	public static String string1;
	public static String string2;
	
	public static char[] arrayString1;
	public static char[] arrayString2;
	
	public static int xSeite = 0;
    public static int xPos = 0;
	
	public static ArrayList<String> zahlen1 = new ArrayList<String>();
	public static ArrayList<String> zahlen2 = new ArrayList<String>();
	
	public static ArrayList<String> zs1 = new ArrayList<String>();
	public static ArrayList<String> zs2 = new ArrayList<String>();
	
	public static ArrayList<Integer> sumPos1 = new ArrayList<Integer>();
	public static ArrayList<Integer> sumPos2 = new ArrayList<Integer>();

	public static ArrayList<String> listEingabe1 = new ArrayList<String>();
	public static ArrayList<String> listEingabe2 = new ArrayList<String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormelUmsteller frame = new FormelUmsteller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				getEingabe();
			}
		});
	}

	public FormelUmsteller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eingabe1 = new JTextField();
		eingabe1.setBounds(27, 73, 230, 20);
		contentPane.add(eingabe1);
		eingabe1.setColumns(10);
		
		lbl = new JLabel("=");
		lbl.setBounds(272, 76, 17, 14);
		contentPane.add(lbl);
		
		eingabe2 = new JTextField();
		eingabe2.setBounds(299, 73, 245, 20);
		contentPane.add(eingabe2);
		eingabe2.setColumns(10);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(230, 146, 89, 23);
		contentPane.add(btnStart);
		
		lblAusgabe = new JLabel("");
		lblAusgabe.setForeground(Color.BLACK);
		lblAusgabe.setBackground(Color.WHITE);
		lblAusgabe.setBounds(91, 207, 373, 51);
		contentPane.add(lblAusgabe);
	}
	
	public static void getEingabe() {
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createString1();
				createString2();
				createArrayString1();
				createArrayString2();
				createListEingabe1();
				createListEingabe2();
				plusAdden1();
				plusAdden2();
				xSeiteSuchen();
				//xPosSuchen();
				summandenUmsteller();
				druck();
				
			}
		});
	}
	
	public static String createString1() {
		string1 = eingabe1.getText();
		return string1;
	}
	
	public static String createString2() {
		string2 = eingabe2.getText();
		return string2;
	}
	
	public static char[] createArrayString1() {
		arrayString1 = string1.toCharArray();
		return arrayString1;
	}
	
	public static char[] createArrayString2() {
		arrayString2 = string2.toCharArray();
		return arrayString2;
	}
	
	public static ArrayList<String> createListEingabe1() {
		for(int crtPos1 = 0; crtPos1 < arrayString1.length; crtPos1++) {
			int lastPos1 = crtPos1 - 1;
			int nextPos1 = crtPos1 + 1;
			
			if(Character.isDigit(arrayString1[crtPos1]) == true) {
				zahlen1.add(Character.toString(arrayString1[crtPos1]));
				
				if(nextPos1 < arrayString1.length) {
					
					if (lastPos1 == -1 &&
						Character.isDigit(arrayString1[nextPos1]) == false) {
						listEingabe1.add(zahlen1.toString());
						zahlen1.clear();
						continue;
					}
					else if(lastPos1 == -1 &&
							Character.isDigit(arrayString1[nextPos1]) == true) {
						continue;
					}
					else if(Character.isDigit(arrayString1[lastPos1]) == false &&
							Character.isDigit(arrayString1[nextPos1]) == false) {
						listEingabe1.add(zahlen1.toString());
						zahlen1.clear();
						continue;
					}
					else if(Character.isDigit(arrayString1[lastPos1]) == false &&
							Character.isDigit(arrayString1[nextPos1]) == true) {
						continue;
					}
					else if(Character.isDigit(arrayString1[lastPos1]) == true &&
							Character.isDigit(arrayString1[nextPos1]) == false) {
						listEingabe1.add(zahlen1.toString());
						zahlen1.clear();
						continue;
					}
					else if(Character.isDigit(arrayString1[lastPos1]) == true &&
							Character.isDigit(arrayString1[nextPos1]) == true) {
						continue;
					}
				}
				
				else {
					listEingabe1.add(zahlen1.toString());
					zahlen1.clear();
					continue;
				}	
			}
			
			if(Character.isDigit(arrayString1[crtPos1]) == false) {
				listEingabe1.add(Character.toString(arrayString1[crtPos1]));
			}
		}
		
		for (int c1 = 0; c1 < listEingabe1.size(); c1++) {
			if(listEingabe1.get(c1).startsWith("[")) {
				String num = listEingabe1.get(c1).replaceAll("\\D", "");
				listEingabe1.set(c1, num);
			}
		}
		return listEingabe1;
	}
	
	public static ArrayList<String> createListEingabe2() {
		for(int crtPos2 = 0; crtPos2 < arrayString2.length; crtPos2++) {
			int lastPos2 = crtPos2 - 1;
			int nextPos2 = crtPos2 + 1;
			
			if(Character.isDigit(arrayString2[crtPos2]) == true) {
				zahlen2.add(Character.toString(arrayString2[crtPos2]));
				
				if(nextPos2 < arrayString2.length) {
					
					if (lastPos2 == -1 &&
						Character.isDigit(arrayString2[nextPos2]) == false) {
						listEingabe2.add(zahlen2.toString());
						zahlen2.clear();
						continue;
					}
					else if(lastPos2 == -1 &&
							Character.isDigit(arrayString2[nextPos2]) == true) {
						continue;
					}
					else if(Character.isDigit(arrayString2[lastPos2]) == false &&
							Character.isDigit(arrayString2[nextPos2]) == false) {
						listEingabe2.add(zahlen2.toString());
						zahlen2.clear();
						continue;
					}
					else if(Character.isDigit(arrayString2[lastPos2]) == false &&
							Character.isDigit(arrayString2[nextPos2]) == true) {
						continue;
					}
					else if(Character.isDigit(arrayString2[lastPos2]) == true &&
							Character.isDigit(arrayString2[nextPos2]) == false) {
						listEingabe2.add(zahlen2.toString());
						zahlen2.clear();
						continue;
					}
					else if(Character.isDigit(arrayString2[lastPos2]) == true &&
							Character.isDigit(arrayString2[nextPos2]) == true) {
						continue;
					}
				}
				
				else {
					listEingabe2.add(zahlen2.toString());
					zahlen2.clear();
					continue;
				}	
			}
			
			if(Character.isDigit(arrayString2[crtPos2]) == false) {
				listEingabe2.add(Character.toString(arrayString2[crtPos2]));
			}
		}
		
		for (int c1 = 0; c1 < listEingabe2.size(); c1++) {
			if(listEingabe2.get(c1).startsWith("[")) {
				String num = listEingabe2.get(c1).replaceAll("\\D", "");
				listEingabe2.set(c1, num);
			}
		}
		return listEingabe2;
	}
	
	//Hier wird die Seite wo x ist herausgefunden und in xSeite ausgegeben
	public static int xSeiteSuchen() {
		for(int i=0; i<listEingabe1.size(); i++){
			if(listEingabe1.get(i).equals("x") == true){
				xSeite = 1;
			}
		}
		for(int i=0; i<listEingabe2.size(); i++){
			if(listEingabe2.get(i).equals("x") == true){
				xSeite = 2;
			}
			/*else{
				System.out.println("Kein x vorhanden, bitte x hinzufügen");
			}*/
		}
		
		return xSeite;
		/*int xSeite=0;
		//Das macht Johann
		/*public static int xSeite = 0;
		for (int i...{
		    if (listEingabe1.get(i).equals("x")mm
		        xSeite = 1;
		}
		for (int i...{
		    if (listEingabe2.get(i).equals("x")
		        xSeite = 2;
		}*/
	}
	
	public static int xPosSuchen() {  
	    if(xSeite == 1){
	    	for(int i=0; i<listEingabe1.size(); i++){
				if(listEingabe1.get(i).equals("x")){
					xPos = i;
				}
			}
		}
	    if (xSeite == 2) {
            for (int i=0; i<listEingabe2.size(); i++) {
                if (listEingabe2.get(i).equals("x")){
                    xPos = i;
                }
            }
	    }
	    return xPos ;
	    
	}
	
	public static ArrayList<String> plusAdden1() {
		if(listEingabe1.get(0).equals("+") == false && listEingabe1.get(0).equals("-") == false){
			listEingabe1.add(0, "+");
		}
		return listEingabe1;
	}
	
	public static ArrayList<String> plusAdden2() {
		if(listEingabe2.get(0).equals("+") == false && listEingabe2.get(0).equals("-") == false){
			listEingabe2.add(0, "+");
		}
		return listEingabe2;
	}
	
	public static void summandenUmsteller() {
		if(xSeite == 1) {
			int lastPos = listEingabe1.size()-1;
			for(int i = 0; i < listEingabe1.size(); i++) {
				
				if(listEingabe1.get(i).equals("+") || listEingabe1.get(i).equals("-")) {
					zs1.add(listEingabe1.get(i));
					sumPos1.add(i);
					int x = i+1;
						
					if(listEingabe1.get(x).equals("+") == false && listEingabe1.get(x).equals("-") == false) {
						int k = x;
						while(listEingabe1.get(k).equals("+") == false && listEingabe1.get(k).equals("-") == false) {
							zs1.add(listEingabe1.get(k));
							sumPos1.add(k);
							if(k != lastPos) {
								k++;
							}
							else {
								break;
							}
						}
					}
					
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
						listEingabe2.add(zs1.get(d).toString());
					}
					
					for(int l = 0; l < sumPos1.size(); l++) {
						listEingabe1.set(sumPos1.get(l), " ");
					}
					
					zs1.clear();
					
					for (int c4 = 0; c4 < listEingabe1.size(); c4++) {
						if(listEingabe1.get(c4).equals(" ")) {
							listEingabe1.remove(c4);
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
		}
	}	
	
	public static void druck() {
		for (int i = 0; i < listEingabe1.size(); i++)
			System.out.println(listEingabe1.get(i));
		System.out.println("===");
		for (int j = 0; j < listEingabe2.size(); j++)
			System.out.println(listEingabe2.get(j));
		System.out.println("----------------");
	}
}