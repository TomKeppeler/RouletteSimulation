import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author Tom Keppeler
 */
public class Helfer {
    double zahl, wdh, wdhdurchschnitt;
    ArrayList<Integer> als = new ArrayList<Integer>();
    public void fileprintHelferWDH(double zahl,double wdh,double wdhdurchschnitt, ArrayList<Integer> als, ArrayList<Integer> al3) throws IOException {
        try {
            PrintWriter op = new PrintWriter(new FileOutputStream("FILE_KKHV_.txt"));
            
            String out = String.format("\n");
//  String out = String.format("gefallene Zahlen pro 37 runden |       Rundendurchlaeufe     |   Durchschnitt mit Wdh.|\n");
            out += String.format("%25.2f      |%24.2f     |%20.2f    |\n", zahl, wdh, (zahl / wdh));    //Alle wichtigen Infos.
            if (wdh >= 1) {
//                System.out.println("Wegen zuvielen Wiederholungen werden die gefallenden Zahlen in der Textdatei NICHT Erzeugt!");
//                out += String.format("\nWegen zuvielen Wiederholungen wurden die gefallenden Zahlen NICHT Erzeugt!\n");
            } else {
                for (Integer i3 : al3) {
                    for (int i = 0; i < i3; i++) {
                        out += String.format("%d. %d\n", i + 1, als.get(i));
                    }
                }
            }

            op.write(out);
            op.flush();
            op.close();
            System.out.println("FILE HAS CREATED!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FILE NOT CREATED!ERROR:FnC");
        }
    }
    public void fileprintHelfer(double zahl,double wdh,double wdhdurchschnitt, ArrayList<Integer> als, ArrayList<Integer> al3) throws IOException {
        try {
            PrintWriter op = new PrintWriter(new FileOutputStream("FILE_KKHV_.txt"));
            String out = String.format("gefallene Zahlen pro 37 runden |       Rundendurchlaeufe     |   Durchschnitt mit Wdh.|\n");
            out += String.format("%25.2f      |%24.2f     |%20.2f    |\n", zahl, wdh, (zahl / wdh));    //Alle wichtigen Infos.
            out += String.format("\nAlle Zahlen die pro 37 runden Gefallen sind.\n");
            if (wdh > 1000) {
                System.out.println("Wegen zuvielen Wiederholungen werden die gefallenden Zahlen in der Textdatei NICHT Erzeugt!");
                out += String.format("\nWegen zuvielen Wiederholungen wurden die gefallenden Zahlen NICHT Erzeugt!\n");
            } else {
                for (Integer i3 : al3) {
                    for (int i = 0; i < i3; i++) {
                        out += String.format("%d. %d\n", i + 1, als.get(i));
                    }
                }
            }

            op.write(out);
            op.flush();
            op.close();
            System.out.println("FILE HAS CREATED!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FILE NOT CREATED!ERROR:FnC");
        }
    }

}