public class Nodos {
    static Lista lista;
    
    Nodos (){
        this.lista = new Lista ();
    }

    public Lista getLista() {
        return lista;
    }
    
    public void agregar (Nodo n){
        this.lista.agregar(n);
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
