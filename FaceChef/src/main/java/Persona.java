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
    
    /**
     * Constructor de la clase
     * Se asignan los datos de los clientes 
     */
    public Persona(String nombre, String carrera, String fecha, String correo, String contraseña, String carnet){
        this.nombre = nombre;
        this.carrera = carrera;
        this.fecha = fecha;
        this.correo = correo;
        this.contraseña = contraseña;
        this.carnet= carnet;
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