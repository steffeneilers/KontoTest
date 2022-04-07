import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.03.2021
 * @Steffen Eilers 
 */

public class KontoGUI extends JFrame {
  // Anfang Attribute
  private JLabel lAktuellerKontostand = new JLabel();
  private JTextField kontostandFeld = new JTextField();
  private JLabel lEinzahlenEuro = new JLabel();
  private JButton bBestaeEin = new JButton();
  private JLabel lAuszahlenEuro = new JLabel();
  private JButton bBestaeAus = new JButton();
  private JTextField ausgabeFeld = new JTextField();
  private JLabel lAktuelleAusgabe = new JLabel();
  double betrag;
  Girokonto MmKonto = new Girokonto(800,"Max Mueller","1234");
  private JTextField einzaFeld = new JTextField();
  private JTextField auszaFeld = new JTextField();
  // Ende Attribute
  
  public KontoGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 457; 
    int frameHeight = 318;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("KontoGUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lAktuellerKontostand.setBounds(48, 35, 214, 20);
    lAktuellerKontostand.setText("Aktueller Kontostand:");
    lAktuellerKontostand.setHorizontalTextPosition(SwingConstants.CENTER);
    lAktuellerKontostand.setVerticalAlignment(SwingConstants.CENTER);
    lAktuellerKontostand.setHorizontalAlignment(SwingConstants.LEFT);
    cp.add(lAktuellerKontostand);
    kontostandFeld.setBounds(280, 35, 150, 20);
    kontostandFeld.setEditable(false);
    cp.add(kontostandFeld);
    lEinzahlenEuro.setBounds(49, 84, 126, 20);
    lEinzahlenEuro.setText("Einzahlen Euro:");
    cp.add(lEinzahlenEuro);
    bBestaeEin.setBounds(336, 82, 75, 25);
    bBestaeEin.setText("Bestätigen");
    bBestaeEin.setMargin(new Insets(2, 2, 2, 2));
    bBestaeEin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBestaeEin_ActionPerformed(evt);
      }
    });
    cp.add(bBestaeEin);
    lAuszahlenEuro.setBounds(46, 135, 110, 20);
    lAuszahlenEuro.setText("Auszahlen Euro:");
    cp.add(lAuszahlenEuro);
    bBestaeAus.setBounds(337, 135, 75, 25);
    bBestaeAus.setText("Bestätigen");
    bBestaeAus.setMargin(new Insets(2, 2, 2, 2));
    bBestaeAus.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBestaeAus_ActionPerformed(evt);
      }
    });
    cp.add(bBestaeAus);
    
    ausgabeFeld.setBounds(41, 227, 374, 20);
    ausgabeFeld.setEditable(false);
    ausgabeFeld.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(ausgabeFeld);
    lAktuelleAusgabe.setBounds(153, 185, 142, 20);
    lAktuelleAusgabe.setText("Aktuelle Ausgabe:");
    lAktuelleAusgabe.setHorizontalTextPosition(SwingConstants.CENTER);
    lAktuelleAusgabe.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lAktuelleAusgabe);
    aktKontostand();
    einzaFeld.setBounds(206, 76, 94, 36);
    einzaFeld.setHorizontalAlignment(SwingConstants.CENTER);
    einzaFeld.setFont(new Font("Dialog", Font.PLAIN, 14));
    cp.add(einzaFeld);
    auszaFeld.setBounds(206, 122, 94, 36);
    auszaFeld.setHorizontalAlignment(SwingConstants.CENTER);
    auszaFeld.setFont(new Font("Dialog", Font.PLAIN, 14));
    cp.add(auszaFeld);
    ausgabeFeld.setForeground(Color.RED);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public KontoGUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new KontoGUI();
  } // end of main
  
  public void bBestaeEin_ActionPerformed(ActionEvent evt) {
    double terrible = Double.parseDouble(einzaFeld.getText()); // diese Zeile wäre obsolet, wenn man zur Eingabe von numerischen Inhalten
    if (terrible>0) {
      MmKonto.einzahlen(terrible);
      ausgabeFeld.setText(terrible+" Euro eingezahlt");
    } else {
      ausgabeFeld.setText("Beträge unter 0 Euro sind nicht einzahlbar");
    } // end of if-else
    einzaFeld.setText("0");
    auszaFeld.setText("0");
    aktKontostand();
  } // end of bBestaeEin_ActionPerformed

  public void bBestaeAus_ActionPerformed(ActionEvent evt) {
    double terrible = Double.parseDouble(auszaFeld.getText()); // siehe Zeile 107
    double kontostandNeu;
    if (terrible>0) {
      kontostandNeu=MmKonto.getKontostand()-terrible;
      if ((kontostandNeu*-1)>MmKonto.getDispoLimit()) {
        ausgabeFeld.setText("Auszahlung würde das Dispo-Limit überschreiten und wird daher nicht ausgeführt");
      } else {
        MmKonto.auszahlen(terrible);
        ausgabeFeld.setText(terrible+" Euro ausgezahlt");
      } // end of if-else
    } else {
      ausgabeFeld.setText("Beträge unter 0 Euro sind nicht auszahlbar");
    } // end of if-else
    aktKontostand();
    einzaFeld.setText("0");
    auszaFeld.setText("0");
  } // end of bBestaeAus_ActionPerformed 
  public void aktKontostand() {
    kontostandFeld.setText(String.valueOf(MmKonto.getKontostand()));
  }
  // Ende Methoden
} // end of class KontoGUI

