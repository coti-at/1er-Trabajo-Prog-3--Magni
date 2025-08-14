public class Habitacion {
    private long id;
    private String nombre;
    private long metrosCuadrados;

    public Habitacion(long id, String nombre, long metrosCuadrados) {
        this.id = id;
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
    }

    public long getMetrosCuadrados() {
        return metrosCuadrados;
    }
}
