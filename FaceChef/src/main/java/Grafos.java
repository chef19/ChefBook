public class Grafos {
    
    public void agregarNodo (Nodo n){
        listaNodos.agregar (n);
    }
    
    public void agregarRelacion (Nodo n1, Nodo n2){
        n1.agregarRelacion(n2);
        n2.agregarRelacion(n1);
    }
    
    public void eliminiarRelacion (Nodo n1, Nodo n2){
        n1.eliminarRelacion(n2);
        n2.eliminarRelacion(n1);
    }
    
    public void hayRelacion (Nodo n1, Nodo n2){
        for (int i = 0; i < n1.lista.size(); i++){
            if (n1.lista.obtenerElementoEnPosicion(i) == n2){
                System.out.println("si");
                return;
            }
        }
        System.out.println("no");
    }
    
    private Lista <Nodo> listaNodos = new Lista <Nodo> ();
    
    public static void main (String [] args){
        Grafos grafo = new Grafos();
        Nodo n1 = new Nodo(1);
        grafo.agregarNodo(n1);
        Nodo n2 = new Nodo(2);
        grafo.agregarNodo(n2);
        Nodo n3 = new Nodo(3);
        grafo.agregarNodo(n3);
        Nodo n4 = new Nodo(4);
        grafo.agregarNodo(n4);
        
        grafo.agregarRelacion(n1, n2);
        grafo.agregarRelacion(n1, n3);
        grafo.agregarRelacion(n1, n4);
        grafo.eliminiarRelacion(n1, n3);
    }
}
