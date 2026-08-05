import java.util.Arrays;

/**
 * Cola de prioridad implementada a mano como un Min-Heap binario sobre un
 * arreglo (prioridad 1 = mas critico = se atiende primero).
 * Complejidad: insertar/extraerMin en O(log n).
 */
public class ColaPrioridad {

    private Paciente[] heap;
    private int size;

    public ColaPrioridad(int capacidadInicial) {
        heap = new Paciente[capacidadInicial];
    }

    public void insertar(Paciente paciente) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = paciente;
        subirNodo(size);
        size++;
    }

    public Paciente atenderSiguiente() {
        if (estaVacia()) {
            throw new IllegalStateException("No hay pacientes en espera");
        }
        Paciente raiz = heap[0];
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        bajarNodo(0);
        return raiz;
    }

    public Paciente verSiguiente() {
        if (estaVacia()) {
            throw new IllegalStateException("No hay pacientes en espera");
        }
        return heap[0];
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void subirNodo(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (heap[i].getPrioridad() < heap[padre].getPrioridad()) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    private void bajarNodo(int i) {
        while (true) {
            int izquierdo = 2 * i + 1;
            int derecho = 2 * i + 2;
            int menor = i;

            if (izquierdo < size && heap[izquierdo].getPrioridad() < heap[menor].getPrioridad()) {
                menor = izquierdo;
            }
            if (derecho < size && heap[derecho].getPrioridad() < heap[menor].getPrioridad()) {
                menor = derecho;
            }
            if (menor == i) {
                break;
            }
            intercambiar(i, menor);
            i = menor;
        }
    }

    private void intercambiar(int i, int j) {
        Paciente temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void mostrarTodos() {
        if (estaVacia()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("- " + heap[i]);
        }
    }
}
