import java.util.Scanner;

public class Main {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final ColaPrioridad sala = new ColaPrioridad(10);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            try {
                switch (opcion) {
                    case 1 -> registrarPaciente();
                    case 2 -> atenderPaciente();
                    case 3 -> System.out.println("Siguiente en atenderse: " + sala.verSiguiente());
                    case 4 -> sala.mostrarTodos();
                    case 0 -> System.out.println("Hasta luego.");
                    default -> System.out.println("Opcion invalida.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SALA DE EMERGENCIAS - Prioridad (1=critico, 5=leve) ===");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Atender al paciente mas prioritario");
        System.out.println("3. Ver quien sigue");
        System.out.println("4. Ver todos los pacientes en espera");
        System.out.println("0. Salir");
    }

    private static void registrarPaciente() {
        System.out.print("Nombre del paciente: ");
        String nombre = TECLADO.nextLine();
        int prioridad = leerEntero("Prioridad (1=critico ... 5=leve): ");
        sala.insertar(new Paciente(nombre, prioridad));
        System.out.println("Paciente registrado.");
    }

    private static void atenderPaciente() {
        Paciente atendido = sala.atenderSiguiente();
        System.out.println("Atendiendo a: " + atendido);
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!TECLADO.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            TECLADO.next();
        }
        int valor = TECLADO.nextInt();
        TECLADO.nextLine();
        return valor;
    }
}
