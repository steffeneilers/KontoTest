import java.util.Scanner;
public class KontoTest{
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Girokonto MmKonto = new Girokonto(800,"Max Mueller","1234");
    double betrag;
    boolean istBeendet = true;
    while (istBeendet) { 
      System.out.println("Einzahlen [E], Auszahlen [A], Beenden [B]:");
      String auswahl = input.next();
        switch (auswahl){
        case"A":
          System.out.println("Auswahl Auszahlen bestätigt. Geben sie den Auszuzahlenden Betrag ein:");
          betrag = input.nextDouble();
          MmKonto.auszahlen(betrag);
          break;
        case"E":
          System.out.println("Auswahl Einzahlen bestätigt. Geben sie den Einzuzahlenden Betrag ein:");
          betrag = input.nextDouble();
          MmKonto.einzahlen(betrag);
          break;
        case"B":
          istBeendet=false;
          System.out.println("Programmende");
          break;
        } // end of switch
    } // end of while
  }
}
