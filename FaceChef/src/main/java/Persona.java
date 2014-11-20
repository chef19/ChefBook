public class Persona {
    
    /**
     * Declaracion de variables a utilizar
     */
    public String nombre;
    public String carrera;
    public String fecha;
    public String correo;
    public String contraseña;
    public String carnet;
    public String año;
    public String telefono;
    public String direccion;
    public String foto;
    
    /**
     * Constructor de la clase
     * Se asignan los datos de los clientes 
     */
    public Persona(String nombre, String carrera, String edad, String correo, String contraseña, String carnet, String año, String telefono, String direccion, String foto){
        this.nombre = nombre;
        this.carrera = carrera;
        this.fecha = edad;
        this.correo = correo;
        this.contraseña = contraseña;
        this.carnet= carnet;
        this.año = año;
        this.telefono=telefono;
        this.direccion=direccion;
        this.foto=foto;
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
    
}