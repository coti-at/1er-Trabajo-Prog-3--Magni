import java.util.ArrayList;
import java.util.List;

public class Empleado {
   private String nombre;
   private long cuit;
   private String domicilio;
   private String email;

   private RegimenHorario regimenHorario;
   private List<Asistencia>asistencias;
   private List<Tardanza> tardanzas;

    public Empleado(String nombre, long cuit, String domicilio, String email) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.email = email;
        this.asistencias = new ArrayList<>();
        this.tardanzas = new ArrayList<>();
    }

    public void setRegimenHorario(RegimenHorario regimenHorario) {
        this.regimenHorario = regimenHorario;
    }

    public void agregarAsistencia(Asistencia a) {
        asistencias.add(a);
    }

    public void agregarTardanza(Tardanza t) {
        tardanzas.add(t);
    }
    public String getNombre() {
        return nombre;
    }

    public List<Asistencia> getAsistenciaXMesXAnio(int mes, int anio) {
        List<Asistencia> filtradas = new ArrayList<>();
        for (Asistencia a : asistencias) {
            if (a.getFecha().getMonthValue() == mes && a.getFecha().getYear() == anio) {
                filtradas.add(a);
            }
        }
        return filtradas;
    }

    public List<Tardanza> getDiasConTardanza(int mes, int anio) {

        List<Tardanza> tardanzasDelMes = new ArrayList<>();
        List<Asistencia> asistenciasMes = getAsistenciaXMesXAnio(mes, anio);

        for (Asistencia a : asistenciasMes) {
            if ("E".equalsIgnoreCase(a.getTipo())) {
                int minutosAsistencia = a.getHora() * 60 + a.getMinuto();
                int minutosRegimen = regimenHorario.getHoraIngreso() * 60 + regimenHorario.getMinutoIngreso();

                if (minutosAsistencia - minutosRegimen > 15) {
                    Tardanza t = new Tardanza(
                            System.currentTimeMillis(),
                            a.getTipo(),
                            a.getFecha(),
                            a.getHora(),
                            a.getMinuto(),
                            this
                    );
                    tardanzasDelMes.add(t);
                    this.tardanzas.add(t);
                }
            }
        }
        return tardanzasDelMes;
    }


}
