import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // -----------------------------
    //  INSERTAR
    // -----------------------------
    public void insertar(int valor) {
        heap.add(valor);               // Se agrega al final
        upHeapify(heap.size() - 1);    // Reordenar hacia arriba
    }

    // -----------------------------
    //  UPHEAPIFY (sube)
    // -----------------------------
    private void upHeapify(int index) {

        while (index > 0) {
            int padre = (index - 1) / 2;

            if (heap.get(index) < heap.get(padre)) {
                // Intercambio
                int temp = heap.get(index);
                heap.set(index, heap.get(padre));
                heap.set(padre, temp);

                index = padre; // seguir subiendo
            } else {
                break;
            }
        }
    }

    // -----------------------------
    //  ELIMINAR MIN
    // -----------------------------
    public Integer eliminarMin() {

        if (heap.isEmpty()) {
            return null;
        }

        int min = heap.get(0);

        // mover el último a la raíz
        int ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0);
        }

        return min;
    }

    // -----------------------------
    //  DOWNHEAPIFY (baja)
    // -----------------------------
    private void downHeapify(int index) {
        int size = heap.size();

        while (true) {
            int izq = 2 * index + 1;
            int der = 2 * index + 2;
            int menor = index;

            if (izq < size && heap.get(izq) < heap.get(menor)) {
                menor = izq;
            }

            if (der < size && heap.get(der) < heap.get(menor)) {
                menor = der;
            }

            if (menor != index) {
                int temp = heap.get(index);
                heap.set(index, heap.get(menor));
                heap.set(menor, temp);
                index = menor;
            } else {
                break;
            }
        }
    }

    // -----------------------------
    //  PEEK
    // -----------------------------
    public Integer peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    // -----------------------------
    //  HEAPIFY (Dado un arreglo desordenado)
    // -----------------------------
    public void heapify(int[] arr) {
        heap.clear();
        for (int valor : arr) {
            heap.add(valor);
        }

        // aplicar downHeapify desde el último padre
        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    // -----------------------------
    //  Mostrar heap (opcional)
    // -----------------------------
    public void imprimir() {
        System.out.println(heap);
    }
}