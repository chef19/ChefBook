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
    
    public Lista camino(E encontrar){
        Lista amigos = new Lista();
        for (int a = 0; a < this.lista.size(); a++){
            amigos.agregar(this.lista.obtenerElementoEnPosicion(a));
        }
        return amigos.recorrerAmigos(encontrar, amigos);
    }
}
