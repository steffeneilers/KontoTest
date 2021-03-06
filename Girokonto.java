/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.03.2021
 * @Steffen Eilers
 */

public class Girokonto extends Konto {
  
  // Anfang Attribute
  private double dispoLimit;
  private double kontostand;
  // Ende Attribute
  
  public Girokonto(double dispoL, String inh, String kn) {
    super(kn, inh);
    this.dispoLimit = dispoL;
    kontostand = 0;
  }

  // Anfang Methoden
  public double getDispoLimit() {
    return dispoLimit;
  }

  public double getKontostand() {
    return kontostand;
  }

  public void einzahlen(double betrag) {
    if (betrag>0) {
      kontostand=kontostand+betrag;
      System.out.println(betrag+" Euro eingezahlt");
    } else {
      System.out.println("Betr?ge unter 0 Euro sind nicht einzahlbar");
    } // end of if-else
  }

  public void auszahlen(double betrag) {
    if (betrag>0) {
      double kontostandNeu;
      kontostandNeu=kontostand-betrag;
      if ((kontostandNeu*-1)>dispoLimit) {
        System.out.println("Auszahlung w?rde das Dispo-Limit ?berschreiten und wird daher nicht ausgef?hrt");
      } else {
        kontostand=kontostandNeu;
        System.out.println(betrag+" Euro ausgezahlt");
      } // end of if-else
    } else {
      System.out.println("Betr?ge unter 0 Euro sind nicht auszahlbar");
    } // end of if-else
  }

  // Ende Methoden
} // end of Girokonto

