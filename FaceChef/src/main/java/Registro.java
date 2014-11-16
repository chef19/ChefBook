
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
    private String contraseña;
    @NotNull
    private String carnet;
    
    public String getB() {
        return nombre;
    }

    public void setB(String nombre) {
        this.nombre = nombre;
    }

    public String getC() {
        return contraseña;
    }

    public void setC(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String getD() {
        return carnet;
    }

    public void setD(String carnet) {
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
