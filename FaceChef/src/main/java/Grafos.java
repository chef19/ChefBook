public class Grafos {
    
    private Lista <Nodo> listaNodos = new Lista <Nodo> ();
    private Lista amigos;
    
    Grafos (){
        amigos= new Lista();
    }
    
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
    
    public Lista caminoEntre (Nodo actual, Nodo queLlama, Nodo buscado){
        for (int a = 0; a < actual.lista.size();a++){
            System.out.println("despues del for");
            if (actual.lista.obtenerElementoEnPosicion(a) == buscado){
                amigos.agregar(actual);
                System.out.println("retorna aqui "+actual.lista.obtenerElementoEnPosicion(a)+" == "+ buscado);
                return amigos;
            }
            else if (actual.lista.obtenerElementoEnPosicion(a) == queLlama){
                if ((Nodo) actual.lista.obtenerElementoEnPosicion(a+1) == null){
                    System.out.println("si es quien lo llamo");
                    break;
                }
                return this.caminoEntre((Nodo) actual.lista.obtenerElementoEnPosicion(a+1), actual, buscado);
            }
            return this.caminoEntre((Nodo) actual.lista.obtenerElementoEnPosicion(a), actual, buscado);
        }
        return amigos;
    }
    
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
        
        grafo.agregarRelacion(n1, n4);
        grafo.agregarRelacion(n1, n3);
        grafo.agregarRelacion(n2, n4);
        
        
        /*
        System.out.println("n1 ");
        n1.imprimir();
        System.out.println("n2 ");
        n2.imprimir();
        System.out.println("n3 ");
        n3.imprimir();
        System.out.println("n4 ");
        n4.imprimir();
        */
        System.out.println(grafo.caminoEntre(n1, n1, n2).size());
        
    }
}
