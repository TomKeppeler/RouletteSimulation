import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import rouletteprojekt.Helfer;

/**
 *
 * @author Tom Keppeler
 */
public class roulette3 {
    
        public static void aufgabe3(FileOutputStream fos, int wdh)throws Exception{
        Random r = new Random();
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        ArrayList<Integer> al3 = new ArrayList<Integer>();
        int rand = 0;            //Random Zahl der Roulettkugel 
        int countDOPPELT = 0;     //Anzahl der Doppelten Zahlen
        double zahl = 0;          //Addierte anzahl gefallende Zahlen bei mehreren Simulatioen. 
        //Diese muss nachher durch die Wiederholungen geteilt werden um den Mittelwert zu bekommen. //Addierte anzahl gefallende Zahlen bei mehreren Simulatioen. 
        //Diese muss nachher durch die Wiederholungen geteilt werden um den Mittelwert zu bekommen.
        
        for (int index = 0; index <= wdh; index++) {
            zahl += al.size();
            if (al.size() > 0) {
                al3.add(al.size());
            }
            al2.addAll(al);
            al.clear();
            for (int i = 0; i < 37; i++) { //37 Runen Werden Simuliert 
                rand = r.nextInt(37);
                if (al.contains(rand)) {
                    countDOPPELT++;
                } else {
                    al.add(rand);
                }
            }
        }
        String out = String.format("gefal.Zahl \tWdh. \tDurchschnitt_Wdh\n");
        out += String.format("%.2f\t%d\t%.2f\n", zahl, wdh, (zahl / wdh));
        try{
            fos.write(out.getBytes());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
        
        
        
    public static void main(String[] args) throws Exception {
      
        System.out.print("PROJEKT RAK: RoulettSimulator;:K,K,H,V\n");
        try{
        FileOutputStream fos = new FileOutputStream("FILE_KKHV_.txt");
        aufgabe3(fos,5);
        aufgabe3(fos,10);
        aufgabe3(fos,100);
        aufgabe3(fos,1000);
        aufgabe3(fos,10000);
        aufgabe3(fos,100000);
        }catch(Exception e){
            System.out.println(e.getMessage());       
                }
        System.out.println("File Created");
    }
}