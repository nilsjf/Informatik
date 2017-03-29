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
import java.util.HashMap;

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
	public static ArrayList<String> zsTeil = new ArrayList<String>();
	
	public static double zsNenner;
	public static double zsZähler;
	public static double zsDivision;
	
	public static ArrayList<Integer> sumPos1 = new ArrayList<Integer>();
	public static ArrayList<Integer> sumPos2 = new ArrayList<Integer>();

	public static ArrayList<String> listEingabe1 = new ArrayList<String>();
	public static ArrayList<String> listEingabe2 = new ArrayList<String>();
	
	public static HashMap<String, ArrayList<String>> listEingabeHM = new HashMap<String, ArrayList<String>>();
	
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
				LEingaben.createString1();
				LEingaben.createString2();
				LEingaben.createArrayString1();
				LEingaben.createArrayString2();
				LEingaben.createListEingabe1();
				LEingaben.createListEingabe2();
				PlusAdden.plusAdden1();
				PlusAdden.plusAdden2();
				XSeite.xSeiteSuchen();
				XSeite.xSeiteInEinG();
				SUClass.summandenUmsteller();
				TeilenClass.teilen();
				smdVereinfachen();
				auflösen();
				druck();
				
			}
		});
	}
	
	
	public static HashMap<String, ArrayList<String>> teilen() {
		listEingabeHM.get("eSeite").add(0, "[");
		listEingabeHM.get("eSeite").add("]");
		listEingabeHM.get("xSeite").add(0, "[");
		listEingabeHM.get("xSeite").add("]");
		
		for (int i=0 ; i<listEingabeHM.get("xSeite").size(); i++) {
			if (listEingabeHM.get("xSeite").get(i).equals("x") == false) {
				zsTeil.add(listEingabeHM.get("xSeite").get(i));
				listEingabeHM.get("xSeite").remove(i);
				i = i-1;
			}
		}
		
		listEingabeHM.get("eSeite").add("/");
		
		for (int j=0 ; j < zsTeil.size(); j++){
			listEingabeHM.get("eSeite").add(zsTeil.get(j));
		}
		
		return listEingabeHM;
	}
	
	public static HashMap<String, ArrayList<String>> smdVereinfachen() {//immernoch nicht gut
		int anzahlZahlen = 0;
		for(int i = listEingabeHM.get("eSeite").size()-1; i >= 0; i--) {
			if(listEingabeHM.get("eSeite").get(i).matches("\\d+")) {
				anzahlZahlen++;
		}
		if (anzahlZahlen>1){//noch nicht funktionsfähig!
			double faktor = 1;
			for(int j = listEingabeHM.get("eSeite").size()-1; j > -1; j--) {
				if(listEingabeHM.get("eSeite").get(j).matches("\\d+") && listEingabeHM.get("eSeite").get(j-1).matches("/") == false) {
					faktor = Double.parseDouble(listEingabeHM.get("eSeite").get(j));
					if(listEingabeHM.get("eSeite").get(j-1).matches("/")){
						faktor = 1/faktor;
					}
					listEingabeHM.get("eSeite").remove(j);
					j--;
					while (j>-1){
						if(listEingabeHM.get("eSeite").get(j).matches("\\d+") && listEingabeHM.get("eSeite").get(j-1).matches("/") == false) {
							faktor = faktor*Double.parseDouble(listEingabeHM.get("eSeite").get(j));
							if(listEingabeHM.get("eSeite").get(j-1).matches("/")){
								faktor = faktor*1/Double.parseDouble(listEingabeHM.get("eSeite").get(j));
							}
							listEingabeHM.get("eSeite").remove(j);
						}
						if(listEingabeHM.get("eSeite").get(j).equals("[")) {
				   			break;
				   		}
						j--;
					}					
				}
				String faktorString = String.valueOf(faktor);
				listEingabeHM.get("eSeite").add(faktorString);
			}		
		}
		}
		return listEingabeHM;
	}
	
	
	public static HashMap<String, ArrayList<String>> auflösen() {
		for(int i = listEingabeHM.get("eSeite").size()-1; i > -1; i--) {//
	   		if(listEingabeHM.get("eSeite").get(i).contains("1") || listEingabeHM.get("eSeite").get(i).contains("2") || listEingabeHM.get("eSeite").get(i).contains("3") || listEingabeHM.get("eSeite").get(i).contains("4") || listEingabeHM.get("eSeite").get(i).contains("5") || listEingabeHM.get("eSeite").get(i).contains("6") || listEingabeHM.get("eSeite").get(i).contains("7") || listEingabeHM.get("eSeite").get(i).contains("8") || listEingabeHM.get("eSeite").get(i).contains("9") || listEingabeHM.get("eSeite").get(i).contains("0")) {
	   			zsNenner = Double.parseDouble(listEingabeHM.get("eSeite").get(i));
	   			listEingabeHM.get("eSeite").remove(i);
	   		}
	   		else if(listEingabeHM.get("eSeite").get(i).equals("[")) {
	   			break;
	   		}
	   	}
		boolean summandGeteilt = false;		
		for(int j = 0; j < listEingabeHM.get("eSeite").size(); j++) {
			if (listEingabeHM.get("eSeite").get(j).equals("+") || listEingabeHM.get("eSeite").get(j).equals("-")) {
				summandGeteilt = true;
			}
			else if(listEingabeHM.get("eSeite").get(j).contains("1") || listEingabeHM.get("eSeite").get(j).contains("2") || listEingabeHM.get("eSeite").get(j).contains("3") || listEingabeHM.get("eSeite").get(j).contains("4") || listEingabeHM.get("eSeite").get(j).contains("5") || listEingabeHM.get("eSeite").get(j).contains("6") || listEingabeHM.get("eSeite").get(j).contains("7") || listEingabeHM.get("eSeite").get(j).contains("8") || listEingabeHM.get("eSeite").get(j).contains("9") || listEingabeHM.get("eSeite").get(j).contains("0") && summandGeteilt == true) {
				zsZähler = Double.parseDouble(listEingabeHM.get("eSeite").get(j));
				zsDivision = zsZähler/zsNenner;
				listEingabeHM.get("eSeite").set(j, Double.toString(zsDivision));
				summandGeteilt = false;
			}
		}
	   	 
	   	return listEingabeHM;
	}


	public static void druck() {
		for (int i = 0; i < listEingabeHM.get("xSeite").size(); i++)
			System.out.println(listEingabeHM.get("xSeite").get(i));
		System.out.println("===");
		for (int j = 0; j < listEingabeHM.get("eSeite").size(); j++)
			System.out.println(listEingabeHM.get("eSeite").get(j));
		System.out.println("----------------");
	}
}