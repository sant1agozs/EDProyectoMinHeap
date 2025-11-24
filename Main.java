import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();

        int opcion;

        do {
            System.out.println("\n===== MENÚ MIN-HEAP =====");
            System.out.println("1. Insertar número");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Mostrar mínimo (peek)");
            System.out.println("4. Crear heap desde arreglo (heapify)");
            System.out.println("5. Mostrar heap completo");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese número: ");
                    int num = sc.nextInt();
                    heap.insertar(num);
                    break;

                case 2:
                    Integer min = heap.eliminarMin();
                    if (min == null)
                        System.out.println("Heap vacío.");
                    else
                        System.out.println("Mínimo eliminado: " + min);
                    break;

                case 3:
                    Integer peek = heap.peek();
                    if (peek == null)
                        System.out.println("Heap vacío.");
                    else
                        System.out.println("Mínimo actual: " + peek);
                    break;

                case 4:
                    System.out.print("Cantidad de elementos: ");
                    int n = sc.nextInt();

                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Valor " + (i + 1) + ": ");
                        arr[i] = sc.nextInt();
                    }

                    heap.heapify(arr);
                    System.out.println("Heap creado con éxito.");
                    break;

                case 5:
                    heap.imprimir();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}