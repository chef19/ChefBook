public class Lista <E> {

    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int size;

    private class Nodo <E> {
        private Nodo anterior;
        private E dato;
        private Nodo siguiente;

        public Nodo() {
            this.anterior = null;
            this.dato = null;
            this.siguiente = null;
        }

        public Nodo(E inputDato) {
            this.siguiente = null;
            this.dato = inputDato;
            this.anterior = null;
        }

        public  E obtenerDato() {
            return dato;
           
        }

        public void establecerDato(E dato) {
            this.dato = dato;
        }

        public Nodo obtenerSiguiente(){
            return siguiente;
        }
        public Nodo obtenerAnterior() {
            return anterior;
        }

        public  void establecerSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public void establecerAnterior(Nodo anterior){
            this.anterior = anterior;
        }
    }

    public Lista () {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }

    public String toString() {
        Nodo nodoActual = this.primerNodo;
        StringBuffer resultado = new StringBuffer();
        for (int i = 0; nodoActual != null; i++)
        {
            if (i > 0)
            {
                resultado.append(",");
            }
            Object dato = nodoActual.obtenerDato();
            resultado.append(dato == null ? "" : dato);
            nodoActual = nodoActual.obtenerSiguiente();
        }
        return resultado.toString();
    }

    public <E> void agregar(E elemento) {
          Nodo nodo = new Nodo(elemento);
        if (this.size == 0)
        {
            this.primerNodo = nodo;
            this.ultimoNodo = nodo;
        }
        else
        {
            nodo.establecerAnterior(ultimoNodo);
            this.ultimoNodo.establecerSiguiente(nodo);
            this.ultimoNodo = nodo;
        }

        this.size++;
    }

    public <E> int obtenerIndice(E elemento) {
        Nodo nodoActual = this.primerNodo;
        int posicion = 0;
        boolean encontrado = false;

        for (; ; posicion++)
        {
            if (nodoActual == null)
            {
                break;
            }
            if (elemento.equals(nodoActual.obtenerDato()))
            {
                encontrado = true;
                break;
            }
            nodoActual = nodoActual.obtenerSiguiente();
        }
        if (!encontrado)
        {
            posicion = -1;
        }
        return posicion;
    }

    public int size() {
        return this.size;
    }

    public  Object obtenerElementoEnPosicion(int posicion)  {
        if (posicion >= this.size || posicion < 0)
        {
            return null;
        }
        Nodo nodoActual = this.primerNodo;
        for (int i = 0; i < posicion ; i++)
        {
            nodoActual = nodoActual.obtenerSiguiente();
        }
        return nodoActual.obtenerDato();
    }
    
    public void eliminar (E elemento){
        Nodo actual = this.primerNodo;
        for (int a = 0; a< size; a++){
            if (this.obtenerElementoEnPosicion(a) == elemento){
                if (this.primerNodo == actual){
                    if (this.primerNodo.siguiente == null && this.primerNodo.anterior == null){
                        this.primerNodo = null;
                        size--;
                        return;
                    }
                    else{
                        this.primerNodo = actual.siguiente;
                        actual.siguiente = null;
                        this.primerNodo.anterior = null;
                        size--;
                        this.imprimir();
                        return;
                    }
                }
                else if (this.ultimoNodo == actual){
                    this.ultimoNodo = actual.anterior;
                    actual.anterior = null;
                    this.ultimoNodo.siguiente = null;
                    size--;
                    return;
                }                          
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
                size--;
                return;
            }
            actual = actual.siguiente;
        }
    }
    
    public void imprimir(){
        for (int a = 0; a<size;a++){
            System.out.println(this.obtenerElementoEnPosicion(a));
        }
    }
    
    public Lista recorrerAmigos (E elemento, Lista amigos){
        for (int a = 0; a < this.size; a++){
            System.out.println("si despues del for");
            System.out.println(elemento+"  "+ this.obtenerElementoEnPosicion(a));
            if (elemento == this.obtenerElementoEnPosicion(a)){
                System.out.println("si");
                return amigos;
            }
            amigos.agregar(this.obtenerElementoEnPosicion(a));
        }
        System.out.println ("no");
        return amigos.recorrerAmigos(elemento, amigos);
    }
    
    public static void main (String [] args) {
        Lista lista = new Lista ();
        lista.agregar(2);
        lista.agregar(4);
        lista.agregar(7);
        lista.eliminar(7);
        lista.imprimir();
    }
}