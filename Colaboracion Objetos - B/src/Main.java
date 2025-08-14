import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Esteban Quito De Las Mercedes Unidas", 20333444555L, "Shetland del sur 1235", "estebanquito@gmail.com");


        RegimenHorario horario = new RegimenHorario(9, 0, 18, 0, empleado);
        empleado.setRegimenHorario(horario);


        empleado.agregarAsistencia(new Asistencia(1, "E", LocalDate.of(2025, 8, 1), 9, 5, empleado));  // dentro de horario
        empleado.agregarAsistencia(new Asistencia(2, "E", LocalDate.of(2025, 8, 2), 9, 20, empleado)); // tardanza
        empleado.agregarAsistencia(new Asistencia(3, "E", LocalDate.of(2025, 8, 3), 8, 55, empleado)); // antes de horario


        List<Tardanza> tardanzasAgosto = empleado.getDiasConTardanza(8, 2025);


        System.out.println("Tardanzas de " + empleado.getAsistenciaXMesXAnio(8, 2025).get(0).getEmpleado().getNombre() + " en agosto 2025:");
        for (Tardanza t : tardanzasAgosto) {
            System.out.println("Fecha: " + t.getFecha() + " - Hora: " + t.getHora() + ":" + t.getMinuto());
        }
    }
}