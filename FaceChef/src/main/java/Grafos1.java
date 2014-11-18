public class Grafos1 {
    
    private Lista <Nodo> listaNodos = new Lista <Nodo> ();
    private Lista amigos;
    private Lista camino;
    
    Grafos1 (){
        amigos= new Lista();
        camino= new Lista();
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
    
    public Lista camino (Nodo actual, Nodo buscado){
        return aux_camino (actual.lista,buscado);
    }
    
    public Lista aux_camino (Lista lista, Nodo buscado){
        for (int a = 0; a < lista.size(); a++){
            if (lista.obtenerElementoEnPosicion(a)== buscado){
                return camino;
            }
            else {
                camino.agregar((Nodo)lista.obtenerElementoEnPosicion(a));
                return camino ((Nodo)lista.obtenerElementoEnPosicion(a),buscado);
            }
        }
        return camino;
    }
    
    public Lista caminoEntre (Nodo actual, Nodo buscado){
        System.out.println("el nodo actual es"+actual);
        camino.agregar(actual);
        for (int a =0; a< actual.lista.size();a++){
            for (int b =0; b< actual.lista.size();b++){
                if (actual.lista.obtenerElementoEnPosicion(b)== buscado){
                    return camino;
                }
            }    
            if (((Nodo)actual.lista.obtenerElementoEnPosicion(a)).isRecorrido()){ // pregunta si esta recorrido
                if (((Nodo)actual.lista.obtenerElementoEnPosicion(a)) == buscado){
                    return camino;
                }
                else if ((Nodo)actual.lista.obtenerElementoEnPosicion(a+1)==null){ // pregunta si hay mas elementos para llamar
                    System.out.println("no hay mas elementos en este nodo continua al siguiente");
                }
                else{
                    return caminoEntre ((Nodo)actual.lista.obtenerElementoEnPosicion(a+1),buscado); //llama al siguiente que no se a recorrido
                }
            }
            else{
                actual.setRecorrido(true);
                if (((Nodo)actual.lista.obtenerElementoEnPosicion(a)) == buscado){
                    System.out.println("si lo encontro en el nodo "+actual);
                    return camino;
                }
                else if ((Nodo)actual.lista.obtenerElementoEnPosicion(a)!=null){ // pregunta si hay mas elementos para llamar
                    System.out.println("siguiente en la lista "+(Nodo)actual.lista.obtenerElementoEnPosicion(a));
                    return caminoEntre ((Nodo)actual.lista.obtenerElementoEnPosicion(a),buscado); //llama al siguiente que no se a recorrido
                }
                else{
                    return camino;
                }
            }
        }
        return camino;
    }
    
    public static void main (String [] args){
        Grafos1 grafo = new Grafos1();
        Nodo n1 = new Nodo(1);
        grafo.agregarNodo(n1);
        Nodo n2 = new Nodo(2);
        grafo.agregarNodo(n2);
        Nodo n3 = new Nodo(3);
        grafo.agregarNodo(n3);
        Nodo n4 = new Nodo(4);
        grafo.agregarNodo(n4);
        
        grafo.agregarRelacion(n1, n4);
        grafo.agregarRelacion(n2, n3);
        grafo.agregarRelacion(n2, n4);
        
        System.out.println("n1 "+n1);
        n1.imprimir();
        System.out.println("n2 "+n2);
        //n2.imprimir();
        System.out.println("n3 "+n3);
        //n3.imprimir();
        System.out.println("n4 "+n4);
        //n4.imprimir();
        System.out.println("..................");
        grafo.caminoEntre(n3, n2).imprimir();
        grafo.camino.vaciar();
        System.out.println("..................");
        grafo.caminoEntre(n4, n3).imprimir();
    }
}
