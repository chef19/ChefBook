
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
    
    public void mensaje (){
        if("".equals(nombre) || "".equals(contraseña) || "".equals(carnet)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Información necesaria faltante"));
    }
    else{
        ArrayList list = new ArrayList();
        list.add(this.nombre);
        list.add(this.contraseña);
        list.add(this.carnet);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nombre+" "+contraseña+" "+carnet));
    }
}
    
}
