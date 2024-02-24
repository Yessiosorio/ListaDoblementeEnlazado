public class ListaDobleEnlazada {
    NodoDoble inicio;
    NodoDoble fin;
    int tamaño;

    public ListaDobleEnlazada() {
        this.inicio = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public void insertarAlInicio(int dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.siguiente = inicio;
            inicio.anterior = nuevoNodo;
            inicio = nuevoNodo;
        }
        tamaño++;
    }

    public void insertarAlFinal(int dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
        tamaño++;
    }

    public void recorrerHaciaAdelante() {
        NodoDoble actual = inicio;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void recorrerHaciaAtras() {
        NodoDoble actual = fin;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    public void mostrarTamaño() {
        System.out.println("Tamaño de la lista: " + tamaño);
    }

    public void mostrarSiEstaVacia() {
        System.out.println("La lista está vacía: " + (tamaño == 0));
    }
    public void buscarElementoPorValor(int valor) {
        NodoDoble actual = inicio;
        int indice = 0;
        while (actual != null) {
            if (actual.dato == valor) {
                System.out.println("Elemento encontrado en el índice: " + indice);
                return;
            }
            actual = actual.siguiente;
            indice++;
        }
        System.out.println("Elemento no encontrado en la lista");
    }

    public void buscarElementoPorIndice(int indice) {
        if (indice < 0 || indice >= tamaño) {
            System.out.println("Índice fuera de rango");
            return;
        }

        NodoDoble actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }

        System.out.println("Elemento en el índice " + indice + ": " + actual.dato);
    }

    public void borrarElemento(int valor) {
        NodoDoble actual = inicio;
        while (actual != null) {
            if (actual.dato == valor) {
                if (actual.anterior == null) {
                    inicio = actual.siguiente;
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                } else if (actual.siguiente == null) {
                    fin = actual.anterior;
                    fin.siguiente = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                tamaño--;
                System.out.println("Elemento eliminado: " + valor);
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Elemento no encontrado en la lista");
    }
}




