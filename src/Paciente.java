public class Paciente {

    private final String nombre;
    private final int prioridad; // 1 = mas critico ... 5 = menos urgente

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return nombre + " (prioridad " + prioridad + ")";
    }
}
