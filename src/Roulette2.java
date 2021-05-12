package rsim;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Roulette2 {

     public static void initLists(ArrayList s,ArrayList rot){
        s.add(2);
        s.add(4);
        s.add(6);
        s.add(8);
        s.add(10);
        s.add(11);
        s.add(13);
        s.add(15);
        s.add(17);
        s.add(20);
        s.add(22);
        s.add(24);
        s.add(26);
        s.add(28);
        s.add(29);
        s.add(31);
        s.add(33);
        s.add(35);
        rot.add(1);
        rot.add(3);
        rot.add(5);
        rot.add(7);
        rot.add(9);
        rot.add(12);
        rot.add(14);
        rot.add(16);
        rot.add(18);
        rot.add(19);
        rot.add(21);
        rot.add(23);
        rot.add(25);
        rot.add(27);
        rot.add(30);
        rot.add(32);
        rot.add(34);
        rot.add(36);

    }

    static void aufgabe2b(FileOutputStream fos, int versuche){
        Random rnd = new Random();
        int zahl=0, spieler=0;
        int mengenzahl=0;
        double mittelwert;
        ArrayList<Integer> schwarz = new ArrayList();
        ArrayList<Integer> rot = new ArrayList();
        initLists(schwarz,rot);

        //Algorythmus


            for(int i=0;i<versuche;i++) {
                int mengeLocal=0;
                do {
                    mengenzahl++;
                    mengeLocal++;
                    zahl=rnd.nextInt(37);
                    spieler=rnd.nextInt(36)+1;
                    

                }
                while (!((schwarz.contains(zahl) && schwarz.contains(spieler)) || (rot.contains(zahl) && rot.contains(spieler))));

                //Schreibe Ergebnis in Datei

            }
            mittelwert=(double)mengenzahl/(double)versuche;
            System.out.println("Summe der Mengenzahlen: " + mengenzahl + "\n");
        System.out.println("Mittelwert: " + mittelwert + "\n");
        String data = mengenzahl + "\t" + versuche + "\n";
        try{
            fos.write(data.getBytes());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }





    }

    public static void main(String[] args) {
        // Globale Variablen
        Random rnd = new Random();
        int spieler = 0;
        int zahl = 0;
        boolean ende = false;
        int durchlauf2a = 0;
        Scanner s = new Scanner(System.in);
        // Gloable Variablen //


        //Container für die Zahlen
        ArrayList<Integer> schwarz = new ArrayList();
        ArrayList<Integer> rot = new ArrayList();

        //initialisieren der Zahlen
        initLists(schwarz,rot);


        //Aufgabe 2a


        do{
            durchlauf2a++;
            zahl = rnd.nextInt(37);
            spieler = rnd.nextInt(36)+1;

            if(schwarz.contains(zahl) && schwarz.contains(spieler)){
                ende=true;
                System.out.println("Farbe Schwarz, Durchläufe: " + durchlauf2a);
                System.out.println(zahl);
            }

            else {
                if (rot.contains(zahl) && rot.contains(spieler)) {
                    ende=true;
                    System.out.println("Farbe Rot, Durchläufe: " + durchlauf2a);
                    System.out.println(zahl);
                }

            }



        }
        while(!ende);
        FileOutputStream fos;
        System.out.println("Aufgabe 2b");
        try{
        fos = new FileOutputStream("Aufgabe2b.txt");
        String zeile="Summe Mengenzahl \t Treffer \n";
        fos.write(zeile.getBytes());
        aufgabe2b(fos,5);
        aufgabe2b(fos,10);
        aufgabe2b(fos,100);
        aufgabe2b(fos,1000);
        aufgabe2b(fos,10000);
        aufgabe2b(fos,100000);    
        }
        catch(IOException e){
            
        }
        


    }
}
