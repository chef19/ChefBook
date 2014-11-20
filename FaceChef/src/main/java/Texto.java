import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Texto {
    String nl = System.getProperty("line.separator");
    
    public String guardar(String texto, String dato){
        String linea = null;
        try{
            File archivo=new File(System.getProperty("user.dir")+texto+".txt");
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(dato);
            escribir.close();
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            linea=br.readLine();
            return linea;
        }
        catch(Exception e){
            System.out.println("Error al escribir");
        }
        return linea; 
    }

    public static void main(String []args) throws IOException{
        Texto t = new Texto ();
        t.guardar("mel", "Melvin Brenes");
    }    
    
}
