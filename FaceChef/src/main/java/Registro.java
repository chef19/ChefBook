
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
    private String fecha;
    @NotNull
    private String correo;
    @NotNull
    private String contraseña;
    @NotNull
    private String carnet;
    
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
    public void guardar (){
        if("".equals(nombre) || "".equals(carrera) || "".equals(fecha)  || "".equals(correo)  || "".equals(contraseña)  || "".equals(carnet)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Información necesaria faltante"));
    }
    else{
        Texto archivo = new Texto();
        Persona persona = new Persona (nombre,carrera,fecha,correo,contraseña,carnet);
        Nodo nuevo = new Nodo (persona);
        archivo.guardar(nombre, nombre+nl+carrera+nl+fecha+nl+correo+nl+contraseña+nl+carnet+nl+nuevo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente "+nombre+" "+contraseña+" "+carnet));
    }
}
    
}
