public class Nodos {
    static Lista lista;
    
    Nodos (Nodo n){
        this.lista = new Lista ();
        lista.agregar(n);
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
