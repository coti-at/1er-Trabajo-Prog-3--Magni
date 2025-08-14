import java.util.*;

public class Main {
    public static void main(String[] args) {

        Habitacion h1 = new Habitacion(1, "Cocina", 20);
        Habitacion h2 = new Habitacion(2, "Dormitorio", 30);
        Habitacion h3 = new Habitacion(3, "Living", 25);

        Habitacion h4 = new Habitacion(4, "Cocina", 15);
        Habitacion h5 = new Habitacion(5, "Dormitorio", 20);


        Vivienda v1 = new Vivienda(1, "Calle A", 123, 100.0);
        v1.agregarHabitacion(h1);
        v1.agregarHabitacion(h2);
        v1.agregarHabitacion(h3);

        Vivienda v2 = new Vivienda(2, "Calle B", 456, 60.0);
        v2.agregarHabitacion(h4);
        v2.agregarHabitacion(h5);


        Barrio b1 = new Barrio(1, "Barrio Primavera", "Constructora XYZ");
        b1.agregarVivienda(v1);
        b1.agregarVivienda(v2);


        System.out.println("Superficie total de terreno del barrio: " + b1.getSuperficieTotalTerreno());
        System.out.println("Metros cuadrados cubiertos de v1: " + v1.getMetrosCuadradosCubiertos());
        System.out.println("Metros cuadrados cubiertos de v2: " + v2.getMetrosCuadradosCubiertos());
        System.out.println("Superficie total cubierta del barrio: " + b1.getSuperficieTotalCubierta());

    }
}