
//import com.sun.istack.internal.NotNull;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named (value="Registro")
@RequestScoped
public class Registro {
    @NotNull
    private String nombre;
    @NotNull
    private String carrera;
    @NotNull
    private String edad;
    @NotNull
    private String correo;
    @NotNull
    private String contraseña;
    @NotNull
    private String carnet;
    @NotNull
    private String año;
    @NotNull
    private String telefono;
    @NotNull
    private String direccion;
    @NotNull
    private String foto;
    
    
    String nl = System.getProperty("line.separator");

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

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

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }
    
    
    public void guardar (){
        if("".equals(nombre) || "".equals(carrera) || "".equals(edad)  || "".equals(correo)  || "".equals(contraseña)  || "".equals(carnet)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Información necesaria faltante"));
    }
    else{
        Texto archivo = new Texto();
        Persona persona = new Persona (nombre,carrera,edad,correo,contraseña,carnet);
        Nodo nuevo = new Nodo (persona);
        archivo.guardar(nombre, nombre+nl+carrera+nl+edad+nl+correo+nl+contraseña+nl+carnet+nl+nuevo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente "+nombre+" "+contraseña+" "+carnet));
    }
}
    
}
