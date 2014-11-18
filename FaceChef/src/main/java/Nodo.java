public class Nodo <E>{
        
    private E dato;
    public boolean recorrido;
    public Lista <Nodo <E>> lista;

    public Nodo (E dato){
        this.recorrido = false;
        this.dato = dato;
        this.lista = new Lista <Nodo <E>> ();
    }
    
    public E obtenerDato(){
        return dato;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public boolean isRecorrido() {
        return recorrido;
    }

    public void setRecorrido(boolean recorrido) {
        this.recorrido = recorrido;
    }

    public Lista<Nodo<E>> getLista() {
        return lista;
    }

    public void setLista(Lista<Nodo<E>> lista) {
        this.lista = lista;
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
