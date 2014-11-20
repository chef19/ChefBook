import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Texto {
    
    public String hola(String texto){
        String linea = null;
        try{
        File archivo=new File(texto+".txt");
        FileWriter escribir = new FileWriter(archivo,true);
        escribir.write("MONUKUMA");
        escribir.close();
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        linea=br.readLine();
        System.out.println(System.getProperty("user.dir"));
        return linea;
        }
        catch(Exception e){
        System.out.println("Error al escribir");
        }
        System.out.println("yolo");
        return linea; 
    }

    public static void main(String []args) throws IOException{
        Texto t = new Texto ();
        System.out.println(t.hola("hola"));
    }    
    
}
