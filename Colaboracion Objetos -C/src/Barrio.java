import java.util.ArrayList;

public class Barrio {

    private long id;
    private String nombre;
    private String empresaConstructora;
    private ArrayList<Vivienda> viviendas;

    public Barrio(long id, String nombre, String empresaConstructora) {
        this.id = id;
        this.nombre = nombre;
        this.empresaConstructora = empresaConstructora;
        this.viviendas = new ArrayList<>();
    }

    public void agregarVivienda(Vivienda v) {
        viviendas.add(v);
    }


    public double getSuperficieTotalTerreno() {
        double total = 0;
        for (Vivienda v : viviendas) {
            total += v.getSuperficieTerreno();
        }
        return total;
    }


    public double getSuperficieTotalCubierta() {
        double total = 0;
        for (Vivienda v : viviendas) {
            total += v.getMetrosCuadradosCubiertos();
        }
        return total;
    }
}
