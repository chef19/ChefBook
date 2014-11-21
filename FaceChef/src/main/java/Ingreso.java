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
    private String nombre=null;
    @NotNull
    private String correo;
    @NotNull
    private String contraseña;
    private String edad;
    private String carrera;
    private String año;
    private String direccion;
    private String telefono;

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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() throws FileNotFoundException {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String perfil(int a) throws FileNotFoundException{
        Texto archivo = new Texto ();
        if (nombre != null){
            return archivo.perfil(nombre, a);
        }
        return null;
    }
    
    public String ingreso() throws FileNotFoundException{
        Texto archivo = new Texto ();
        if (archivo.leer_ingreso(nombre, correo, contraseña)== 2){
            this.nombre=nombre;
            this.setAño(this.perfil(6));
            this.setCarrera(this.perfil(1));
            this.setDireccion(this.perfil(8));
            this.setEdad(this.perfil(2));
            this.setTelefono(this.perfil (7));
            return "faces/perfil.xhtml";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos incorrectos, ingrese nuevamente"));
        }
        return null;
    }
}
