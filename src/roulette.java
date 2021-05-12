package rsim;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class roulette {

    static void aufgabec(FileOutputStream fos,int versuche){
        
        String data = "";
        Random zahl = new Random();
        int spieler=0;
        int randz=0;
        int mengenzahl=0;
        double mittelwert=0;
        for (int i = 0; i < versuche; i++) { //Durchschnitt bilden
            int localMnege=0;
            do{
                mengenzahl++;
                localMnege++;
                randz=zahl.nextInt(37);
                if(spieler==randz){
                    

                }


            }while(spieler!=randz);
        }
        mittelwert= (double)mengenzahl/(double)versuche;
        System.out.println("Summe der Mengenzahlen: " + mengenzahl);
        System.out.printf("Mittelwert fuer " + versuche+ " Treffer: %.2f", mittelwert);
        System.out.println("\n");
        data = mengenzahl + "\t" + versuche + "\n"; 
        
        try{
            
            fos.write(data.getBytes());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        //Vorbereitung fuer Exceldatei





        Random zahl = new Random(); //Zufallszahl
        int spieler = zahl.nextInt(37); //Spieler waehlt eine Zahl (via Zufallszahl)

        System.out.println("Der Spieler hat die Zahl " + spieler + " genommen.");

        boolean ende = false;

        int zaehler = 0; //zaehlt die gespielten Spiele

        System.out.println("Aufgabe 1.b");
        while (!ende) {

            zaehler++; // zaehlt jedes begonnene Spiel
            int randomzahl = zahl.nextInt(37); //Zahl fuer das RouletteSpiel
            if (randomzahl == spieler) { //Falls der Spieler die richtige Zahl spielt, dann gehe aus der Schleife.
                ende = true;
                System.out.println("Anzahl der Versuche: " + zaehler + "\n \n");
            }
        }
        System.out.println("Aufgabe 1.c");
        FileOutputStream fos;
        try{
            String zeile = "Summe Mengenzahl \t Treffer \n";
            fos = new FileOutputStream("Aufgabe1c.txt");
            fos.write(zeile.getBytes());
            aufgabec(fos,5);
            aufgabec(fos,10);
            aufgabec(fos,100);
            aufgabec(fos,1000);
            aufgabec(fos,10000);
            aufgabec(fos,100000);
            aufgabec(fos,1000000);
        }
        catch(IOException e){
            
        }
        
    }



        }


