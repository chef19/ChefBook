public class Grafos {
    
    private Lista <Nodo> listaNodos = new Lista <Nodo> ();
    private Lista amigos;
    private Lista camino;
    
    Grafos (){
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
        this.caminoEntre(actual, buscado);
        this.falseRecorrido();
        return camino;
    }
    
    public void falseRecorrido (){
        for (int a =0; a< this.listaNodos.size();a++){
            ((Nodo)this.listaNodos.obtenerElementoEnPosicion(a)).setRecorrido(false);
        }
    }
    
    public Lista caminoEntre (Nodo actual, Nodo buscado){
        //System.out.println("actual es: "+actual);
        if (this.camino.obtenerElementoEnPosicion(this.camino.size()-1) == buscado){
            return camino;
        }
        camino.agregar(actual);
        for (int a =0; a< actual.lista.size();a++){
            for (int b =0; b< actual.lista.size();b++){
                if (actual.lista.obtenerElementoEnPosicion(b)== buscado){
                    ((Nodo)actual.lista.obtenerElementoEnPosicion(b)).setRecorrido(true);
                    //System.out.println("termino en: "+actual);
                    //this.falseRecorrido();
                    camino.agregar((Nodo)actual.lista.obtenerElementoEnPosicion(b));
                    return camino;
                }
                //System.out.println("fue recorrido: "+actual);
                
                if (!((Nodo)actual.lista.obtenerElementoEnPosicion(b)).isRecorrido()){
                    actual.setRecorrido(true);
                    //System.out.println("no ha sido recorrido");
                    this.caminoEntre((Nodo)actual.lista.obtenerElementoEnPosicion(b),buscado);
                }
                
            }
            //System.out.println("se enciclo aqui");
            //this.caminoEntre((Nodo)actual.lista.obtenerElementoEnPosicion(a),buscado);
                
                
                /*
                if ((Nodo)actual.lista.obtenerElementoEnPosicion(b)!=null){ // pregunta si hay mas elementos para llamar
                    this.caminoEntre ((Nodo)actual.lista.obtenerElementoEnPosicion(b),buscado); //llama al siguiente que no se a recorrido
                }
                else{
                    return camino;
                }
                this.caminoEntre((Nodo)actual.lista.obtenerElementoEnPosicion(b), buscado);*/
            }
        return camino;
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
        
        Nodo n5 = new Nodo(5);
        grafo.agregarNodo(n5);
        
        grafo.agregarRelacion(n1, n4);
        grafo.agregarRelacion(n2, n3);
        grafo.agregarRelacion(n2, n4);

        System.out.println("n1 "+n1);
        System.out.println("n2 "+n2);
        System.out.println("n3 "+n3);
        System.out.println("n4 "+n4);
        System.out.println("n5 "+n5);

        //grafo.caminoEntre(n3, n2).imprimir();
        grafo.camino.vaciar();
        System.out.println("..................");
        
        grafo.camino(n3, n5);
        System.out.println(grafo.camino.hayCamino(n4));
        grafo.camino.vaciar();
        
        
    }
}
