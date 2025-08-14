import java.util.ArrayList;

public class Vivienda {
    private long id;
    private String calle;
    private int numeroCalle;
    private double superficieTerreno;
    private ArrayList<Habitacion> habitaciones;

    public Vivienda(long id, String calle, int numeroCalle, double superficieTerreno) {
        this.id = id;
        this.calle = calle;
        this.numeroCalle = numeroCalle;
        this.superficieTerreno = superficieTerreno;
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public double getMetrosCuadradosCubiertos() {
        double total = 0;
        for (Habitacion h : habitaciones) {
            total += h.getMetrosCuadrados();
        }
        if (total > superficieTerreno) {
            System.out.println("Error: La superficie cubierta no puede ser mayor a la del terreno.");
            return superficieTerreno;
        }
        return total;
    }

    public double getSuperficieTerreno() {
        return superficieTerreno;
    }
}
