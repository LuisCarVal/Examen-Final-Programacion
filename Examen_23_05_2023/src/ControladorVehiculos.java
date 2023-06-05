import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControladorVehiculos {
    public static void GrabarAFichero(String fileName, Flota  miFlota) {

        // grabación en texto
        String data = miFlota.toString();

        FileWriter filewriter = null;
        PrintWriter printwriter = null;


        // hacemos el try catch  ya que el FileWriter devuelve una Excepcion IO
        try {
            // CSV writer
            filewriter = new FileWriter(fileName); //Abrimos el fichero
            printwriter = new PrintWriter(filewriter); //Creamos el ayudante




            printwriter.print(data);

            printwriter.flush();


            filewriter.close();


        } catch (IOException ie) {

            System.out.println(ie.getMessage());

        }




    }

    public static int leerDeFichero(String filename, Flota miFlota) {

        // lectura en texto

        String resultado = "";
        FileReader filereader = null;
        Scanner sc = null;
        int numerolineas = 0;
// Hacemos el try catch ya que Filereader devuelve la excepcion IO
        try {

            filereader = new FileReader(filename);
            sc = new Scanner(filereader);


            while (sc.hasNext()) {

                resultado += sc.nextLine() + "\n";
                numerolineas++;


            }
            filereader.close();
            sc.close();
            filereader = null;


        } catch (IOException ea) {
            System.out.println(ea.getMessage());
        }
        return numerolineas;

    }
}
