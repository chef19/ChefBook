import java.io.FileNotFoundException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named (value="Ingreso")
@RequestScoped
public class Ingreso {

    @NotNull
    private String nombre;
    @NotNull
    private String correo;
    @NotNull
    private String contraseña;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    public void ingreso() throws FileNotFoundException{
        Texto archivo = new Texto ();
        if (archivo.leer_ingreso(nombre, correo, contraseña)){
            
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos incorrectos, ingrese nuevamente"));
        }
    }
}
