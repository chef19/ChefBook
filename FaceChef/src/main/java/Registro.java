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
    private String carrera;
    private String edad;
    @NotNull
    private String correo;
    @NotNull
    private String contraseña;
    private String carnet;
    private String año;
    private String telefono;
    private String direccion;
    private String foto;
    private static Lista lista;
    
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
    
    public void iniciar (){
        lista = new Lista ();
    }
    
    public String guardar (){
        if("".equals(nombre) || "".equals(carrera) || "".equals(edad)  || "".equals(correo)  || "".equals(contraseña)  || 
           "".equals(carnet) || "".equals(año) || "".equals(telefono) || "".equals(direccion)){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Información necesaria faltante"));
        }
        else{
            Texto archivo = new Texto();
            Persona persona = new Persona (nombre,  carrera,  edad,  correo, contraseña, carnet, año, telefono, direccion, foto);
            Nodo nuevo = new Nodo (persona);
            this.lista.agregar(nuevo);
            archivo.guardar(nombre, nombre+nl+ carrera+nl+  edad+nl+  correo+nl+ contraseña+nl+ carnet+nl+ año+nl+ telefono+nl+ direccion+nl+ foto+nl+nuevo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente "+nombre+" "+contraseña+" "+carnet));
            return "faces/inicio.xhtml";
        }
        return null;
    }
    
    public String amigo (String correo){
        for (int a=0; a<this.lista.size();a++){
           if(((Persona)((Nodo)this.lista.obtenerElementoEnPosicion(a)).getDato()).getCorreo().equals(correo)){
               this.nombre = ((Persona)((Nodo)this.lista.obtenerElementoEnPosicion(a)).getDato()).getNombre();
               return "faces/amigo.xhtml";
           }
        }
        return null;
    }
}
