public class Nodo <E>{
        
    private E dato;
    public Lista <Nodo <E>> lista;

    public Nodo (E dato){
        this.dato = dato;
        this.lista = new Lista <Nodo <E>> ();
    }
    
    public E obtenerDato(){
        return dato;
    }

    public void agregarRelacion (Nodo n){
        this.lista.agregar (n);
    }

    public void eliminarRelacion (Nodo n){
       this.lista.eliminar(n);
    }
    
    public void imprimir (){
        this.lista.imprimir();
    }
}
