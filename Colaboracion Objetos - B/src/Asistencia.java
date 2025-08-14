import java.time.LocalDate;
import java.util.Date;

public class Asistencia {
    private long id;
    private String tipo;
    private LocalDate fecha;
    private int hora;
    private int minuto;
    private Empleado empleado;

    public Asistencia(long id,String tipo, LocalDate fecha, int hora, int minuto, Empleado empleado) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
        this.empleado = empleado;
    }

    public long getId() { return id; }

    public String getTipo() { return tipo; }

    public LocalDate getFecha() { return fecha; }

    public int getHora() { return hora; }

    public int getMinuto() { return minuto; }

    public Empleado getEmpleado() { return empleado; }
    


}
