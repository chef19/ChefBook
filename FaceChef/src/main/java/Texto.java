import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Texto {
    String nl = System.getProperty("line.separator");
    
    
    public void guardar(String texto, String dato){
        String linea = null;
        try{
            File archivo=new File(System.getProperty("user.dir")+texto+".txt");
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(dato);
            escribir.close();
        }
        catch(Exception e){
            System.out.println("Error al escribir");
        }
    }
        public void guardar(String dato){
        String linea = null;
        try{
            File archivo=new File(System.getProperty("user.dir")+"HOLA"+".txt");
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(dato);
            escribir.close();
        }
        catch(Exception e){
            System.out.println("Error al escribir");
        }
    }
    
    public int leer_ingreso(String nombre, String correo, String contraseña) throws FileNotFoundException{
        String linea = null;
        int contador=0;
        try{
            File archivo=new File(System.getProperty("user.dir")+nombre+".txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            while((linea=br.readLine())!=null){
                if (linea.equals(correo)){
                    contador++;
                }
                else if (linea.equals(contraseña)){
                    contador++;
                }
                else if (contador == 2){
                    return contador;
                }
            }     
        }
        catch(Exception e){
            System.out.println("Error al escribir2");
        }
        return contador;
    }
    
    public String perfil(String nombre, int dato) throws FileNotFoundException{
        String linea = null;
        int contador=0;
        try{
            File archivo=new File(System.getProperty("user.dir")+nombre+".txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            while((linea=br.readLine())!=null){
                if (contador == dato){
                    return linea;
                }
                contador++;
            }
        }
        catch(Exception e){
            System.out.println("Error al escribir2");
        }
        
        return null;
    }    

    public static void main(String []args) throws IOException{
        Texto t = new Texto ();
        System.out.println(t.leer_ingreso("mel","mell9413@hotmail.com","contraseña"));
    }    
    
}
