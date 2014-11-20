import javax.swing.JFileChooser;

public class Imagen {
    
    public String image (){
        JFileChooser dig = new JFileChooser(); 
        String file = dig.getSelectedFile().getPath();
        return file;
    }
}
